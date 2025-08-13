package com.axflow.adapter.image;

import com.axflow.common.constants.ImagePortAdapterConstant;
import com.axflow.port.ImagePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * FTP 影像件操作模拟实现（仅日志记录）
 *
 * @author wangguangwu
 */
@Component
@Slf4j
public class FtpImagePortAdapter implements ImagePort {

    @Override
    public String name() {
        return ImagePortAdapterConstant.FTP_IMAGE_PORT_ADAPTER;
    }

    @Override
    public String upload(String imagePath) {
        log.info("[FTP] 模拟上传文件: {}", imagePath);
        return "ftp://mock-server/" + imagePath.substring(imagePath.lastIndexOf("/") + 1);
    }

    @Override
    public void download(String imagePath, String localPath) {
        log.info("[FTP] 模拟下载文件: {} -> {}", imagePath, localPath);
    }

    @Override
    public boolean delete(String imagePath) {
        log.info("[FTP] 模拟删除文件: {}", imagePath);
        return true;
    }
}
