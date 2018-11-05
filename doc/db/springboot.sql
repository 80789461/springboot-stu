/*
Navicat MySQL Data Transfer

Source Server         : stu
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-31 22:34:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `smart_role`
-- ----------------------------
DROP TABLE IF EXISTS `smart_role`;
CREATE TABLE `smart_role` (
  `id` bigint(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smart_role
-- ----------------------------

-- ----------------------------
-- Table structure for `smart_role_source`
-- ----------------------------
DROP TABLE IF EXISTS `smart_role_source`;
CREATE TABLE `smart_role_source` (
  `role_id` bigint(20) DEFAULT NULL,
  `source_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smart_role_source
-- ----------------------------

-- ----------------------------
-- Table structure for `smart_source`
-- ----------------------------
DROP TABLE IF EXISTS `smart_source`;
CREATE TABLE `smart_source` (
  `id` bigint(20) DEFAULT NULL,
  `source_url` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smart_source
-- ----------------------------

-- ----------------------------
-- Table structure for `smart_user`
-- ----------------------------
DROP TABLE IF EXISTS `smart_user`;
CREATE TABLE `smart_user` (
  `id` bigint(32) NOT NULL,
  `login_name` varchar(32) NOT NULL,
  `login_psw` varchar(32) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smart_user
-- ----------------------------

-- ----------------------------
-- Table structure for `smart_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `smart_user_role`;
CREATE TABLE `smart_user_role` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smart_user_role
-- ----------------------------
