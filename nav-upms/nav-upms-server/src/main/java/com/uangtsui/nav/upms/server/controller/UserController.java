package com.uangtsui.nav.upms.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uangtsui.nav.upms.server.model.entity.User;
import com.uangtsui.nav.upms.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.api.ApiController;

import java.util.List;

/**
 * 用户表 前端控制器
 *
 * @author UangTsui
 * @since 2018-11-23
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

    /**
     * 分页
     * @return
     */
    @GetMapping("userListPage")
    public IPage<User> userListPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", "admin");
        return userService.page(new Page<User>(0, 1), queryWrapper);
    }

    @PostMapping("saveUser")
    public void saveUser(){
    }

    @PostMapping("updateUser")
    public void updateUser(){
        User user = userService.getById(5);
        user.setLoginname("admin");
        user.setVersion(4L);
        // 乐观锁
        userService.updateById(user);

        // 逻辑删除
        userService.removeById(5);
    }
}
