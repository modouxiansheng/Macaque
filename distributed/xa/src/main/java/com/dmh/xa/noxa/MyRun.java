package com.dmh.xa.noxa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 12:44
 **/
@Component
@Slf4j
public class MyRun implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    @Qualifier("jdbcTemplateSecond")
    private JdbcTemplate jdbcTemplateSecond;

    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    private JdbcTemplate jdbcTemplatePrimary;


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
