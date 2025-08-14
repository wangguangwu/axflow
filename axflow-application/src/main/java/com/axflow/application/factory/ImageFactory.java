package com.axflow.application.factory;

import com.axflow.common.constants.ImagePortAdapterConstant;
import com.axflow.port.ImagePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Component
public class ImageFactory {

    private final Map<String, ImagePort> imagePortMap;

    public ImageFactory(List<ImagePort> imagePortList) {
        this.imagePortMap = imagePortList.stream().collect(Collectors.toMap(ImagePort::name, Function.identity()));
    }

    public ImagePort getAdapter(String name) {
        return imagePortMap.getOrDefault(name, imagePortMap.get(ImagePortAdapterConstant.DEFAULT_IMAGE_PORT_ADAPTER));
    }
}
