package com.hcc.accounting.manager;

import com.hcc.accounting.model.bo.UserInfo;

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
}
