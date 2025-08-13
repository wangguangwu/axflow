package com.axflow.application.router;

import com.axflow.application.factory.MqPortFactory;
import com.axflow.common.constants.MQPortAdapterConstant;
import com.axflow.common.tenant.TenantContext;
import com.axflow.port.MQPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 租户消息队列路由选择器
 *
 * <p>根据租户ID动态选择对应的MQ实现适配器</p>
 *
 * @author wangguangwu
 */
@Slf4j
@Component
public class TenantRouter {

    private final Map<String, MQPort> tenantMqPortMap;

    /**
     * 初始化默认租户配置
     */
    public TenantRouter(MqPortFactory mqPortFactory) {
        tenantMqPortMap = new ConcurrentHashMap<>();
        // 默认租户t1使用RocketMQ实现
        tenantMqPortMap.put("t1", mqPortFactory.getAdapter(MQPortAdapterConstant.ROCKETMQ_MQ_PORT_ADAPTER));
        tenantMqPortMap.put("t2", mqPortFactory.getAdapter(MQPortAdapterConstant.KAFKA_MQ_PORT_ADAPTER));
        log.info("TenantRouter initialized with default mappings: {}", tenantMqPortMap.keySet());
    }

    /**
     * 获取当前租户的MQ适配器
     *
     * @return 租户对应的MQ端口实现
     * @throws IllegalStateException 如果找不到对应租户的配置
     */
    public MQPort mq() {
        String tenantId = TenantContext.getTenantId();
        MQPort port = tenantMqPortMap.get(tenantId);
        if (port == null) {
            log.error("未配置租户[{}]的MQ适配器", tenantId);
            throw new IllegalStateException("找不到租户" + tenantId + "的MQ配置");
        }
        log.debug("租户[{}]使用MQ适配器: {}", tenantId, port.getClass().getSimpleName());
        return port;
    }
}
