package com.uangtsui.nav.upms.service.impl;

import com.uangtsui.nav.upms.mapper.UserMapper;
import com.uangtsui.nav.upms.model.entity.User;
import com.uangtsui.nav.upms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author UangTsui
 * @since 2018-11-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
