package com.hcc.accounting.converter.dtb;

import com.google.common.base.Converter;
import com.hcc.accounting.model.dao.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDTBConverter extends Converter<UserInfo, com.hcc.accounting.model.bo.UserInfo> {

    @Override
    protected com.hcc.accounting.model.bo.UserInfo doForward(UserInfo userInfo) {
        return com.hcc.accounting.model.bo.UserInfo.builder()
                                                   .id(userInfo.getId())
                                                   .userName(userInfo.getUserName())
                                                   .password(userInfo.getPassword())
                                                   .build();
    }

    @Override
    protected UserInfo doBackward(com.hcc.accounting.model.bo.UserInfo userInfo) {
        return UserInfo.builder()
                       .id(userInfo.getId())
                       .userName(userInfo.getUserName())
                       .password(userInfo.getPassword())
                       .build();
    }
}
