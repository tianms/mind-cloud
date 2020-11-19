CREATE TABLE sys_log_record (
	id INT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	user_name VARCHAR (200) NOT NULL DEFAULT '' COMMENT '用户名',
	operation VARCHAR (500) NOT NULL DEFAULT '' COMMENT '用户操作',
	method VARCHAR (100) NOT NULL DEFAULT '' COMMENT '请求方法',
	params text NOT NULL COMMENT '请求参数',
	run_time DECIMAL (15, 0) NOT NULL COMMENT '执行时长',
	ip VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'IP地址',
	create_time datetime NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARACTER
SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统操作日志';

