package com.mind.manage.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: tianms
 * @Date: 2020/11/19 10:43
 * @Description: 日志请求对象
 */
@Data
public class SysLogRecordReq extends BasePageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String userName;

}
