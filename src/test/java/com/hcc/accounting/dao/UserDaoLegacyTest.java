package com.hcc.accounting.dao;

import com.hcc.accounting.dao.mapper.UserInfoMapper;
import com.hcc.accounting.model.dao.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class UserDaoLegacyTest {
    @Test
    @Disabled
    void testGetUserInfoByUserid() {
        // Arrange
        Long userId = 100L;
        val userInfo = UserInfo.builder()
                               .id(100L)
                               .userName("test")
                               .build();
        // Act
        UserInfoMapper userInfoMapper = new UserInfoMapper() {
            @Override
            public UserInfo getUserInfoById(Long id) {
                return userInfo;
            }

            @Override
            public UserInfo getUserInfoByUsername(String username) {
                return userInfo;
            }
        };

        // Assert
        UserDao userDao = new UserDaoImpl(userInfoMapper);
        UserInfo actualUserInfo = userDao.getUserInfoById(userId);
        assert actualUserInfo.equals(userInfo);
    }
}
