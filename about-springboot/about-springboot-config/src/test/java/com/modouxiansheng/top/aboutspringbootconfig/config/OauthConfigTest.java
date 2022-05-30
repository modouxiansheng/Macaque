package com.modouxiansheng.top.aboutspringbootconfig.config;

import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 17:40
 **/
@SpringBootTest
public class OauthConfigTest {

    @Autowired
    private OauthConfig oauthConfig;

    @Autowired
    private Item item;

    @Autowired
    private Conversion conversion;

    @Test
    public void testConfig(){

        System.out.println(oauthConfig.toString());
        System.out.println(item.toString());
        System.out.println(conversion.getEmployee().toString());
    }
}
