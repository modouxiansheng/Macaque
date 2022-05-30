package com.modouxiansheng.top.aboutspringbootconfig.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-30 09:00
 **/
@ConstructorBinding
@AllArgsConstructor
@Getter
@ToString
@ConfigurationProperties(prefix = "constructor")
public class ConstructorBindingData {

    private String name;

    private Integer age;
}
