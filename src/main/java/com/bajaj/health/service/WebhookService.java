package com.bajaj.health.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sakshi (GitHub: Sakshi-Git22)
 * @email sakshi1339.be22@chitkarauniversity.edu.in
 */
@Service
public class WebhookService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WebhookService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public void startWorkflow() {
        try {
            System.out.println("=================================================");
            System.out.println("BFH Qualifier Application");
            System.out.println("Created by: Ankita");
            System.out.println("GitHub ID: AnkitaMANDAL0");
            System.out.println("Email: ankita1069.be22@chitkarauniversity.edu.in");
            System.out.println("=================================================");
            
            System.out.println("Step 1: Sending POST request to generate webhook...");
            String generateWebhookUrl = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
            
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("name", "Ankita");
            requestBody.put("regNo", "REG12347");
            requestBody.put("email", "ankita1069.be22@chitkarauniversity.edu.in");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(generateWebhookUrl, request, String.class);
            System.out.println("Response Status: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());

            System.out.println("\nStep 2: Parsing response to extract webhook URL and access token...");
            JsonNode responseJson = objectMapper.readTree(response.getBody());
            String webhookUrl = responseJson.get("webhook").asText();
            String accessToken = responseJson.get("accessToken").asText();

            System.out.println("Webhook URL: " + webhookUrl);
            System.out.println("Access Token: " + accessToken);

            System.out.println("\nStep 3: Generating placeholder SQL query...");
            String finalQuery = "SELECT * FROM patients WHERE age > 60";
            System.out.println("Generated Query: " + finalQuery);

            System.out.println("\nStep 4: Sending final POST request to webhook URL...");
            
            Map<String, String> finalRequestBody = new HashMap<>();
            finalRequestBody.put("finalQuery", finalQuery);

            HttpHeaders finalHeaders = new HttpHeaders();
            finalHeaders.setContentType(MediaType.APPLICATION_JSON);
            finalHeaders.setBearerAuth(accessToken);

            HttpEntity<Map<String, String>> finalRequest = new HttpEntity<>(finalRequestBody, finalHeaders);

            ResponseEntity<String> finalResponse = restTemplate.postForEntity(webhookUrl, finalRequest, String.class);
            System.out.println("Final Response Status: " + finalResponse.getStatusCode());
            System.out.println("Final Response Body: " + finalResponse.getBody());

            System.out.println("\n=================================================");
            System.out.println("Workflow completed by: Ankita (AnkitaMANDAL0)");
            System.out.println("=================================================");

        } catch (Exception e) {
            System.err.println("Error occurred during workflow: " + e.getMessage());
            System.err.println("Contact: ankita1069.be22@chitkarauniversity.edu.in");
            e.printStackTrace();
        }
    }
} 
