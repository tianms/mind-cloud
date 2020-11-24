package com.mind.manage.req;

import lombok.Data;

/**
 * @Auther: tianms
 * @Date: 2020/11/19 10:43
 * @Description: 日志请求对象
 */
@Data
public class SysLogRecordReq extends BasePageReq {

    /**
     * 用户名
     */
    private String userName;

}
