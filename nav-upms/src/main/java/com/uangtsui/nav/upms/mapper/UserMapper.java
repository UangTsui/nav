package com.uangtsui.nav.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uangtsui.nav.upms.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author UangTsui
 * @since 2018-11-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
