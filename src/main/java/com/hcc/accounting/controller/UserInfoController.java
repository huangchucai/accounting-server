package com.hcc.accounting.controller;

import com.hcc.accounting.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoController(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @GetMapping(path = "v1/users/{id}")
    public com.hcc.accounting.model.UserInfo getUserInfoById(@PathVariable  Long id) {
        return userInfoMapper.getUserInfoById(id);
    }
}
