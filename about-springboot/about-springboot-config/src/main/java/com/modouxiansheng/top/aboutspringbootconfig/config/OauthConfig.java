package com.modouxiansheng.top.aboutspringbootconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 17:39
 **/
@ConfigurationProperties("oauth")
@Data
@Configuration
public class OauthConfig {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private Map<String,String> extMap;
    private List<String> whiteNames;
}
