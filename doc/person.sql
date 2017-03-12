/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2017-03-10 19:03:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) DEFAULT NULL COMMENT '名字',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件地址',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='绑定sku表';

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'zhang', 'beijng', '22', ' ewr', '2015-12-13 22:06:06', '2016-04-19 15:45:59');
INSERT INTO `person` VALUES ('2', 'wang', '上海', '22', 'wang@163.com', '2015-12-14 14:26:06', '2016-04-19 15:52:25');
INSERT INTO `person` VALUES ('3', 'li', 'shenzhen', '21', 'erwqrew', '2016-04-19 15:46:01', '2016-04-19 15:46:06');
INSERT INTO `person` VALUES ('4', 'zhang', 'beijing', '21', 'werqw', '2016-04-18 16:22:15', '2016-04-19 15:59:22');
INSERT INTO `person` VALUES ('5', 'wang', '上海', '22', 'efer', '2016-04-19 15:59:42', '2016-04-19 15:59:44');
