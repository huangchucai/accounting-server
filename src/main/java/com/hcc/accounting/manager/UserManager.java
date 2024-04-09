package com.hcc.accounting.manager;

import com.hcc.accounting.model.bo.UserInfo;
import com.hcc.accounting.model.vo.LoginRequest;

/**
 * User Manager(业务逻辑层)
 */
public interface UserManager {
    /**
     * 根据用户id获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    UserInfo getUserInfoByUserId(Long userId);

    /**
     * Login with specific login request
     * @param request
     * @return JWT token
     */
    String login(LoginRequest request);
}
