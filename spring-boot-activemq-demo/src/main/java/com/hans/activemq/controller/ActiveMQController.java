package com.hans.activemq.controller;

import com.hans.activemq.service.ActiveMQService;
import com.hans.activemq.pojo.User;
import com.hans.activemq.service.ActiveMQUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:50
 */
@Controller
@RequestMapping("/activemq")
public class ActiveMQController {
    @Autowired
    private ActiveMQService activeMQService;

    @Autowired
    private ActiveMQUserService userService;

    @ResponseBody
    @GetMapping("/msg")
    public Map<String, Object> msg(String message) {
        activeMQService.sendMsg(message);
        return result(true, message);
    }

    private Map<String, Object> result(Boolean success, Object message) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }

    @ResponseBody
    @GetMapping("/user")
    public Map<String, Object> sendUser(Long id, String userName, String note) {
        User user = new User(id, userName, note);
        userService.sendUser(user);
        return result(true, user);
    }

}
