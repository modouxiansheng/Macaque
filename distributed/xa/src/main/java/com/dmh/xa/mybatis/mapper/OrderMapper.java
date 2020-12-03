package com.dmh.xa.mybatis.mapper;

import com.dmh.xa.mybatis.dao.OrderDto;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    OrderDto selectOrder(@Param("venderId") Long venderId);
}
