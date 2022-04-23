package com.example.testingeurekaclient1;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class TestingEurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(TestingEurekaClient1Application.class, args);
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("/greetingTest")
    public String greetingTest() {
        String url = discoveryClient.getNextServerFromEureka("APP_2", false).getHomePageUrl();
        return restTemplate().getForEntity(url + "/greeting", String.class).getBody();
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return "I'm first app";
    }
}
