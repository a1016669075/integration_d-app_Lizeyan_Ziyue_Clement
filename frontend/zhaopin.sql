/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : zhaopin

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2022-04-01 18:08:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_from` varchar(255) DEFAULT NULL,
  `_to` varchar(255) DEFAULT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `_read` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('1', '0', '1', '0_1', null, null, null);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('0', '111', '111', 'laoban', '头像1', '11', '44', '22', '33');
INSERT INTO `userinfo` VALUES ('1', '222', '222', 'dashen', '头像2', '22', '22', null, null);
