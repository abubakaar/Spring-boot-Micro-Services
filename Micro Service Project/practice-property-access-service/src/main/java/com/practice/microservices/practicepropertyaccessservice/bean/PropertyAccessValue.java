package com.practice.microservices.practicepropertyaccessservice.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PropertyAccessValue {

    private String name;
    private String description;

}
