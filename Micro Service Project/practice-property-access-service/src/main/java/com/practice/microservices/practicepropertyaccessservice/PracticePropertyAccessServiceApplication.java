package com.practice.microservices.practicepropertyaccessservice;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticePropertyAccessServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticePropertyAccessServiceApplication.class, args);
    }

//    @Bean
//    ApplicationRunner runner() {
//        return args -> System.getenv().forEach((k, v) -> System.out.println(k + "=" + v));
//    }

}
