package com.axflow.adapter.mq;

import com.axflow.common.constants.MQPortAdapterConstant;
import com.axflow.port.MQPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * RocketMQ 模拟实现（仅打印日志）
 *
 * @author wangguangwu
 */
@Slf4j
@Component
public class RocketMQPortAdapter implements MQPort {

    @Override
    public String name() {
        return MQPortAdapterConstant.ROCKETMQ_MQ_PORT_ADAPTER;
    }

    @Override
    public void send(String topic, String message) {
        log.info("[RocketMQ] 模拟发送消息 -> Topic: {}, Body: {}", topic, message);
    }

    @Override
    public void subscribe(String topic, MessageListener listener) {
        log.info("[RocketMQ] 模拟订阅主题: {}", topic);
        // 不实际触发回调
    }
}