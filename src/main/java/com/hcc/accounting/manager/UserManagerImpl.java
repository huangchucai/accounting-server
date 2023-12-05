package com.hcc.accounting.manager;

import com.hcc.accounting.converter.dtb.UserInfoDTBConverter;
import com.hcc.accounting.dao.UserDao;
import com.hcc.accounting.model.bo.UserInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private final UserDao userDao;
    private final UserInfoDTBConverter userInfoDTBConverter;

    @Autowired
    public UserManagerImpl(UserDao userDao, UserInfoDTBConverter userInfoDTBConverter) {
        this.userDao = userDao;
        this.userInfoDTBConverter = userInfoDTBConverter;
    }

    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        val userInfoDo = userDao.getUserInfoById(userId);
        return userInfoDTBConverter.convert(userInfoDo);
    }
}
