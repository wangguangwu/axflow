package com.axflow.common.constants;

/**
 * MQ Port Adapter 常量定义
 * 用于标识不同 MQ 实现的唯一 key
 *
 * @author wangguangwu
 */
public final class MQPortAdapterConstant {

    private MQPortAdapterConstant() {
        // 禁止实例化
    }

    public static final String KAFKA_MQ_PORT_ADAPTER = "kafka";
    public static final String ROCKETMQ_MQ_PORT_ADAPTER = "rocketmq";

}
