package com.dmh.distributedseata.order.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 10:28
 **/
@Configuration
public class JdbcTemplateConfig {


    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("primaryDS")DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return new JdbcTemplate(dataSource);
    }


}
