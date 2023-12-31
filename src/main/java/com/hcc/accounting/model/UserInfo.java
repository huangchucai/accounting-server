package com.hcc.accounting.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class UserInfo {
    private Long id;
    private String userName;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 获取用户信息
     *
     * @param id         用户id
     * @param userName   用户名
     * @param password   密码
     * @param createTime 创建时间
     * @param updateTime 更新时间
     */
    public UserInfo(Long id, String userName, String password, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
