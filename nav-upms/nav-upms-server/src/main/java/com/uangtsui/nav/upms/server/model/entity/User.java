package com.uangtsui.nav.upms.server.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户表
 *
 * @author UangTsui
 * @since 2018-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends SuperEntity<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
