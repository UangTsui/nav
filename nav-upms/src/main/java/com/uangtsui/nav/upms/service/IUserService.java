package com.uangtsui.nav.upms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uangtsui.nav.upms.model.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {

    /**
     * 查询所有用户
     */
    List<User> selectUserList(Wrapper<User> wrapper);
}
