package com.hans.activemq.service.impl;

import com.hans.activemq.pojo.User;
import com.hans.activemq.service.ActiveMQUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:54
 */
@Service
@Slf4j
public class ActiveMQUserServiceImpl implements ActiveMQUserService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String MY_DESTINATION = "user.destination";
    @Override
    public void sendUser(User user) {
        log.info("send user, user is : {}", user.toString());
        jmsTemplate.convertAndSend(MY_DESTINATION,user);
    }

    @Override
    @JmsListener(destination = MY_DESTINATION)
    public void receiveUser(User user) {
        log.info("receive user , user is : {}", user,toString());
    }
}
