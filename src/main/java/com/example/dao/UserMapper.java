package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserMapper {
    int add(User user);

    List<User> list(Integer correction);

    Long queryTotal(Integer correction);

    int edit(User user);

    int delete(List<String> list);
}
