package com.dmh.mybatis;

import com.dmh.mybatis.dao.OrderDto;
import com.dmh.mybatis.dao.UserDto;
import com.dmh.mybatis.mapper.OrderMapper;
import com.dmh.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test(){
		UserDto userDto = userMapper.selectById(Integer.valueOf(1));
		System.out.printf("1");
	}



}
