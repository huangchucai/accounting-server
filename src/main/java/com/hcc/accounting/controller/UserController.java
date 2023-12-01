package com.hcc.accounting.controller;

import com.hcc.accounting.exception.InValidParameterException;
import com.hcc.accounting.exception.ResourceNotFoundException;
import com.hcc.accounting.mapper.UserInfoMapper;
import com.hcc.accounting.model.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
@Tag(name = "用户相关接口", description = "用户管理的相关接口")
public class UserController {

    UserInfoMapper userInfoMapper;

    @Autowired
    public UserController(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @GetMapping(path = "v1/users/{id}")
    @Operation(summary = "根据用户id获取用户信息", description = "返回相应的用户信息",
               responses = {@ApiResponse(responseCode = "200", description = "获取用户信息成功"), @ApiResponse(
                       responseCode = "404", description = "用户不存在")})
    public ResponseEntity<?> getUserInfoById(@Parameter(description = "具体的用户id") @PathVariable Long id) {
        //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userInfoMapper.getUserInfoById(id));
        //        return ResponseEntity.status(HttpStatus.OK).header("name", "hcc").body(userInfoMapper.getUserInfoById(id));
        if (id < 0L) {
            throw new InValidParameterException("id不能小于0");
        }

        val userInfo = Optional.ofNullable(userInfoMapper.getUserInfoById(id))
                               .orElseThrow(() -> new ResourceNotFoundException(String.format("用户id为%s的用户不存在", id)));

        return ResponseEntity.ok(userInfo);
    }
}
