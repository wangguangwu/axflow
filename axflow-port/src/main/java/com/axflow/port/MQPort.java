package com.axflow.port;

/**
 * 消息队列标准操作接口
 *
 * @author wangguangwu
 */
public interface MQPort {

    /**
     * 获取端口名称
     *
     * @return 端口名称
     */
    String name();

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