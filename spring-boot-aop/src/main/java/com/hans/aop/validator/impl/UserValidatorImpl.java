package com.hans.aop.validator.impl;

import com.hans.aop.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: hans
 * @Date: 2021/12/2 22:28
 */
@Slf4j
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean userValidator(Long id) {
        log.info("userValidator user id : {}", id);
        return id > 0 ? true : false;
    }
}
