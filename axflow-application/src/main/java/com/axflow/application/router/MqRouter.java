package com.axflow.application.router;

import com.axflow.common.tenant.TenantContext;
import com.axflow.port.external.MqPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangguangwu
 */
@Component
public class MqRouter {

    private final Map<String, MqPort> mqPortMap;
    private final MqPort noOpMqPort;

    public MqRouter(
            @Qualifier("kafka") MqPort kafkaPort,
            @Qualifier("rocketmq") MqPort rocketmqPort,
            @Qualifier("noOpMq") MqPort noOpMqPort) {
        this.mqPortMap = Map.of(
                "tenantA", kafkaPort,
                "tenantB", rocketmqPort
        );
        this.noOpMqPort = noOpMqPort;
    }

    public MqPort getPort() {
        return mqPortMap.getOrDefault(TenantContext.getTenantId(), noOpMqPort);
    }
}
