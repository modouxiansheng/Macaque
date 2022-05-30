package com.modouxiansheng.top.aboutspringbootconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 18:37
 **/
@ConfigurationProperties(prefix = "conversion")
@Configuration
@Data
public class Conversion {

    private Employee employee;
}
