package com.uangtsui.nav.upms.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "upms")
public interface UserClient {

    @GetMapping("/user/restTemplateMsg")
    String restTemplateMsg();
}
