package com.modouxiansheng.top.aboutspringbootconfig;

import com.modouxiansheng.top.aboutspringbootconfig.config.ConstructorBindingData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConstructorBindingData.class)
public class AboutSpringbootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutSpringbootConfigApplication.class, args);
    }

}
