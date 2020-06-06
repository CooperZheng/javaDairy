package com.qianfeng.dao;

import com.qianfeng.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    User queryUserByUsername(@Param("username") String username);
    Integer insertUser(User user);
}
