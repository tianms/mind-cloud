package com.mind.model.sys;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理
 */
@Data
public class SysMenuRecordModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	private Integer id;

	/**
	 * 父菜单ID，一级菜单为0
	 */
	private String parentId;
	
	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 菜单URL
	 */
	private String url;

	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	private String perms;

	/**
	 * 类型  0：目录   1：菜单   2：按钮
	 */
	private Integer type;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 排序
	 */
	private Integer orderNum;

	/**
	 * 是否为系统菜单（用于控制菜单是否可以删除，系统菜单不可以删除），0：不是系统菜单，1：系统菜单
	 */
	private String isSysMenu;

	/**
	 * 创建时间
	 */
	private Date createTime;

}
