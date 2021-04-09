package com.macaque.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.macaque.LoggerLevelModifier;
import com.macaque.SpringbootLogApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-15 21:16
 **/
@RestController
public class LogController {

    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/update/{level}")
    private String updateLog(@PathVariable("level") String level){
        LoggerLevelModifier.init();
        LoggerLevelModifier.setLogLevel("root",level);
        return "success";
    }

    @RequestMapping("/log")
    public void log(){
        logger.info("xxxxxxxxxxxxx");
    }
}
