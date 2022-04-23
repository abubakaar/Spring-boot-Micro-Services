package com.practice.microservices.practicepropertyaccessservice.controller;


import com.practice.microservices.practicepropertyaccessservice.bean.PropertyAccessBean;
import com.practice.microservices.practicepropertyaccessservice.bean.PropertyAccessValue;
import com.practice.microservices.practicepropertyaccessservice.service.demoService;
import org.springframework.core.env.Environment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/access")
public class PropertyAccessFileController {

    @Autowired
    PropertyAccessBean propertyAccessBean;

    @Autowired
    private demoService demo;

    @Autowired
    private Environment environment;

    private RestTemplate restTemplate = new RestTemplate();


    @PostMapping("/refresh")
    public void Refresh(@RequestBody String s) {
        try {
            System.out.println("here");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8100/actuator/busrefresh", entity, String.class);
            System.out.println(response.getStatusCode().getReasonPhrase());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error here");
        }
    }

    @GetMapping("/accesspropertyfile")
    public PropertyAccessValue accessValue() {
        demo.test();
//        System.out.println(SpropertyAccessBean.getJdbcUrl());

        return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
    }


    @EventListener({
            RefreshRemoteApplicationEvent.class,
            ApplicationReadyEvent.class,
            RefreshScopeRefreshedEvent.class})
    public void refresh() {
        System.out.println("the new value is " + this.readValue());
    }

    private String readValue() {
        return this.environment.getProperty("property-file.name");
    }

}
