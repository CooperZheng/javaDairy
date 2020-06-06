package com.qianfeng.service;

import com.qianfeng.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUsers();
    Integer insertUser(User user);
    User queryUserByUsername(String username);
}
