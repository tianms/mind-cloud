create table sys_user_role (
	id int(20) not null AUTO_INCREMENT comment '主键id',
	user_id int(20) not null comment '用户id',
	role_id int(20) not null comment '角色id',
  primary key (id)
) ENGINE = INNODB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色关联表';