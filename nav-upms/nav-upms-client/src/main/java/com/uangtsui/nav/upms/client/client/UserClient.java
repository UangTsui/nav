package com.uangtsui.nav.upms.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "upms", fallback = UserClient.UserClientFallback.class)
public interface UserClient {

    @GetMapping("/user/restTemplateMsg")
    String restTemplateMsg();

    @Component
    static class UserClientFallback implements UserClient {

        @Override
        public String restTemplateMsg() {
            return null;
        }
    }
}
