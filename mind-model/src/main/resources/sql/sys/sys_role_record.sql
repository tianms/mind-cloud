drop table sys_role_record;
CREATE TABLE sys_role_record (
	`id` INT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`role_name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '角色名称',
	`is_deleted` int(1) not null default 1 COMMENT '是否删除，0：已删除，1：正常',
	`remark` text NOT NULL COMMENT '备注',
	`create_user_id` int(20) NOT NULL COMMENT '创建者ID',
	`create_time` datetime COMMENT '创建时间',
	`update_time` datetime COMMENT '更新时间',
	`del_time` datetime NULL COMMENT '删除时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色信息表';

