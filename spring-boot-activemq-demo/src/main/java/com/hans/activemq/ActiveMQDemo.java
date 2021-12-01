package com.hans.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:23
 */
@SpringBootApplication
@EnableJms
public class ActiveMQDemo {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMQDemo.class, args);
    }
}
