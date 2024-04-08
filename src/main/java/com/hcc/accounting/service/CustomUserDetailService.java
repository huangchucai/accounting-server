package com.hcc.accounting.service;

import com.hcc.accounting.dao.UserDao;
import com.hcc.accounting.model.LoginUser;
import com.hcc.accounting.model.dao.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public CustomUserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.getUserInfoByUsername(username);
        return LoginUser.builder()
                        .userInfo(userInfo)
                        .build();
    }
}
