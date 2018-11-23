package com.uangtsui.nav.upms.server.service.impl;

import com.uangtsui.nav.upms.server.mapper.UserMapper;
import com.uangtsui.nav.upms.server.model.entity.User;
import com.uangtsui.nav.upms.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author UangTsui
 * @since 2018-11-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
