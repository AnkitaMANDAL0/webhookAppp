package com.example.bfh.service;

import com.example.bfh.model.WebhookResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WebhookService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void executeWorkflow() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> body = Map.of(
            "name", "John Doe",
            "regNo", "REG12347",
            "email", "john@example.com"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<WebhookResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, request, WebhookResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            WebhookResponse webhookResponse = response.getBody();
            String webhook = webhookResponse.getWebhook();
            String token = webhookResponse.getAccessToken();

            String finalQuery = getSqlQueryForRegNo("REG12347");

            sendSqlQuery(webhook, finalQuery, token);
        } else {
            System.err.println("Webhook generation failed!");
        }
    }

    private String getSqlQueryForRegNo(String regNo) {
        int lastDigit = Character.getNumericValue(regNo.charAt(regNo.length() - 1));
        if (lastDigit % 2 == 0) {
            return "SELECT * FROM patients WHERE status = 'active';";
        } else {
            return "SELECT * FROM appointments WHERE date >= CURDATE();";
        }
    }

    private void sendSqlQuery(String webhook, String finalQuery, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        Map<String, String> body = Map.of("finalQuery", finalQuery);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(webhook, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("SQL query submitted successfully.");
        } else {
            System.err.println("SQL submission failed!");
        }
    }
}
