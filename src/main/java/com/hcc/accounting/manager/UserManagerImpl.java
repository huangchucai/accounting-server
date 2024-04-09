package com.hcc.accounting.manager;

import com.hcc.accounting.converter.dtb.UserInfoDTBConverter;
import com.hcc.accounting.dao.UserDao;
import com.hcc.accounting.model.bo.UserInfo;
import com.hcc.accounting.model.vo.LoginRequest;
import com.hcc.accounting.utils.JWTUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private final UserDao userDao;
    private final UserInfoDTBConverter userInfoDTBConverter;

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserManagerImpl(UserDao userDao,
                           UserInfoDTBConverter userInfoDTBConverter,
                           UserDetailsService userDetailsService,
                           AuthenticationManager authenticationManager) {
        this.userDao = userDao;
        this.userInfoDTBConverter = userInfoDTBConverter;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        val userInfoDo = userDao.getUserInfoById(userId);
        return userInfoDTBConverter.convert(userInfoDo);
    }

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 利用Spring security认证
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        // 认证成功后生产JWT
        return JWTUtil.generateToken(userDetails.getUsername());
    }
}
