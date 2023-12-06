package com.hcc.accounting.dao;

import com.hcc.accounting.dao.mapper.UserInfoMapper;
import com.hcc.accounting.model.dao.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {
    @Mock
    UserInfoMapper userInfoMapper;

    @InjectMocks
    private UserDaoImpl userDao;

    @Test
    void testGetUserInfoByUserId() {
        // Arrange
        Long userId = 100L;
        val userInfo = UserInfo.builder()
                               .id(100L)
                               .userName("test")
                               .build();
        when(userInfoMapper.getUserInfoById(userId)).thenReturn(userInfo);

        // Act
        val result = userDao.getUserInfoById(userId);

        // Assert
        assert result.equals(userInfo);
        verify(userInfoMapper, times(1)).getUserInfoById(userId);
    }
}
