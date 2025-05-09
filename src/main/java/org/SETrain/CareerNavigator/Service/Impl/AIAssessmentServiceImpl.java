package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Service.AIAssessmentService;  // 新增独立接口
import org.SETrain.CareerNavigator.client.DeepSeekClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AIAssessmentServiceImpl implements AIAssessmentService {  // 改为实现独立接口
    private final DeepSeekClient deepSeekClient;

    // 移除ResumeService依赖
    public AIAssessmentServiceImpl(DeepSeekClient deepSeekClient) {
        this.deepSeekClient = deepSeekClient;
    }

    @Override
    public String assessResume(String resumeContent) {
        return deepSeekClient.evaluateResume(resumeContent);
    }
}