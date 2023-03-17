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

 Date: 17/03/2023 22:32:42
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, 'admin3', '1234567', '255');
INSERT INTO `admin` VALUES (3, 'admin4', '123456', '50');
INSERT INTO `admin` VALUES (4, 'admin2', '123456', '123456789000');
INSERT INTO `admin` VALUES (5, 'admin66', '123456', '134646845');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `com_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `com_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `com_likes` int(255) UNSIGNED NULL DEFAULT NULL,
  `com_date` datetime(6) NOT NULL,
  `com_scene_id` int(11) NOT NULL,
  `com_user_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, '1234567', 1, '2023-03-17 13:15:03.000000', 1, 15);
INSERT INTO `comments` VALUES (3, '123', 0, '2023-03-17 17:09:38.000000', 1, 16);
INSERT INTO `comments` VALUES (4, 'opopopo', 0, '2023-03-17 21:10:47.000000', 1, 5);

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of new
-- ----------------------------
INSERT INTO `new` VALUES (1, '123123', 12, '2023-03-16 14:30:30.000000');
INSERT INTO `new` VALUES (2, '123213', 5, '2023-03-16 14:55:38.000000');
INSERT INTO `new` VALUES (3, '5', 0, '2023-03-16 16:53:23.000000');
INSERT INTO `new` VALUES (15, '5', 0, '2023-03-16 17:42:34.000000');
INSERT INTO `new` VALUES (16, '5', 0, '2023-03-16 21:14:00.000000');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `reply_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_likes` int(11) UNSIGNED NULL DEFAULT NULL,
  `reply_date` datetime(6) NOT NULL,
  `reply_com_id` int(10) UNSIGNED NOT NULL,
  `reply_user_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, '123', 0, '2023-03-17 12:18:22.000000', 1, 16);
INSERT INTO `reply` VALUES (2, '000', 0, '2023-03-17 12:30:50.000000', 1, 17);
INSERT INTO `reply` VALUES (3, '000', 0, '2023-03-17 16:23:51.000000', 3, 18);
INSERT INTO `reply` VALUES (4, '001', 0, '2023-03-17 17:16:11.000000', 3, 17);

-- ----------------------------
-- Table structure for scene
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene`  (
  `scene_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `scene_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_coordinate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scene_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scene_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scene
-- ----------------------------
INSERT INTO `scene` VALUES (1, '景点1', '园林', NULL, NULL);
INSERT INTO `scene` VALUES (3, '景点2', '还得', NULL, NULL);
INSERT INTO `scene` VALUES (4, '景点2', '还得', '(2,5)', NULL);

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
  `sight_time` datetime(6) NOT NULL,
  `sight_scene_id` int(10) UNSIGNED NOT NULL,
  `sight_tour_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`sight_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sight
-- ----------------------------

-- ----------------------------
-- Table structure for tour
-- ----------------------------
DROP TABLE IF EXISTS `tour`;
CREATE TABLE `tour`  (
  `tour_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tour_time` datetime(6) NOT NULL,
  `tour_user_id` int(10) UNSIGNED NOT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `user` VALUES (15, 'user25', '123', 0, 10, '123456', NULL);
INSERT INTO `user` VALUES (16, 'user26', '123', 0, 10, '123456', NULL);
INSERT INTO `user` VALUES (17, 'user666', '123', 0, 20, '50', NULL);

SET FOREIGN_KEY_CHECKS = 1;
