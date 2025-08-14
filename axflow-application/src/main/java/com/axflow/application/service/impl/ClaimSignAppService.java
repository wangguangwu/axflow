package com.axflow.application.service.impl;

import com.axflow.application.router.TenantRouter;
import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.common.dto.request.ClaimSignReq;
import com.axflow.domain.Claim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 签收用例实现（流程编排）@author wangguangwu
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ClaimSignAppService implements ClaimSignUseCase {

    private final TenantRouter router;

    @Override
    @Transactional
    public String claimSign(ClaimSignReq req) {
        String claimCode = req.getClaimCode();
        router.claimRepository().findByClaimCode(claimCode).ifPresent(claim -> {
            throw new IllegalStateException(String.format("赔案[%s]已签收", claimCode));
        });
        // 处理影像件逻辑
        List<String> imageRefs = req.getImageRefs();
        List<String> uploadImageRefs = new ArrayList<>();
        for (String imageRef : imageRefs) {
            String upload = router.image().upload(imageRef);
            uploadImageRefs.add(upload);
        }
        // 构建 domain 的 claim
        Claim claim = Claim.builder().claimCode(claimCode)
                .imageRefs(uploadImageRefs)
                .build();
        // 存储数据
        router.claimRepository().save(claim);
        // 发送消息
        String taskId = UUID.randomUUID().toString();
        router.mq().send("", taskId);
        return taskId;
    }
}
