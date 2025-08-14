package com.axflow.application.router;

import com.axflow.common.tenant.TenantContext;
import com.axflow.port.external.ImagePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangguangwu
 */
@Component
public class ImageRouter {

    private final Map<String, ImagePort> imagePortMap;
    private final ImagePort noOpImagePort;

    public ImageRouter(@Qualifier("ftp") ImagePort ftpPort,
                       @Qualifier("oss") ImagePort ossPort,
                       @Qualifier("noOpImage") ImagePort noOpImagePort) {
        this.imagePortMap = Map.of(
                "tenantA", ftpPort,
                "tenantB", ossPort
        );
        this.noOpImagePort = noOpImagePort;
    }

    public ImagePort getPort() {
        // 关键点：无匹配租户时返回NoOp
        return imagePortMap.getOrDefault(TenantContext.getTenantId(), noOpImagePort);
    }
}
