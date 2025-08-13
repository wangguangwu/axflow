package com.axflow.common.dto.response;

import com.axflow.common.enums.ApiResponseStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 通用 API 响应封装类
 *
 * @param <T> 响应数据类型
 * @author wangguangwu
 */
@Data
@Accessors(chain = true)
public class ApiResponse<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    // 快速生成成功响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>()
                .setCode(ApiResponseStatusEnum.SUCCESS.getCode())
                .setMessage(ApiResponseStatusEnum.SUCCESS.getDesc())
                .setData(data);
    }

    // 快速生成失败响应
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<T>()
                .setCode(code)
                .setMessage(message)
                .setData(null);
    }
}
