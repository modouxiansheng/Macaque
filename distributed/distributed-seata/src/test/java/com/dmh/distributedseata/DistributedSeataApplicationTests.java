package com.dmh.distributedseata;

import com.dmh.distributedseata.order.OrderServer;
import com.dmh.distributedseata.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServer.class)
public class DistributedSeataApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testQuery(){
        orderService.invoke();
    }
}
