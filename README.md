# SUManager
学生会管理系统 v1.0

### windows 本地host修改 
127.0.0.1 su.dqsy.net <br>
127.0.0.1 img.dqsy.net <br>
### nginx 配置
    worker_processes  1;
    events {
        worker_connections  1024;
    }
    http {
        include       mime.types;
        default_type  application/octet-stream;

        sendfile        on;
        keepalive_timeout  65;

        server {
		    listen       80;
            server_name  img.dqsy.net;

            location / {
                root   C:/uploadfile;
                index  index.html index.htm;
            }

            error_page   500 502 503 504  /50x.html;
            location = /50x.html {
                root   html;
            }
        }
    }
    
### 建表语句
    /*
        Navicat MySQL Data Transfer

        Source Server         : 127.0.0.1
        Source Server Version : 50713
        Source Host           : localhost:3306
        Source Database       : sumanager

        Target Server Type    : MYSQL
        Target Server Version : 50713
        File Encoding         : 65001

        Date: 2017-03-20 01:04:36
     */

    SET FOREIGN_KEY_CHECKS=0;

    -- ----------------------------
    -- Table structure for account
    -- ----------------------------
    DROP TABLE IF EXISTS `account`;
    CREATE TABLE `account` (
    `id` bigint(20) NOT NULL COMMENT '学生学号',
     `username` varchar(255) NOT NULL COMMENT '学生姓名',
    `password` varchar(255) NOT NULL COMMENT '学生密码',
    `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
    `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
    `screename` varchar(255) DEFAULT NULL COMMENT '学生昵称',
    `locale` varchar(255) DEFAULT NULL COMMENT '地址',
    `enabled` tinyint(1) DEFAULT NULL COMMENT '状态',
    `activated` tinyint(1) DEFAULT NULL COMMENT '激活',
    `registertime` datetime DEFAULT NULL COMMENT '注册时间',
    `lastlogintime` datetime DEFAULT NULL COMMENT '最后登录时间',
    `registerip` varchar(255) DEFAULT NULL COMMENT '注册ip',
    `mobile` varchar(255) DEFAULT NULL COMMENT '电话',
    `salt` varchar(255) DEFAULT NULL COMMENT '盐值',
    `createtime` datetime DEFAULT NULL COMMENT '创建时间',
     PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Table structure for activity
    -- ----------------------------
    DROP TABLE IF EXISTS `activity`;
    CREATE TABLE `activity` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(255) DEFAULT NULL COMMENT '活动名称',
    `subtitle` varchar(255) DEFAULT NULL COMMENT '小标题',
    `context` varchar(255) DEFAULT NULL COMMENT '活动内容',
    `limitnum` int(11) DEFAULT NULL COMMENT '分类名称',
    `starttime` datetime DEFAULT NULL COMMENT '开始时间',
    `endtime` datetime DEFAULT NULL COMMENT '结束时间',
    `apartment_id` bigint(20) DEFAULT NULL COMMENT '活动id',
    `department_member_id` bigint(20) DEFAULT NULL COMMENT '部门成员id',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    -- ----------------------------
    -- Table structure for activity_member
    -- ----------------------------
    DROP TABLE IF EXISTS `activity_member`;
    CREATE TABLE `activity_member` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
      `stratus` varchar(255) DEFAULT NULL COMMENT '状态',
      `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
      `createtime` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    -- ----------------------------
    -- Table structure for comment
    -- ----------------------------
    DROP TABLE IF EXISTS `comment`;
    CREATE TABLE `comment` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
      `account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
      `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
      `status` varchar(255) DEFAULT NULL COMMENT '状态',
      `parentid` bigint(20) DEFAULT NULL COMMENT '评论id',
      `createtime` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    -- ----------------------------
    -- Table structure for department
    -- ----------------------------
    DROP TABLE IF EXISTS `department`;
    CREATE TABLE `department` (
      `id` bigint(20) NOT NULL,
      `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
      `description` varchar(255) DEFAULT NULL COMMENT '部门描述',
      `photo_url` varchar(255) DEFAULT NULL COMMENT '图片地址',
      `goal` varchar(255) DEFAULT NULL COMMENT '部门目标',
      `function` varchar(255) DEFAULT NULL COMMENT '部门职责',
      `org_id` bigint(20) DEFAULT NULL COMMENT '组织(院系)id',
      `createtime` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    -- ----------------------------
    -- Table structure for department_member
    -- ----------------------------
    DROP TABLE IF EXISTS `department_member`;
    CREATE TABLE `department_member` (
      `id` bigint(20) NOT NULL,
      `account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
      `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
      `role` varchar(255) DEFAULT NULL COMMENT '规则',
      `remark` varchar(255) DEFAULT NULL COMMENT '评价',
      `status` varchar(255) DEFAULT NULL COMMENT '状态',
      `ctreatetime` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    -- ----------------------------
    -- Table structure for organization
    -- ----------------------------
    DROP TABLE IF EXISTS `organization`;
    CREATE TABLE `organization` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
      `logo` varchar(255) DEFAULT NULL COMMENT 'logo地址',
      `name` varchar(255) DEFAULT NULL COMMENT '机构(院系)名称',
      `createtime` datetime DEFAULT NULL COMMENT '创建时间',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

### What's Next?