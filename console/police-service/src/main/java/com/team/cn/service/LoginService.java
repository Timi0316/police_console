package com.team.cn.service;

import com.team.cn.domain.User;
import com.team.cn.entity.UserEntity;
import com.team.cn.mapper.UserEntityMapper;
import com.team.cn.utils.ConsoleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pein on 2016/3/1.
 */
@Service
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserEntityMapper userEntityMapper;

    public User login(String name, String password) {
        logger.info("LoginService : begin to login from LoginService");
        UserEntity paramEntity = new UserEntity();
        paramEntity.setName(name);
        paramEntity.setPassword(password);
        UserEntity resultEntity = userEntityMapper.selectByUser(paramEntity);

        logger.info("the login user = {} . ",resultEntity);
        if (resultEntity == null) {
            return null;
        }
        return ConsoleUtils.copyProperties(resultEntity, User.class);
    }
}
