package com.uangtsui.nav.upms.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String loginname;
}
