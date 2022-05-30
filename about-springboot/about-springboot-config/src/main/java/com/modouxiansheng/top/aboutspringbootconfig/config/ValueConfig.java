package com.modouxiansheng.top.aboutspringbootconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: about-springboot
 * @description:
 * @author: hu_pf
 * @create: 2022-05-27 16:18
 **/
@Service
public class ValueConfig {

    private String priority;



    public ValueConfig(
            @Value("priority") String priority){
        this.priority = priority;
    }

    public String getPriority(){
        return priority;
    }

    private List<String> values;

    @Value("${listOfValues}")
    public void setListOfValue(List<String> values){
        this.values = values;
    }

    public List<String> getValues(){
        return values;
    }

}
