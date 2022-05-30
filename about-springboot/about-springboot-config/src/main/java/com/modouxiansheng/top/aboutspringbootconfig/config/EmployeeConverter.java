package com.modouxiansheng.top.aboutspringbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 18:16
 **/
@Component
@ConfigurationPropertiesBinding
public class EmployeeConverter implements Converter<String,Employee> {
    @Override
    public Employee convert(String source) {

        String[] data = source.split(",");
        return new Employee(data[0],Double.parseDouble(data[1]));
    }
}
