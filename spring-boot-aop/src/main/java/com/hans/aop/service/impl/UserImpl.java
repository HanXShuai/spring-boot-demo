package com.hans.aop.service.impl;

import com.hans.aop.service.UserService;
import com.hans.base.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: hans
 * @Date: 2021/12/2 21:49
 */
@Service
@Slf4j
public class UserImpl implements UserService {

    @Override
    public User findUser(Long id) {
        User user = new User(1L, "tom", "man");
        log.info("find user : {}", user.toString());
        return user;
    }
}
