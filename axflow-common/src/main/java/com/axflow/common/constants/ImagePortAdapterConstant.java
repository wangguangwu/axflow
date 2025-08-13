package com.axflow.common.constants;

/**
 * Image Port Adapter 常量定义
 * 用于标识不同 Image 实现的唯一 key
 *
 * @author wangguangwu
 */
public final class ImagePortAdapterConstant {

    private ImagePortAdapterConstant() {
    }

    public static final String DEFAULT_IMAGE_PORT_ADAPTER = "default";
    public static final String OSS_IMAGE_PORT_ADAPTER = "oss";
    public static final String FTP_IMAGE_PORT_ADAPTER = "ftp";

}
