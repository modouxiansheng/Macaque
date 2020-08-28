package com.dmh.xa.noxa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDS")
    @ConfigurationProperties("hpf.primary.datasource")
    @Primary
    public DataSource primaryDS(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondaryDS")
    @ConfigurationProperties("hpf.secondary.datasource")
    public DataSource secondaryDS(){
        return DataSourceBuilder.create().build();
    }
}