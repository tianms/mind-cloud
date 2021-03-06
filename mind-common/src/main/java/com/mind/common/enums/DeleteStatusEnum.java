package com.mind.common.enums;

import com.mind.common.constatns.NumConstant;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 10:06
 * @Description: 删除状态枚举类
 */
public enum DeleteStatusEnum {

    DEL(NumConstant.ZERO.intValue(), "已删除"),
    UN_DEL(NumConstant.ONE.intValue(), "未删除");

    private Integer code;

    private String name;

    DeleteStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode () {
        return this.code;
    }

    public String getName () {
        return this.name;
    }

}
