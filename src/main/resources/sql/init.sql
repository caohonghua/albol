create database if not exists albol;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '账号',
  `password` char(32) NOT NULL COMMENT '密码',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '昵称',
  `avatar` varchar(200) NOT NULL DEFAULT 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif' COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `desc` varchar(50) NOT NULL COMMENT '描述',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `resource` (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `name` varchar(50) NOT NULL COMMENT '名称',
   `link` varchar(50) NOT NULL COMMENT '链接',
   `pid` bigint NOT NULL DEFAULT 0 COMMENT '父ID',
   `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_role_uk_1` (`user_id`,`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_resource` (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
   `role_id` bigint NOT NULL COMMENT '角色ID',
   `resource_id` bigint NOT NULL COMMENT '资源ID',
   PRIMARY KEY (`id`),
   UNIQUE KEY `role_resource_uk_1` (`role_id`,`resource_id`),
   CONSTRAINT `role_resource_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role`(`id`),
   CONSTRAINT `role_resource_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `resource`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `article` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(200)  NOT NULL COMMENT '名称',
    `category` varchar(50) NOT NULL COMMENT '标签',
    `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `content` text NOT NULL COMMENT '内容',
    PRIMARY KEY(`id`),
    UNIQUE KEY(`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## admin admin123
insert into user(id,name,password) values(1,'admin','0192023a7bbd73250516f069df18b500');

##
insert into role(id,name,`desc`) values(1,'admin','超级管理员');

##
insert into user_role(id,user_id,role_id) values(1,1,1);

