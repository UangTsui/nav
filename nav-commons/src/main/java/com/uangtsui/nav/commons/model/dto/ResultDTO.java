package com.uangtsui.nav.commons.model.dto;

import lombok.Data;

@Data
public class ResultDTO<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示语
     */
    private String msg;

    /**
     * 结果集
     */
    private T data;
}
