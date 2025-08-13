package com.axflow.common.enums;

import lombok.Getter;

/**
 * 基础状态枚举（仅成功/失败）
 *
 * @author wangguangwu
 */
@Getter
public enum ApiResponseStatusEnum {

    SUCCESS(200, "成功"),
    FAILED(500, "失败");

    private final Integer code;
    private final String desc;

    ApiResponseStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 快速判断是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
