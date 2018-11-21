package com.uangtsui.nav.upms.controller;

import com.uangtsui.nav.upms.model.entity.User;
import com.uangtsui.nav.upms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("userList")
    public List<User> userList() {
        List<User> userList = iUserService.selectUserList(null);
        return userList;
    }
}
