/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : zhaopin

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2022-03-28 16:16:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `_id` int(11) NOT NULL,
  `_from` varchar(255) DEFAULT NULL,
  `_to` varchar(255) DEFAULT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `read` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `_id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
