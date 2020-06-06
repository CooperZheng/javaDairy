package com.qianfeng.service;

import com.qianfeng.dao.PermissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDAO permissionDAO;

    @Transactional
    public Set<String> queryAllPermissionByUsername(String username) {
        long t1 = new Date().getTime();
        for (int i = 0; i < 100; i++) {
            permissionDAO.queryAllPermissionByUsername(username+i);
        }
        System.out.println(new Date().getTime()-t1);
        return permissionDAO.queryAllPermissionByUsername(username);
    }
}
