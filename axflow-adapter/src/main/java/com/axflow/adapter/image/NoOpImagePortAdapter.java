package com.axflow.adapter.image;

import com.axflow.port.external.ImagePort;
import org.springframework.stereotype.Component;

/**
 * @author wangguangwu
 */
@Component("noOpImage")
public class NoOpImagePortAdapter implements ImagePort {

    /**
     * 是否启用
     */
    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String upload(String imagePath) {
        return "";
    }

    @Override
    public void download(String imagePath, String localPath) {
        // ignore
    }

    @Override
    public boolean delete(String imagePath) {
        return false;
    }
}
