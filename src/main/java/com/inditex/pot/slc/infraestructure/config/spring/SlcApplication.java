package com.inditex.pot.slc.infraestructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(
    scanBasePackages = "com.inditex.pot.slc.infraestructure")
public class SlcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SlcApplication.class, args);
    }

}
