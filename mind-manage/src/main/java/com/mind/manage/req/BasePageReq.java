package com.mind.manage.req;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: tianms
 * @Date: 2020/11/24 13:54
 * @Description: 基础分页内容
 */
@Data
public class BasePageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        if (pageNum == null) {
            pageNum = BigDecimal.ONE.intValue();
        }
        return pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            pageSize = Integer.MAX_VALUE;
        }
        return pageSize;
    }
}
