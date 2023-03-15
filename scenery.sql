/*
 Navicat Premium Data Transfer

 Source Server         : test1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : scenery

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/03/2023 21:20:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_name_index`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, 'admin3', '1234567', '255');
INSERT INTO `admin` VALUES (3, 'admin4', '123456', '50');
INSERT INTO `admin` VALUES (4, 'admin2', '123456', '123456789000');
INSERT INTO `admin` VALUES (5, 'admin66', '123456', '134646845');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `com_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `com_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `com_likes` int(255) UNSIGNED NULL DEFAULT NULL,
  `com_date` datetime(6) NOT NULL,
  `scene_id` int(11) NOT NULL,
  `user_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for new
-- ----------------------------
DROP TABLE IF EXISTS `new`;
CREATE TABLE `new`  (
  `new_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `new_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `new_likes` int(11) UNSIGNED NULL DEFAULT NULL,
  `new_date` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`new_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of new
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `reply_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_likes` int(11) UNSIGNED NULL DEFAULT NULL,
  `reply_date` datetime(6) NOT NULL,
  `com_id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for scene
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene`  (
  `scene_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `scene_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scene_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scene
-- ----------------------------

-- ----------------------------
-- Table structure for sight
-- ----------------------------
DROP TABLE IF EXISTS `sight`;
CREATE TABLE `sight`  (
  `sight_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sight_apone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sight_aptwo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sight_apthr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sight_apfou` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sight_intime` datetime(6) NOT NULL,
  `sight_outime` datetime(6) NOT NULL,
  `scene_id` int(10) UNSIGNED NOT NULL,
  `tour_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`sight_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sight
-- ----------------------------

-- ----------------------------
-- Table structure for tour
-- ----------------------------
DROP TABLE IF EXISTS `tour`;
CREATE TABLE `tour`  (
  `tour_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tour_intime` datetime(6) NOT NULL,
  `tour_outtime` datetime(6) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`tour_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tour
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_sex` int(11) UNSIGNED NULL DEFAULT NULL,
  `user_age` int(11) UNSIGNED NULL DEFAULT NULL,
  `user_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name_index`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user12', '12345678', 255, 20, '1234567890', NULL);
INSERT INTO `user` VALUES (2, 'user2', '123', 0, 10, '123456', NULL);
INSERT INTO `user` VALUES (4, 'user3', '123', 0, 10, '123456', NULL);
INSERT INTO `user` VALUES (5, 'user5', '123', 0, 20, '50', NULL);
INSERT INTO `user` VALUES (6, 'user6', '123', 0, 20, '50', NULL);
INSERT INTO `user` VALUES (7, 'user7', '123', 0, 20, '50', NULL);
INSERT INTO `user` VALUES (8, 'user8', '123', 0, 20, '50', NULL);
INSERT INTO `user` VALUES (9, 'user15', '123456', 0, 20, '50', NULL);

SET FOREIGN_KEY_CHECKS = 1;
