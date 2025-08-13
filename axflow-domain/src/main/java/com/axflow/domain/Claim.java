package com.axflow.domain;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 赔案聚合根（规则与状态演化；无 IO）
 *
 * @author wangguangwu
 */
@Getter
public class Claim {

    private static final Logger log = LoggerFactory.getLogger(Claim.class);

    public enum Status {NEW, ACCEPTED}

    private final String code;
    private String receiptId;
    private Status status = Status.NEW;

    public Claim(String code) {
        this.code = code;
    }

    public void accept(String operatorId) {
        if (status != Status.NEW) {
            throw new IllegalStateException("非法流转");
        }
        this.receiptId = "R-" + code;
        this.status = Status.ACCEPTED;
        log.info("claim accepted code={} operator={}", code, operatorId);
    }
}
