package com.hans.activemq.service;

import com.hans.activemq.pojo.User;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:53
 */
public interface ActiveMQUserService {

    void sendUser(User user);

    void receiveUser(User user);
}
