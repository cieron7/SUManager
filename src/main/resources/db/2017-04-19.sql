/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : sumanager

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-04-19 08:32:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL COMMENT 'ѧ��ѧ��',
  `username` varchar(255) NOT NULL COMMENT 'ѧ������',
  `password` varchar(255) NOT NULL COMMENT 'ѧ������',
  `sex` tinyint(1) DEFAULT NULL COMMENT '�Ա�',
  `email` varchar(255) DEFAULT NULL COMMENT '�����ַ',
  `screenName` varchar(255) DEFAULT NULL COMMENT 'ѧ',
  `locale` varchar(255) DEFAULT NULL COMMENT '��ַ',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '״̬',
  `activated` tinyint(1) DEFAULT NULL COMMENT '����',
  `registertime` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `lastlogintime` datetime DEFAULT NULL COMMENT '����¼ʱ��',
  `registerip` varchar(255) DEFAULT NULL COMMENT 'ע��ip',
  `mobile` varchar(255) DEFAULT NULL COMMENT '�绰',
  `type` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '��ֵ',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '�����',
  `subtitle` varchar(255) DEFAULT NULL COMMENT 'С����',
  `context` varchar(255) DEFAULT NULL COMMENT '�����',
  `limitnum` int(11) DEFAULT NULL COMMENT '��������',
  `starttime` datetime DEFAULT NULL COMMENT '��ʼʱ��',
  `endtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  `apartment_id` bigint(20) DEFAULT NULL COMMENT '�id',
  `department_member_id` bigint(20) DEFAULT NULL COMMENT '���ų�Աid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for activity_member
-- ----------------------------
DROP TABLE IF EXISTS `activity_member`;
CREATE TABLE `activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `stratus` varchar(255) DEFAULT NULL COMMENT '״̬',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '�id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '�id',
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `content` varchar(255) DEFAULT NULL COMMENT '��������',
  `status` varchar(255) DEFAULT NULL COMMENT '״̬',
  `parentid` bigint(20) DEFAULT NULL COMMENT '����id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '��������',
  `description` varchar(255) DEFAULT NULL COMMENT '��������',
  `photo_url` varchar(255) DEFAULT NULL COMMENT 'ͼƬ��ַ',
  `goal` varchar(255) DEFAULT NULL COMMENT '����Ŀ��',
  `function` varchar(255) DEFAULT NULL COMMENT '����ְ��',
  `org_id` bigint(20) DEFAULT NULL COMMENT '��֯(Ժϵ)id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department_member
-- ----------------------------
DROP TABLE IF EXISTS `department_member`;
CREATE TABLE `department_member` (
  `id` bigint(20) NOT NULL,
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `department_id` bigint(20) DEFAULT NULL COMMENT '����id',
  `role` varchar(255) DEFAULT NULL COMMENT '����',
  `remark` varchar(255) DEFAULT NULL COMMENT '����',
  `status` varchar(255) DEFAULT NULL COMMENT '״̬',
  `ctreatetime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo��ַ',
  `name` varchar(255) DEFAULT NULL COMMENT '����(Ժϵ)����',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
