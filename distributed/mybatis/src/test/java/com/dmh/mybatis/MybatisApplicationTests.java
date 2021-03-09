package com.dmh.mybatis;

import com.dmh.mybatis.dao.UserDto;
import com.dmh.mybatis.mapper.OrderMapper;
import com.dmh.mybatis.mapper.UserMapper;
import com.dmh.mybatis.transaction.TransactionOrder;
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
	private UserMapper userMapper;

	@Autowired
	private TransactionOrder transactionOrder;

	@Test
	public void test(){
		UserDto userDto = userMapper.selectById(Integer.valueOf(1));
		System.out.printf("1");
	}

	@Test
	public void testInsert(){
		UserDto userDto = new UserDto();
		userDto.setName("hu"+Math.random());
		userDto.setUser("hu"+Math.random());
		userMapper.insertUser(userDto);
	}

	@Test
	public void testUpdate(){
		transactionOrder.updateOrder();
	}
}
