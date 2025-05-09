package org.SETrain.CareerNavigator.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeepSeekClient {
    @Value("${deepseek.api-key}")
    private String apiKey;

    @Value("${deepseek.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String evaluateResume(String resumeContent) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestBody = String.format("""
            {
                "model": "deepseek-chat",
                "messages": [
                    {
                        "role": "system",
                        "content": "你是一个专业HR，请从专业技能匹配度、项目经验、教育背景、格式规范等维度进行简历评估，返回JSON格式：{score: 0-100, analysis: string, suggestions: string[]}"
                    },
                    {
                        "role": "user",
                        "content": "%s"
                    }
                ]
            }
            """, resumeContent.replace("\"", "\\\""));

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                baseUrl + "/chat/completions",
                HttpMethod.POST,
                entity,
                String.class);

        return response.getBody();
    }
}