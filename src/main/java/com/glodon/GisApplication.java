package com.glodon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class GisApplication {
    public static void main(String[] args) {
        SpringApplication.run(GisApplication.class, args);
    }
}
