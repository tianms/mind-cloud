CREATE TABLE sys_menu_record (
	`id` INT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`parent_id` INT (20) comment '父菜单ID，一级菜单为0',
	`name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '菜单名称',
	`url` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '菜单URL',
	`perms` text NOT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
	`type` int(1) NOT NULL COMMENT '类型  0：目录   1：菜单   2：按钮',
	`icon` varchar(30) NOT NULL COMMENT '菜单图标',
	`order_num` int(10) NOT NULL COMMENT '排序',
	`is_sys_menu` int(1) NOT NULL COMMENT '是否为系统菜单（用于控制菜单是否可以删除，系统菜单不可以删除），0：不是系统菜单，1：系统菜单',
	`create_time` datetime NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单信息表';

