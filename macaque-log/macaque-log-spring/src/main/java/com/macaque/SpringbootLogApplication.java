package com.macaque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLogApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SpringbootLogApplication.class);

        SpringApplication.run(SpringbootLogApplication.class, args);
    }

}
