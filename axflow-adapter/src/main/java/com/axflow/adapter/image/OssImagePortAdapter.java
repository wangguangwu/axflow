package com.axflow.adapter.image;

import com.axflow.common.constants.ImagePortAdapterConstant;
import com.axflow.port.ImagePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * OSS 影像件操作模拟实现（仅日志记录）
 *
 * @author wangguangwu
 */
@Slf4j
@Component
public class OssImagePortAdapter implements ImagePort {

    @Override
    public String name() {
        return ImagePortAdapterConstant.OSS_IMAGE_PORT_ADAPTER;
    }

    @Override
    public String upload(String imagePath) {
        log.info("[OSS] 模拟上传文件: {}", imagePath);
        return "oss://mock-bucket/" + imagePath.substring(imagePath.lastIndexOf("/") + 1);
    }

    @Override
    public void download(String imagePath, String localPath) {
        log.info("[OSS] 模拟下载文件: {} -> {}", imagePath, localPath);
    }

    @Override
    public boolean delete(String imagePath) {
        log.info("[OSS] 模拟删除文件: {}", imagePath);
        return true;
    }
}
