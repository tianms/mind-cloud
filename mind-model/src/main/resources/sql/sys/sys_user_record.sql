create table sys_user_record (
    id int(20) not null AUTO_INCREMENT comment '主键id',
    user_name varchar(100) not null DEFAULT '' comment '用户名',
    pass_word varchar(100) not null default '' comment '用户密码',
    salt varchar(100) not null default '' comment '盐',
    email varchar(50) comment '邮箱',
    mobile varchar(20) not null default '' comment '手机号',
    status int(1) not null default 1 comment '状态  0：禁用   1：正常',
    create_user_id int(20) not null comment '创建者用户id',
    create_time datetime not null comment '创建时间',
    primary key (id)
) ENGINE = INNODB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户信息表';