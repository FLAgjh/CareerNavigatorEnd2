package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Entity.Job;
import org.SETrain.CareerNavigator.Mapper.JobMapper;
import org.SETrain.CareerNavigator.Service.JobService;
import org.SETrain.CareerNavigator.Util.DeepSeekApiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// Add missing imports
import org.springframework.web.client.RestClientException;  // For RestClientException
import com.fasterxml.jackson.core.JsonProcessingException;  // For JsonProcessingException

@Service
public class JobServiceImpl implements JobService {
    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
    @Autowired
    private JobMapper jobMapper;
    @Autowired  // Add this line to inject DeepSeekApiUtil
    private DeepSeekApiUtil deepSeekApiUtil;

    @Override
    public List<Job> getAllJobs() {
        return jobMapper.findAllJobs();
    }

    @Override
    public Job getJobById(Integer id) {
        return jobMapper.findJobById(id);
    }

    @Override
    public String analyzeJob(Integer jobId) {
        Job job = jobMapper.findJobById(jobId);
        if (job == null) {
            logger.warn("职位解读失败，未找到岗位信息，jobId={}", jobId);
            return "未找到该岗位信息";
        }
        try {
            String question = "请分析该职位的职责、要求和发展前景：" + job.getJobdescription();
            logger.info("开始调用AI分析职位，jobId={}, 提问内容：{}", jobId, question);
            String aiResult = deepSeekApiUtil.callAi(question);  // Use injected instance
            logger.info("AI分析职位成功，jobId={}, 结果：{}", jobId, aiResult);
            return aiResult;
        } catch (RestClientException e) { 
            logger.error("AI接口网络异常，jobId={}, 异常信息：{}", jobId, e.getMessage(), e);
            return "AI接口网络异常：" + e.getMessage();
        } catch (Exception e) { 
            logger.error("职位解读失败，jobId={}, 异常信息：{}", jobId, e.getMessage(), e);
            return "职位解读失败：" + e.getMessage();
        }
    }

    @Override
    public List<Job> matchJobs(String userSkills, Integer expectedSalary, String location) {
        String question = String.format(
            "用户技能：%s，期望薪资：%d元/月，期望地点：%s。请匹配3个最符合的职位（返回ID列表）",
            userSkills, expectedSalary, location
        );
        try {
            logger.info("开始调用AI匹配职位，用户技能={}, 期望薪资={}, 地点={}", userSkills, expectedSalary, location);
            String aiResult = deepSeekApiUtil.callAi(question);  // Use injected instance
            logger.info("AI返回匹配结果：{}", aiResult);
            List<Integer> jobIds = parseJobIds(aiResult);
            return jobMapper.findJobsByIds(jobIds);
        } catch (Exception e) {
            logger.error("职位匹配失败，用户技能={}, 期望薪资={}, 地点={}, 异常信息：{}", 
                        userSkills, expectedSalary, location, e.getMessage(), e);
            return List.of(); 
        }
    }

    private List<Integer> parseJobIds(String aiResult) {
        try {
            if (aiResult == null || aiResult.isEmpty()) {
                logger.warn("AI返回职位ID列表为空");
                return List.of();
            }
            return Arrays.stream(aiResult.replaceAll("[^0-9,]", "").split(","))
                .filter(idStr -> !idStr.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            logger.error("解析AI返回的职位ID失败，原始结果：{}，异常信息：{}", aiResult, e.getMessage());
            return List.of(); 
        }
    }
}