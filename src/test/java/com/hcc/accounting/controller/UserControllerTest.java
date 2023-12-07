package com.hcc.accounting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcc.accounting.converter.btv.UserInfoBTVConverter;
import com.hcc.accounting.exception.BizErrorCode;
import com.hcc.accounting.exception.ErrorResponse;
import com.hcc.accounting.exception.GlobalExceptionHandler;
import com.hcc.accounting.exception.ServiceException;
import com.hcc.accounting.manager.UserManager;
import com.hcc.accounting.model.vo.UserInfo;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private MockMvc mockMvc;
    @Mock
    UserManager userManager;

    @Mock
    UserInfoBTVConverter converter;

    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                                 .setControllerAdvice(new GlobalExceptionHandler())
                                 .build();
    }
    @Test
    void testGetUserInfoById() throws Exception {
        // Arrange
        Long userId = 1L;
        val userInfoVo = UserInfo.builder().id(userId).userName("hcc").build();
        val userInfoBo = com.hcc.accounting.model.bo.UserInfo.builder().id(userId).userName("hcc").build();

        when(userManager.getUserInfoByUserId(userId)).thenReturn(userInfoBo);
        doReturn(userInfoVo).when(converter).convert(userInfoBo);
//        when(converter.convert(userInfoBo)).thenReturn(userInfoVo);


        // Act && Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users/" + userId)
                                              .contentType("application/json")
                                              .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
               .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(userInfoVo)));

        verify(userManager).getUserInfoByUserId(eq(userId));
        verify(converter).convert(eq(userInfoBo));

    }

    @Test
    void testGetUserInfoWithInvalidUserId() throws Exception {
        Long userId = -100L;
        val err = ErrorResponse.builder()
                               .statusCode(400)
                               .message("id不能小于0")
                               .errorType(ServiceException.ErrorType.CLIENT_ERROR)
                               .errorCode(BizErrorCode.INVALID_PARAMETER)
                               .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users/" + userId)
                                              .contentType("application/json")
                                              .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(MockMvcResultMatchers.status().is4xxClientError())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
               .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(err)));

        verify(userManager, never()).getUserInfoByUserId(eq(userId));
        verify(converter, never()).convert(any());
    }

    @Test
    void testGetUserInfoWithWithNoUserFound() throws Exception {
        Long userId = 100L;
        val err = ErrorResponse.builder()
                               .statusCode(400)
                               .message(String.format("用户id为%s的用户不存在", userId))
                               .errorType(ServiceException.ErrorType.CLIENT_ERROR)
                               .errorCode(BizErrorCode.INVALID_PARAMETER)
                               .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users/" + userId)
                                              .contentType("application/json")
                                              .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
               .andExpect(MockMvcResultMatchers.status().is4xxClientError())
               .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
               .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(err)));

        verify(userManager).getUserInfoByUserId(eq(userId));
        verify(converter, never()).convert(any());
    }
}
