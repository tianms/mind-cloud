CREATE TABLE sys_role_record (
	`id` INT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`role_name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '角色名称',
	`remark` text NOT NULL COMMENT '备注',
	`create_user_id` int(20) NOT NULL COMMENT '创建者ID',
	`create_time` datetime NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色信息表';

