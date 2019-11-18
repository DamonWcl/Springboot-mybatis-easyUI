package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {
    int add(User user);

    String list(Integer correction);

    int delete(String ids);
}
