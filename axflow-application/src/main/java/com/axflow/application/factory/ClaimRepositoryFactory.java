package com.axflow.application.factory;

import com.axflow.common.constants.CommonConstant;
import com.axflow.port.ClaimRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Component
public class ClaimRepositoryFactory {

    private final Map<String, ClaimRepositoryPort> claimRepositoryPortMap;

    public ClaimRepositoryFactory(List<ClaimRepositoryPort> claimRepositoryPortList) {
        this.claimRepositoryPortMap = claimRepositoryPortList.stream().collect(Collectors.toMap(ClaimRepositoryPort::name, Function.identity()));
    }

    public ClaimRepositoryPort getAdapter(String name) {
        return claimRepositoryPortMap.getOrDefault(name, claimRepositoryPortMap.get(CommonConstant.DEFAULT));
    }
}
