package com.example.Katas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Katas")
public class KatasApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatasApplication.class, args);
    }

}
