package com.modouxiansheng.top.aboutspringbootconfig.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.SystemProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 16:19
 **/
@SpringBootTest
public class ValueConfigTest {

    @Value("stringValue")
    private String value;

    @Value("${value.file.name}")
    private String fileName;

    @Value("${value.file.unKnownFileName : unKnownFileName}")
    private String unKnownFileName;

    @Value("${listOfValues}")
    private String[] valuesArray;

    @Value("${listOfValues}")
    private List<String> valuesList;

    @Value("#{${mapOfValue}}")
    private Map<String,String> mapOfValue;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{systemProperties['xxxx']?:'defalut value'}")
    private String systemPropertiesUnknown;

    @Value("#{systemProperties}")
    private Map<String,String> systemPropertiesMap;

    @Autowired
    private User user;

    @Value("#{user.userName}")
    private String userName;

    @Autowired
    private ValueConfig valueConfig;

    @Test
    public void testValueGet(){
        System.out.println(value);
        System.out.println(fileName);
        System.out.println(unKnownFileName);
        System.out.println(valuesArray);
        System.out.println(valueConfig.getPriority());
        System.out.println(valueConfig.getValues().toString());
    }

}
