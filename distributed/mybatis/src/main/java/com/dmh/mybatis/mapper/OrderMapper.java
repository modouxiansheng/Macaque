package com.dmh.mybatis.mapper;

import com.dmh.mybatis.dao.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    OrderDto selectOrder(@Param("venderId") Long venderId);
}
