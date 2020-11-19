package com.mind.model.sys;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统操作日志
 */
@Data
public class SysLogRecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 执行时长(毫秒)
     */
    private BigDecimal runTime;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 创建时间
     */
    private Date createTime;

}
