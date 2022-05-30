package com.modouxiansheng.top.aboutspringbootconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-30 09:09
 **/
@Component
public class TraceGetConfig {

    @Bean
    public TraceInfo traceInfo(){
        return new TraceInfoImpl();
    }
}
