package com.hans.activemq.service;

/**
 * @Author: hans
 * @Date: 2021/12/1 22:33
 */
public interface ActiveMQService {
    /**
     * sendMsg
     *
     * @param message message
     */
    void sendMsg(String message);

    /**
     * receiveMsg
     *
     * @param message message
     */
    void receiveMsg(String message);

}
