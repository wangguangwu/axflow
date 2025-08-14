package com.axflow.application.factory;

import com.axflow.common.constants.CommonConstant;
import com.axflow.common.constants.MQPortAdapterConstant;
import com.axflow.port.MQPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Component
public class MqPortFactory {

    private final Map<String, MQPort> mqPortMap;

    public MqPortFactory(List<MQPort> mqPortList) {
        mqPortMap = mqPortList.stream().collect(Collectors.toMap(MQPort::name, Function.identity()));
    }

    public MQPort getAdapter(String name) {
        return mqPortMap.getOrDefault(name, mqPortMap.get(CommonConstant.DEFAULT));
    }
}
