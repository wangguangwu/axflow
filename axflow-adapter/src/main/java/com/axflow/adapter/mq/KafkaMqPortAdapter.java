package com.axflow.adapter.mq;

import com.axflow.port.external.MqPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Kafka 模拟实现（仅打印日志）
 *
 * @author wangguangwu
 */
@Slf4j
@Component
public class KafkaMqPortAdapter implements MqPort {

    @Override
    public void send(String topic, String message) {
        log.info("[Kafka] 模拟发送消息 -> Topic: {}, Body: {}", topic, message);
    }

    @Override
    public void subscribe(String topic, MessageListener listener) {
        log.info("[Kafka] 模拟订阅主题: {}", topic);
        // 不实际触发回调
    }
}
