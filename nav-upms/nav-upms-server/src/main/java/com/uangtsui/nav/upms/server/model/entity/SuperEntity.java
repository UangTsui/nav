package com.uangtsui.nav.upms.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId("id")
    private Long id;

    /**
     * 乐观锁
     */
    @Version
    private Long version;

    /**
     * 逻辑删除，0：未删除；1：已删除
     */
    @TableLogic
    private Long deleted;
}
