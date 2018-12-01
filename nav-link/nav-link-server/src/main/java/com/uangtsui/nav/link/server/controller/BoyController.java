package com.uangtsui.nav.link.server.controller;

import com.uangtsui.nav.link.server.model.entity.BoyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boy")
public class BoyController {

    @Autowired
    private BoyEntity boyEntity;

    @GetMapping("getBoy")
    public String getBoy() {
        return "name:" + boyEntity.getName() + "--age:" + boyEntity.getAge();
    }
}
