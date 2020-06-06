package com.qianfeng.dao;

import com.qianfeng.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description: TODO
 * @Author 臧红久
 * @Date 2019/10/15
 * @Version V1.0
 **/
public interface UserDAO {
    List<User> selectAllUsers();
    Integer insertUser(User user);
    User queryUserByUsername(@Param("username") String username);
    //Integer selectUserByUsername(@Param("username")String username);
}
