package com.macaque.pect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: macaque-log
 * @description:
 * @author: hu_pf
 * @create: 2021-03-30 10:42
 **/
@Component
public class CommonConfig implements CommandLineRunner {

    @Autowired
    private TestService testService;


    @Override
    public void run(String... strings) throws Exception {
        testService.run();
    }
}
