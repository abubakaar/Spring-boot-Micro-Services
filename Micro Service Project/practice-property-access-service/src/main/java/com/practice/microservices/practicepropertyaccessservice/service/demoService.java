package com.practice.microservices.practicepropertyaccessservice.service;

import com.practice.microservices.practicepropertyaccessservice.Entity.DemoEntity;
import com.practice.microservices.practicepropertyaccessservice.Repo.dummyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class demoService {

    @Autowired
    private dummyrepo dummyrepo;

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate;

    public void test() {

//        List<DemoEntity> d = dummyrepo.findAll();
//        System.out.println(d.get(0).username);

        List<DemoEntity> res = jdbcTemplate.query(
                "select * from user",
                (rs, rowNum) ->
                        new DemoEntity(rs.getInt("id"),
                                rs.getString("username"))
        );

        System.out.println(res.get(0).username);
        System.out.println(jdbcTemplate.getDataSource());
    }


}
