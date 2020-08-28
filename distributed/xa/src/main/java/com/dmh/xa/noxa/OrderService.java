package com.dmh.xa.noxa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 10:55
 **/
@Service
@Slf4j
public class OrderService {

    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    private JdbcTemplate jdbcTemplatePrimary;

    @Autowired
    private OrderServiceTwo orderServiceTwo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    @Qualifier("jdbcTemplateSecond")
    private JdbcTemplate jdbcTemplateSecond;


    @Transactional(rollbackFor = RollBackExceptionNoXa.class,transactionManager = "datasource")
    public void add() throws RollBackExceptionNoXa {
        jdbcTemplatePrimary.execute("update orders set code = 2 ,quantity = 2");
//        orderServiceTwo.add();
        customerService.add();
    }


    public void printInfo(String msg,Boolean flag){

        List<Map<String, Object>> ordersMap = jdbcTemplatePrimary.queryForList("select * from orders");
        List<Map<String, Object>> ordersTwoMap = jdbcTemplatePrimary.queryForList("select * from orders_2");
        List<Map<String, Object>> customerMap = jdbcTemplateSecond.queryForList("select * from customer");
        log.info(msg+": orders: {},orders_2: {},customer: {}",ordersMap,ordersTwoMap,customerMap);

        if (flag){
            jdbcTemplatePrimary.execute("update orders set code = 1 ,quantity = 1");
            jdbcTemplatePrimary.execute("update orders_2 set code = 1 ,quantity = 1");
            jdbcTemplateSecond.execute("update customer set name = 1,age = 1");
        }
    }
}
