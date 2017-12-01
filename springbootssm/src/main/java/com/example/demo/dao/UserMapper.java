package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Mapper
@Repository
public interface UserMapper {
	 User selectUserByName(String name);
}
