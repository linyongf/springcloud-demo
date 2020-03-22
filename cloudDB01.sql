/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.78.101
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 192.168.78.101:3306
 Source Schema         : cloudDB01

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 12/03/2020 18:10:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (7, '开发部', 'cloudDB03');
INSERT INTO `dept` VALUES (8, '人事部', 'cloudDB03');
INSERT INTO `dept` VALUES (9, '财务部', 'cloudDB03');
INSERT INTO `dept` VALUES (10, '市场部', 'cloudDB03');
INSERT INTO `dept` VALUES (11, '运维部', 'cloudDB03');
INSERT INTO `dept` VALUES (12, '张三', 'cloudDB03');

SET FOREIGN_KEY_CHECKS = 1;
