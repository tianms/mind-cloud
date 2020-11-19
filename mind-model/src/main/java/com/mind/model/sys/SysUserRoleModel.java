package com.mind.model.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户与角色对应关系
 */
@Data
public class SysUserRoleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;


}
