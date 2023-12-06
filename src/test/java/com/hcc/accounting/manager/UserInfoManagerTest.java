package com.hcc.accounting.manager;

import com.hcc.accounting.converter.dtb.UserInfoDTBConverter;
import com.hcc.accounting.dao.UserDao;
import com.hcc.accounting.model.dao.UserInfo;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * 老版的mockito, 没有使用@ExtendWith(MockitoExtension.class)
 */
public class UserInfoManagerTest {
    @Mock
    private UserDao userDao;

    private UserManagerImpl userManager;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        UserInfoDTBConverter converter = new UserInfoDTBConverter();
        userManager = new UserManagerImpl(userDao, converter);
    }

    @Test
    void getGetUserInfoByUserId() {
        // Arrange
        Long userid = 10L;
        val userInfoDo = UserInfo.builder().id(userid).userName("hcc").build(); // do
        doReturn(userInfoDo).when(userDao).getUserInfoById(userid);

        // Act
        val result = userManager.getUserInfoByUserId(userid); // bo
        System.out.println(result);

        // Assert
        assert result.getId().equals(userid);
        assert result.getUserName().equals("hcc");
        verify(userDao).getUserInfoById(userid);

    }
}
