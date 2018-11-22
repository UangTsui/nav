package com.uangtsui.nav.upms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uangtsui.nav.upms.model.entity.User;
import com.uangtsui.nav.upms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.api.ApiController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author UangTsui
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/user")
public class UserController extends ApiController {

    @Autowired
    private IUserService userService;

    @GetMapping("userList")
    public List<User> userList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", "admin");
        List<User> userList = userService.list(queryWrapper);
        return userList;
    }
}
