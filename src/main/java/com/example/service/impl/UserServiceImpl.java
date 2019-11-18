package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public int add(User user) {
        String id = user.getId();
        if (id == null || "".equals(id)) {
            //添加
            return userMapper.add(user);
        } else {
            //修改
            return userMapper.edit(user);
        }
        //return userMapper.add(user);
    }

    @Override
    public String list(Integer correction) {
        Long total = userMapper.queryTotal(correction);
        List<User> list = userMapper.list(correction);

        JSONObject object = new JSONObject();
        JSONArray array = null;
        object.put("total",total);
        array =JSONArray.parseArray(JSON.toJSONString(list));
        object.put("rows",array);
        return object.toString();//188 5176 0464
    }

    @Override
    @Transactional
    public int delete(String ids) {
        String[] arr = ids.split(",");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            list.add(temp);
        }
        return userMapper.delete(list);
    }
}
