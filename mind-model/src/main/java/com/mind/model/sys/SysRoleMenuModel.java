package com.mind.model.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 */
@Data
public class SysRoleMenuModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * 角色ID
	 */
	private Integer roleId;

	/**
	 * 菜单ID
	 */
	private Integer menuId;


}
