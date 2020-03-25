/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.116.9测试mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.116.9:3306
 Source Schema         : cermanager

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 25/03/2020 17:54:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for certificate_info
-- ----------------------------
DROP TABLE IF EXISTS `certificate_info`;
CREATE TABLE `certificate_info`  (
  `ID` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BUSI_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务单元名',
  `SYS_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块名',
  `CER_SEND_TYPE` int(10) NOT NULL COMMENT '证书颁发主体 1.邮乐颁发 2.外部颁发',
  `CER_TYPE` int(10) NOT NULL COMMENT '证书类型 1.公钥 2.私钥 3.pfx公私钥',
  `EXPIRATION_DATE` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书过期时间',
  `CHANNEL_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外部颁发证书的通道编码',
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'email地址',
  `CER_OUT_TYPE` int(10) NULL DEFAULT NULL COMMENT '外部证书类型 1.文件证书 2.秘钥串证书',
  `CER_OUT_FILENAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外部证书原始文件名',
  `CER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生成的文件证书名(服务器保存)',
  `DOWN_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问文件夹服务的密码',
  `REMARK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段',
  `CER_ENV` int(10) NULL DEFAULT NULL COMMENT '证书使用环境 1.开发 2.测试 3.生产',
  `CER_CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '证书内容',
  `CREATE_TIME` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `EDIT_TIME` timestamp(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '证书信息表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certificate_info
-- ----------------------------
INSERT INTO `certificate_info` VALUES (1, 'ep', 'ep-paysys', 1, 3, '2025-04-21', 'ule', 'fanxueli@ule.com', NULL, NULL, 'ep-paysys.pfx', '123456', NULL, 1, '22222222222222222222', '2019-03-22 01:29:40', '2019-03-22 09:29:04');
INSERT INTO `certificate_info` VALUES (2, 'ep', 'ep-trans', 1, 3, '2025-04-21', 'ule', 'fanxueli@ule.com', NULL, NULL, 'ep-trans.pfx', '123456', NULL, 1, '22222222222222222222', '2019-03-22 01:30:05', '2019-03-22 09:29:29');
INSERT INTO `certificate_info` VALUES (3, 'Test1', 'ep-paysys', 1, 1, '2022-04-17', 'ule', 'fanxueli@ule.com', NULL, NULL, 'ep-paysys.pfx', '123456', NULL, 1, '22222222222222222222', '2019-05-06 15:42:01', '2019-04-02 10:42:18');
INSERT INTO `certificate_info` VALUES (4, 'Test2', 'ep-paysys', 1, 1, '2019-05-20', 'ule', 'fanxueli@ule.com', NULL, NULL, 'Test2_ep-paysys_ule-pub.cer', '123456', NULL, 1, '122222222223232332222222222222222222222', '2019-05-20 17:15:48', '0000-00-00 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
