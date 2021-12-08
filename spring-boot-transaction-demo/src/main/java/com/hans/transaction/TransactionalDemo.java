package com.hans.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: hans
 * @Date: 2021/12/2 23:06
 */
@SpringBootApplication
public class TransactionalDemo {
    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemo.class, args);
    }
}
