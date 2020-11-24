package com.mind.model.sys;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 */
@Data
public class SysRoleRecordModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	private Integer id;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 是否删除，0：已删除，1：正常
	 */
	private Integer isDeleted;

	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建者ID
	 */
	private Integer createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 删除时间
	 */
	private Date delTime;

}
