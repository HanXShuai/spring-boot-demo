package com.hans.aop.controller;

import com.hans.aop.service.UserService;
import com.hans.aop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hans
 * @Date: 2021/12/2 21:28
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/user")
    public String findUser() {
        UserValidator userValidator = (UserValidator) userService;
        userValidator.userValidator(1L);
        userService.findUser(1L);
        return "success";
    }
}
