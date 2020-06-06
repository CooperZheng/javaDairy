package com.qianfeng.service;

import com.qianfeng.constant.MyConstant;
import com.qianfeng.dao.UserDAO;
import com.qianfeng.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author 臧红久
 * @Date 2019/10/15
 * @Version V1.0
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public Integer insertUser(User user) {
        // 加盐——加密 注册
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        String s = new Sha256Hash(user.getPassword(), salt, MyConstant.ITERCOUNT).toBase64();
        user.setPassword(s);
        return userDAO.insertUser(user);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }

}
