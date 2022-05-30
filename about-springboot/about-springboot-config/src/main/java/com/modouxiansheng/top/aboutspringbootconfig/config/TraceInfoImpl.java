package com.modouxiansheng.top.aboutspringbootconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-30 09:06
 **/
@Data
@ConfigurationProperties(prefix = "trace")
public class TraceInfoImpl implements TraceInfo{

    private String traceId;

    private String traceName;

    @Override
    public String getTraceId() {
        return this.traceId;
    }

    @Override
    public String getTraceName() {
        return this.traceName;
    }
}
