package com.axflow.application.factory;

import com.axflow.port.external.ImagePort;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangguangwu
 */
@Component
public class ImageFactory {

    private final Map<String, ImagePort> imagePortMap;

    public ImageFactory(Map<String, ImagePort> imagePortMap) {
        this.imagePortMap = imagePortMap;
    }

    public ImagePort getImagePort(String type) {
        return imagePortMap.get(type);
    }
}
