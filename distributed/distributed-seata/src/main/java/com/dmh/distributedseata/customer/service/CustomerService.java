package com.dmh.distributedseata.customer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void invoke(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jdbcTemplate.execute("update customer set name = 2,age = 2");
    }

    public void init(){
        jdbcTemplate.execute("update customer set name = 1,age = 1");
    }

    public String query(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from customer");
        return maps.toString();
    }
}
