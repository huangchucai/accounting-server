package com.hcc.accounting.mapper;

import com.hcc.accounting.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select id, username, password, create_time, update_time  from ms_userinfo where id = #{id}")
    public UserInfo getUserInfoById(Long id);
}
