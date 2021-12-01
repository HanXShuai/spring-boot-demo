package com.hans.activemq.service.impl;

import com.hans.activemq.service.ActiveMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:36
 */
@Service
@Slf4j
public class ActiveMQServiceImpl implements ActiveMQService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMsg(String message) {
        log.info("send message, message is : {}", message);
        jmsTemplate.convertAndSend(message);
        // 自定义发送地址
//        jmsTemplate.convertAndSend("hans_test", message);
    }

    @Override
    // 监听发送过来的消息
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String message) {
        log.info("receive message, message is : {}", message);
    }
}
