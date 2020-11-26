package com.mind.manage.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: tianms
 * @Date: 2020/11/26 14:49
 * @Description: 登录操作相关实体类
 */
@Data
public class UserFormReq {

    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String passWord;

    /**
     * 当前时间
     */
    @NotNull(message = "密码不能为空")
    private Long currTime;

    /**
     * 新密码
     */
    @NotNull(message = "新密码不能为空")
    private String newPassWord;

}
