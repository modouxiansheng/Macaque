package com.dmh.xa.mybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDS")
    @ConfigurationProperties("hpf.secondary.datasource")
    @Primary
    public DataSource primaryDS(){
        return DataSourceBuilder.create().build();
    }
}