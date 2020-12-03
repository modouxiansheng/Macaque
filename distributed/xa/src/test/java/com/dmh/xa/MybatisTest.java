package com.dmh.xa;


import com.dmh.xa.mybatis.MybatisPlugs;
import com.dmh.xa.mybatis.dao.OrderDto;
import com.dmh.xa.mybatis.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlugs.class)
public class MybatisTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test(){
        OrderDto orderDto = orderMapper.selectOrder(Long.valueOf("11111"));
        System.out.printf("1");
    }
}
