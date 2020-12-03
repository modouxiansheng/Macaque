package com.dmh.mybatis.mapper;

import com.dmh.mybatis.dao.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDto selectById (@Param("id") Integer id);

    void insertUser(UserDto userDto);
}
