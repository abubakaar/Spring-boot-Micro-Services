package com.practice.microservices.practicepropertyaccessservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Builder
public class DemoEntity {

    @Id
    public int id;
    public String username;

}
