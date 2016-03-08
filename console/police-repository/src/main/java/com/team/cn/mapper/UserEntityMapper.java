package com.team.cn.mapper;

import com.team.cn.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityMapper {

    public UserEntity selectByUser(UserEntity userEntity);
}