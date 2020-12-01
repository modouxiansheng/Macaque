package com.dmh.distributedseata.order.service;

import com.dmh.distributedseata.order.feign.CustomerApi;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("orderService")
@Slf4j
public class OrderService {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerApi customerApi;

//    @GlobalTransactional(name = "order",rollbackFor = Exception.class) //此注解开启全局事务
    public void invoke(){

        // 更新order表
//        updateOrder();
        jdbcTemplate.execute("update orders set code = 2 ,quantity = 2");
        // 远程调用更新customer表
        customerApi.invokeCustomer();
    }

    public void init(){
        jdbcTemplate.execute("update orders set code = 1 ,quantity = 1");

        customerApi.init();
    }

    public String query(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from orders");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(maps.toString()+"/n");

        String customerQuery = customerApi.query();
        stringBuilder.append(customerQuery);
        return stringBuilder.toString();
    }

    public void updateOrder(){
        jdbcTemplate.execute("update orders set code = 2 ,quantity = 2");
    }
}
