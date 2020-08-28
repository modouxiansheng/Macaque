package com.dmh.xa.noxa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 19:22
 **/
@Configuration
public class DataSourceTransactionManagerConfig {
    @Bean(name = "datasource")
    public DataSourceTransactionManager regTransactionManager(@Qualifier("primaryDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
