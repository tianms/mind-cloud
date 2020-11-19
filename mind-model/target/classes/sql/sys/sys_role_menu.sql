create table sys_role_menu (
	id int(20) not null AUTO_INCREMENT comment '主键id',
	role_id int(20) not null comment '角色id',
	menu_id int(20) not null comment '菜单id',
  primary key (id)
) ENGINE = INNODB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色菜单关联表';