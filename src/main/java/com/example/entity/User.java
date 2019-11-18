package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String role;
    private int delFlag;
}
