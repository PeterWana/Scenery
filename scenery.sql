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

 Date: 19/03/2023 21:32:28
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
INSERT INTO `admin` VALUES (1, 'admin', '123456', '15072876532');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, '非常好！！！', 0, '2023-03-19 21:06:48.000000', 1, 1);
INSERT INTO `comments` VALUES (2, '下次还来！！！', 1, '2023-03-19 21:07:14.000000', 5, 1);
INSERT INTO `comments` VALUES (3, '赞！！！', 2, '2023-03-19 21:07:54.000000', 10, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of new
-- ----------------------------
INSERT INTO `new` VALUES (1, '春暖花开时节，我国旅游市场快速升温，无论是家门口的本地游、周边游，还是“说走就走”的跨省游、出境游，都开始有序复苏。全国旅游市场呈现出“稳开高走，持续回暖”的态势。\\n根据文化和旅游部数据中心近日测算，预计2023年，我国国内旅游人数约为45.5亿人次，同比增长约80%。实现国内旅游收入约4万亿元，同比增长约95%。\\n旅游市场特点正在由近郊游、短途游转变为中远程的出游形式，适合春季的露营、街区休闲、古镇漫游等方式越来越受到公众青睐。各地还开展一系列惠民措施，通过发放旅游消费券等，助力文旅市场消费回暖。', 0, '2023-03-19 21:10:17.000000');

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, '真的很好', 1, '2023-03-17 12:18:22.000000', 1, 1);
INSERT INTO `reply` VALUES (2, '希望越来越好', 0, '2023-03-17 12:30:50.000000', 1, 2);
INSERT INTO `reply` VALUES (3, '非常棒', 1, '2023-03-17 16:23:51.000000', 2, 2);
INSERT INTO `reply` VALUES (4, '喜欢', 0, '2023-03-17 17:16:11.000000', 2, 3);

-- ----------------------------
-- Table structure for scene
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene`  (
  `scene_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `scene_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `scene_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scene_coordinate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scene_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scene_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scene
-- ----------------------------
INSERT INTO `scene` VALUES (1, '景点1', '文物', '介绍1', '(1,0)', NULL);
INSERT INTO `scene` VALUES (2, '景点2', '湖泊', '介绍2', '(4,0)', NULL);
INSERT INTO `scene` VALUES (3, '景点3', '名胜', '介绍3', '(7,0)', NULL);

-- ----------------------------
-- Table structure for sight
-- ----------------------------
DROP TABLE IF EXISTS `sight`;
CREATE TABLE `sight`  (
  `sight_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `sight_ap` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sight_time` datetime(6) NOT NULL,
  `sight_scene_id` int(10) UNSIGNED NOT NULL,
  `sight_tour_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`sight_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sight
-- ----------------------------
INSERT INTO `sight` VALUES (1, '(7,1)', '2023-03-19 21:29:58.000000', 3, 1);
INSERT INTO `sight` VALUES (2, '(4,1)', '2023-03-19 21:30:27.000000', 2, 1);
INSERT INTO `sight` VALUES (3, '(1,1)', '2023-03-19 21:30:43.000000', 1, 1);

-- ----------------------------
-- Table structure for tour
-- ----------------------------
DROP TABLE IF EXISTS `tour`;
CREATE TABLE `tour`  (
  `tour_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tour_time` datetime(6) NOT NULL,
  `tour_user_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`tour_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tour
-- ----------------------------
INSERT INTO `tour` VALUES (1, '2023-03-19 21:28:13.000000', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user1', '123456', 0, 25, '15078965432', NULL);
INSERT INTO `user` VALUES (2, 'user2', '123456', 1, 20, '18859763254', NULL);
INSERT INTO `user` VALUES (3, 'user3', '123456', 1, 22, '15579883002', NULL);

SET FOREIGN_KEY_CHECKS = 1;
