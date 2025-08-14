package com.axflow.adapter.mq;

import com.axflow.port.external.MqPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Slf4j
@Component("noOpMq")
@Primary
public class NoOpMqPortAdapter implements MqPort {

    @Override
    public void send(String topic, String message) {
        log.info("[NoOp] 租户未启用MQ功能，忽略消息: Topic={}", topic);
    }

    @Override
    public void subscribe(String topic, MessageListener listener) {
        log.info("[NoOp] 租户未启用MQ订阅: Topic={}", topic);
    }
}
