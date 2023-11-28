package com.hcc.accounting.converter.btv;

import com.google.common.base.Converter;
import com.hcc.accounting.model.bo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserInfoBTVConverter extends Converter<UserInfo, com.hcc.accounting.model.vo.UserInfo> {
    @Override
    protected com.hcc.accounting.model.vo.UserInfo doForward(UserInfo userInfo) {
        return com.hcc.accounting.model.vo.UserInfo.builder()
                                                   .id(userInfo.getId())
                                                   .userName(userInfo.getUserName())
                                                   .build();
    }

    @Override
    protected UserInfo doBackward(com.hcc.accounting.model.vo.UserInfo userInfo) {
        return UserInfo.builder().id(userInfo.getId()).userName(userInfo.getUserName()).build();
    }
}
