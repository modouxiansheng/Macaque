package com.dmh.xa.mybatis;


import com.dmh.xa.common.Utils;
import com.dmh.xa.noxa.DistributedTransactionNoXa;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dmh.xa.mybatis.mapper")
public class MybatisPlugs {

    public static void main(String[] args) {
        Utils.loadPropertySource(MybatisPlugs.class, "mybatis-plugs.properties");
        SpringApplication.run(MybatisPlugs.class, args);
    }
}
