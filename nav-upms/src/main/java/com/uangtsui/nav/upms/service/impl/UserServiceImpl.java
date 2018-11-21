package com.uangtsui.nav.upms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uangtsui.nav.upms.mapper.UserMapper;
import com.uangtsui.nav.upms.model.entity.User;
import com.uangtsui.nav.upms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList(Wrapper<User> wrapper) {
        List<User> list = userMapper.selectList(wrapper);
        return list;
    }
}
