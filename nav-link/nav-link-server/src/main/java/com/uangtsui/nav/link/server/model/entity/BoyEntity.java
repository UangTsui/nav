package com.uangtsui.nav.link.server.model.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("boy")
@RefreshScope
public class BoyEntity {

    private String name;

    private Integer age;
}
