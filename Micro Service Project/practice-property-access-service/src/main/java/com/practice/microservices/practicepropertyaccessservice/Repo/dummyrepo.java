package com.practice.microservices.practicepropertyaccessservice.Repo;

import com.practice.microservices.practicepropertyaccessservice.Entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dummyrepo extends JpaRepository<DemoEntity, Integer> {


}
