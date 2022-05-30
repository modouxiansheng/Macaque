package com.modouxiansheng.top.aboutspringbootconfig.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 18:15
 **/
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private double salary;
}
