package com.dmh.distributedseata.customer.config;

import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean(name = "secondaryDS")
    @ConfigurationProperties("hpf.secondary.datasource")
    public DataSource secondaryDS(){
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource secondaryDS){
        return new DataSourceProxy(secondaryDS);
    }

}