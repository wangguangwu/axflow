package com.axflow.port.external;

/**
 * 消息队列标准操作接口
 *
 * @author wangguangwu
 */
public interface MqPort {

    /**
     * 发送消息到指定主题
     *
     * @param topic   消息主题（如 "order.create"）
     * @param message 消息内容
     */
    void send(String topic, String message);

    /**
     * 订阅消息主题
     *
     * @param topic    消息主题
     * @param listener 消息监听器
     */
    void subscribe(String topic, MessageListener listener);

    /**
     * 消息监听器（函数式接口）
     */
    @FunctionalInterface
    interface MessageListener {
        void onMessage(String message);
    }
}