package com.mind.manage.req;

import lombok.Data;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 13:59
 * @Description: 用户请求对象
 */
@Data
public class SysUserRecordReq extends BasePageReq {

    /**
     * 用户名
     */
    private String userName;
}
