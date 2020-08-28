package com.dmh.xa.hasxa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 12:44
 **/
@Component
public class MyRun implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.printInfo("更新之前的数据为",false);
        try {
            orderService.add();
        }catch (Exception e){
            e.printStackTrace();
        }
        orderService.printInfo("更新之后的数据为",true);
    }
}
