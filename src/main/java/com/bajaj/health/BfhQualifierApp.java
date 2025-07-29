package com.bajaj.health;

import com.bajaj.health.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sakshi (GitHub: Sakshi-Git22)
 * @email sakshi1339.be22@chitkarauniversity.edu.in
 */
@SpringBootApplication
public class BfhQualifierApp implements CommandLineRunner {

    @Autowired
    private WebhookService webhookService;

    public static void main(String[] args) {
        System.out.println("Starting BFH Qualifier Application...");
        System.out.println("Author: Sakshi (GitHub: Sakshi-Git22)");
        System.out.println("Email: sakshi1339.be22@chitkarauniversity.edu.in");
        System.out.println();
        
        SpringApplication.run(BfhQualifierApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting BFH Qualifier workflow...");
        webhookService.startWorkflow();
        System.out.println("BFH Qualifier workflow completed successfully!");
    }
} 