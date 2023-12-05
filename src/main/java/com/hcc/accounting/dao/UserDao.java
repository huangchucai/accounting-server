package com.hcc.accounting.dao;

import com.hcc.accounting.model.dao.UserInfo;

public interface UserDao {
    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    UserInfo getUserInfoById(Long id);
}
