package com.axflow.application.service.impl;

import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.common.dto.request.ClaimSignReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 签收用例实现（流程编排）@author wangguangwu
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ClaimSignAppService implements ClaimSignUseCase {


    @Override
    @Transactional
    public String claimSign(ClaimSignReq req) {
        // 判断案件是否已经存在

        // 处理影像件逻辑

        // 构建 domain 的 claim

        // 存储数据

        // 发送消息
        return "";
    }
}
