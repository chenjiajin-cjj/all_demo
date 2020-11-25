/*
 Navicat Premium Data Transfer

 Source Server         : 119.23.109.20
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 119.23.109.20:3306
 Source Schema         : rrrmq

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 20/06/2020 16:43:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orer_info
-- ----------------------------
DROP TABLE IF EXISTS `orer_info`;
CREATE TABLE `orer_info`  (
  `order_id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_number_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `order_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单名称',
  `order_create` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `order_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单类别',
  `order_product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的商品id',
  `order_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orer_info
-- ----------------------------
INSERT INTO `orer_info` VALUES (1, '123', '测试订单', '创建时间', '商品类别', '商品id', '用户id');
INSERT INTO `orer_info` VALUES (2, '123444', '测试订单1', '创建时间1', '商品类别1', '商品id1', '用户id1');
INSERT INTO `orer_info` VALUES (3, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (4, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (5, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (6, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (7, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (8, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (9, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (10, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (11, '123442224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (12, '1234422221224', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (13, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (14, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (15, 'fdsf23', '234', '234', '11', '11', '11');
INSERT INTO `orer_info` VALUES (16, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (17, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (18, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (19, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (20, '11331112', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (21, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (22, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (23, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (24, '92612', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (25, '55', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orer_info` VALUES (26, '55', '测试订单11', '创建时间11', '商品类别11', '商品id11', '用户id11');
INSERT INTO `orer_info` VALUES (27, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (28, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (29, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (30, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (31, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (32, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (33, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (34, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (35, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (36, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (37, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (38, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (39, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (40, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (41, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (42, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (43, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (44, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (45, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (46, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (47, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (48, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');
INSERT INTO `orer_info` VALUES (49, '55', '测试订单1121', '创建时间1121', '商品类别1121', '商品id1321', '用户id1211');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限标识符',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'p1', '测试资源 1', '/r/r1');
INSERT INTO `t_permission` VALUES ('2', 'p3', '测试资源2', '/r/r2');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', NULL, NULL, NULL, '');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色的id',
  `permission_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限的id',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1');
INSERT INTO `t_role_permission` VALUES ('1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zhangsan', '$2a$10$VNQjFq82Bbl6gNDbQUFzk.UGpLxHvSNjCJp/DHlo7kqhoiGUsSVEC', '张三', '123213');
INSERT INTO `t_user` VALUES (2, 'lisi', '$10$VNQjFq82Bbl6gNDbQUFzk.UGpLxHvSNjCJp/DHlo7kqhoiGUsSVEC', '张三', '123213');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色的id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
