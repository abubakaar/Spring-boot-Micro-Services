package com.practice.microservices.practicepropertyaccessservice.bean;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "property-file")   // pre-fix of Property file in Git
public class PropertyAccessBean {

    private String name;
    private String description;

}
