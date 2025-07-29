package com.example.bfh;

import com.example.bfh.service.WebhookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BfhApplication implements CommandLineRunner {

    private final WebhookService webhookService;

    public BfhApplication(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BfhApplication.class, args);
    }

    @Override
    public void run(String... args) {
        webhookService.executeWorkflow();
    }
}
