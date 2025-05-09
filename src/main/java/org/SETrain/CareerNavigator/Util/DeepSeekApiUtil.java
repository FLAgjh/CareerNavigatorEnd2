package org.SETrain.CareerNavigator.Util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.List; // Add this missing import

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 添加Component注解，使Spring管理该Bean
public class DeepSeekApiUtil {
    // 从application.yml读取配置
    @Value("${deepseek.base-url}")
    private String baseUrl;

    @Value("${deepseek.api-key}")
    private String apiKey;

    private static final RestTemplate restTemplate = new RestTemplate();

    public String callAi(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey); // 使用注入的apiKey

        Map<String, Object> requestBody = new HashMap<>();
        // 建议使用application.yml中配置的model（当前配置为deepseek-chat）
        requestBody.put("model", "deepseek-chat"); // 与application.yml保持一致
        requestBody.put("messages", List.of(Map.of("role", "user", "content", question)));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
            baseUrl + "/chat/completions", // 使用注入的baseUrl
            request,
            Map.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            // 修正：choices 是列表，需先转为 List<Map>
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            if (choices != null && !choices.isEmpty()) {
                Map<String, Object> firstChoice = choices.get(0);
                Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");
                if (message != null) {
                    return (String) message.get("content"); // 从 message 中获取 content 字段
                }
            }
        }
        return "AI调用失败：" + response.getStatusCodeValue();
    }
}