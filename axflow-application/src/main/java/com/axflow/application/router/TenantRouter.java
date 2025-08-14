package com.axflow.application.router;

import com.axflow.application.factory.ImageFactory;
import com.axflow.application.factory.MqPortFactory;
import com.axflow.common.constants.ImagePortAdapterConstant;
import com.axflow.common.constants.MQPortAdapterConstant;
import com.axflow.common.tenant.TenantContext;
import com.axflow.port.ImagePort;
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
    private final Map<String, ImagePort> tenantImagePortMap;

    /**
     * 初始化默认租户配置
     */
    public TenantRouter(MqPortFactory mqPortFactory, ImageFactory imageFactory) {
        tenantMqPortMap = new ConcurrentHashMap<>();
        tenantImagePortMap = new ConcurrentHashMap<>();
        // 默认租户t1使用RocketMQ实现
        tenantMqPortMap.put("t1", mqPortFactory.getAdapter(MQPortAdapterConstant.ROCKETMQ_MQ_PORT_ADAPTER));
        tenantMqPortMap.put("t2", mqPortFactory.getAdapter(MQPortAdapterConstant.KAFKA_MQ_PORT_ADAPTER));
        tenantImagePortMap.put("t1", imageFactory.getAdapter(ImagePortAdapterConstant.OSS_IMAGE_PORT_ADAPTER));
        tenantImagePortMap.put("t2", imageFactory.getAdapter(ImagePortAdapterConstant.FTP_IMAGE_PORT_ADAPTER));
    }

    /**
     * 获取当前租户的MQ适配器
     *
     * @return 租户对应的MQ端口实现
     */
    public MQPort mq() {
        String tenantId = TenantContext.getTenantId();
        return tenantMqPortMap.getOrDefault(tenantId, tenantMqPortMap.get(MQPortAdapterConstant.DEFAULT_MQ_PORT_ADAPTER));
    }

    /**
     * 获取当前租户的影像件适配器
     *
     * @return 租户对应的影像件端口实现
     */
    public ImagePort image() {
        String tenantId = TenantContext.getTenantId();
        return tenantImagePortMap.getOrDefault(tenantId, tenantImagePortMap.get(ImagePortAdapterConstant.DEFAULT_IMAGE_PORT_ADAPTER));
    }
}
