package org.SETrain.CareerNavigator.Controller;

import org.SETrain.CareerNavigator.Entity.Job;
import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public Result<List<Job>> getAllJobs() {  // Parameterized Result with List<Job>
        return Result.success(jobService.getAllJobs());
    }

    /**
     * 根据 ID 查询单个岗位信息
     * @param id 岗位 ID
     * @return 岗位信息或错误提示
     */
    @GetMapping("/{id}")
    public Result<Job> getJobById(@PathVariable Integer id) {  // Parameterized Result with Job
        Job job = jobService.getJobById(id);
        return job != null ? Result.success(job) : Result.error("未找到对应岗位信息");
    }

    /**
     * 职位解读接口（调用AI生成结构化解读）
     * @param jobId 岗位ID
     * @return 解读文本（如格式错误返回错误提示）
     */
    @GetMapping("/analyze/{jobId}")
    public Result<String> analyzeJob(@PathVariable Integer jobId) {
        String analysis = jobService.analyzeJob(jobId);
        return analysis.contains("失败") ? Result.error(analysis) : Result.success(analysis);
    }

    /**
     * 职位匹配接口（根据用户需求智能推荐）
     * @param userSkills 用户掌握的技能（逗号分隔）
     * @param expectedSalary 期望薪资（单位：元）
     * @param location 期望工作地点
     * @return 匹配的岗位列表（可能为空）
     */
    @PostMapping("/match")
    public Result<List<Job>> matchJobs(
            @RequestParam String userSkills,
            @RequestParam Integer expectedSalary,
            @RequestParam String location) {
        List<Job> matchedJobs = jobService.matchJobs(userSkills, expectedSalary, location);
        return matchedJobs.isEmpty() ? Result.error("无匹配职位") : Result.success(matchedJobs);
    }
}