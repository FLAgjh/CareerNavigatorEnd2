package org.SETrain.CareerNavigator.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Map; // Added import for Map
import java.util.Date; // Added import for Date
import java.text.SimpleDateFormat; // Added import for SimpleDateFormat

import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Entity.Resume;
import org.SETrain.CareerNavigator.Entity.ResumeAssessmentRecord;
import org.SETrain.CareerNavigator.Service.ResumeService;
import org.SETrain.CareerNavigator.Service.ResumeAssessmentRecordService;
import org.SETrain.CareerNavigator.Util.ThreadLocalUtil; // Added import for ThreadLocalUtil
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeService resumeService;
    private final ResumeAssessmentRecordService recordService;

    public ResumeController(ResumeService resumeService, ResumeAssessmentRecordService recordService) {
        this.resumeService = resumeService;
        this.recordService = recordService;
    }

    @Operation(summary = "高级简历评估")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "评估成功"),
        @ApiResponse(responseCode = "500", description = "AI服务异常或处理错误")
    })
    @PostMapping("/advanced-assess")
    public Result assessResume(@RequestBody String resumeContent) {
        try {
            // 通过线程本地存储获取用户信息
            Map<String, Object> claims = ThreadLocalUtil.get();
            String username = (String) claims.get("username"); 

            // 创建新简历记录
            Resume newResume = new Resume();
            newResume.setUsername(username);
            newResume.setContent(resumeContent);
            newResume.setTitle("高级评估简历-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            newResume.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            
            Resume savedResume = resumeService.createResume(newResume); // 持久化获取ID
            Integer resumeId = savedResume.getId(); // 获取真实生成的简历ID

            // Step 3: Perform the AI assessment on the resume content
            String jsonResult = resumeService.assessResume(resumeContent); // Or use savedResume.getContent()

            // Step 4: Create the assessment record using the actual resumeId
            // The constructor for ResumeAssessmentRecord is (Integer resumeId, String assessmentResult, Date assessmentTime)
            // The ResumeAssessmentRecordServiceImpl will set the assessmentTime if null is passed.
            ResumeAssessmentRecord record = new ResumeAssessmentRecord(resumeId, jsonResult, null);
            recordService.createRecord(record);

            return Result.success(jsonResult);
        } catch (Exception e) {
            // Log the exception e.printStackTrace(); or use a logger
            return Result.error("Error during advanced resume assessment: " + e.getMessage());
        }
    }

    // Other existing CRUD methods for Resume
    @PostMapping("/create")
    @Operation(summary = "创建简历")
    public Result createResume(@RequestBody Resume resume) {
        // Ensure createtime is set if not provided by client
        if (resume.getCreatetime() == null || resume.getCreatetime().isEmpty()) {
            resume.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        Resume createdResume = resumeService.createResume(resume);
        return Result.success(createdResume);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取简历")
    public Result getResumeById(@PathVariable Integer id) {
        Resume resume = resumeService.getResumeById(id);
        return resume != null ? Result.success(resume) : Result.error("简历不存在");
    }

    @PutMapping("/update")
    @Operation(summary = "更新简历")
    public Result updateResume(@RequestBody Resume resume) {
        Resume updatedResume = resumeService.updateResume(resume);
        return Result.success(updatedResume);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除简历")
    public Result deleteResume(@PathVariable Integer id) {
        resumeService.deleteResume(id);
        return Result.success();
    }

    @GetMapping("/list/{username}")
    @Operation(summary = "根据用户名获取简历列表")
    public Result getResumeListByUser(@PathVariable String username) {
        List<Resume> resumeList = resumeService.getResumeListByUser(username);
        return Result.success(resumeList);
    }
}