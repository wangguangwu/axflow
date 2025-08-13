package com.axflow.application.service.impl;

import com.axflow.application.router.TenantRouter;
import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.common.dto.request.ClaimSignReq;
import com.axflow.domain.Claim;
import com.axflow.port.ClaimRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/**
 * 签收用例实现（流程编排）@author wangguangwu
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ClaimSignAppService implements ClaimSignUseCase {

//    private final ClaimRepositoryPort repo;
    private final TenantRouter router;

    @Override
    public String claimSign(ClaimSignReq req) {
//        Claim claim = repo.findByCode(req.getClaimCode()).orElseThrow(() -> new IllegalStateException("not found"));
//        router.validation().validateBeforeAccept(claim, Map.of("images", req.imageRefs(), "operator", req.operatorId()));
//        router.imageSink().upload(req.imageRefs(), t);
//        String key = router.keyStrategy(t).nextKey(claim, t);
//        repo.save(claim, t, key);
//        byte[] body = ("tenant=" + t.id() + ",code=" + claim.getCode() + ",rid=" + claim.getReceiptId()).getBytes(StandardCharsets.UTF_8);
//        router.logPublisher(t).publish("receipt.signed", body, t);
//        log.info("sign completed tenant={} claim={} receiptId={}", t.id(), claim.getCode(), claim.getReceiptId());
        String taskId = UUID.randomUUID().toString();
        router.mq().send("", taskId);
        return taskId;
    }
}
