/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : db_emp

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 07/06/2020 18:06:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS `db_emp`;
CREATE DATABASE `db_emp` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_emp`;

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
DROP TABLE IF EXISTS `t_code`;
CREATE TABLE `t_code`  (
  `N_CODE_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `VC_CODE_LABEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预选项组',
  `VC_CODE_VALUE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预选项值',
  `N_REMOVABLE` smallint(1) NOT NULL DEFAULT 0 COMMENT '是否可删除',
  PRIMARY KEY (`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_2`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_3`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_4`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_5`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_6`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_7`(`N_CODE_ID`) USING BTREE,
  INDEX `N_CODE_ID_8`(`N_CODE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_code
-- ----------------------------
INSERT INTO `t_code` VALUES (1, '性别', '男', 0);
INSERT INTO `t_code` VALUES (2, '性别', '女', 0);
INSERT INTO `t_code` VALUES (3, '户口类型', '城镇户口', 0);
INSERT INTO `t_code` VALUES (4, '户口类型', '农村户口', 0);
INSERT INTO `t_code` VALUES (5, '学历', '高中', 0);
INSERT INTO `t_code` VALUES (6, '学历', '专科', 0);
INSERT INTO `t_code` VALUES (7, '学历', '本科', 0);
INSERT INTO `t_code` VALUES (8, '学历', '硕士', 0);
INSERT INTO `t_code` VALUES (9, '学历', '博士', 0);
INSERT INTO `t_code` VALUES (10, '政治面貌', '中共党员', 0);
INSERT INTO `t_code` VALUES (11, '政治面貌', '中共预备党员', 0);
INSERT INTO `t_code` VALUES (12, '政治面貌', '共青团员', 0);
INSERT INTO `t_code` VALUES (13, '政治面貌', '民主党派', 0);
INSERT INTO `t_code` VALUES (14, '政治面貌', '群众', 0);
INSERT INTO `t_code` VALUES (15, '健康状况', '良好', 0);
INSERT INTO `t_code` VALUES (16, '健康状况', '健康', 0);
INSERT INTO `t_code` VALUES (17, '健康状况', '一般', 0);
INSERT INTO `t_code` VALUES (18, '健康状况', '有慢性疾病', 0);
INSERT INTO `t_code` VALUES (19, '民族', '汉族', 0);
INSERT INTO `t_code` VALUES (20, '民族', '蒙古族', 0);
INSERT INTO `t_code` VALUES (21, '民族', '回族', 0);
INSERT INTO `t_code` VALUES (22, '民族', '藏族', 0);
INSERT INTO `t_code` VALUES (23, '民族', '维吾尔族', 0);
INSERT INTO `t_code` VALUES (24, '民族', '苗族', 0);
INSERT INTO `t_code` VALUES (25, '民族', '彝族', 0);
INSERT INTO `t_code` VALUES (26, '民族', '壮族', 0);
INSERT INTO `t_code` VALUES (27, '民族', '布依族', 0);
INSERT INTO `t_code` VALUES (28, '民族', '朝鲜族', 0);
INSERT INTO `t_code` VALUES (29, '民族', '满族', 0);
INSERT INTO `t_code` VALUES (30, '民族', '侗族', 0);
INSERT INTO `t_code` VALUES (31, '民族', '瑶族', 0);
INSERT INTO `t_code` VALUES (32, '民族', '白族', 0);
INSERT INTO `t_code` VALUES (33, '民族', '土家族', 0);
INSERT INTO `t_code` VALUES (34, '民族', '哈尼族', 0);
INSERT INTO `t_code` VALUES (35, '民族', '哈萨克族', 0);
INSERT INTO `t_code` VALUES (36, '民族', '傣族', 0);
INSERT INTO `t_code` VALUES (37, '民族', '黎族', 0);
INSERT INTO `t_code` VALUES (38, '民族', '傈僳族', 0);
INSERT INTO `t_code` VALUES (39, '民族', '佤族', 0);
INSERT INTO `t_code` VALUES (40, '民族', '畲族', 0);
INSERT INTO `t_code` VALUES (41, '民族', '高山族', 0);
INSERT INTO `t_code` VALUES (42, '民族', '拉祜族', 0);
INSERT INTO `t_code` VALUES (43, '民族', '水族', 0);
INSERT INTO `t_code` VALUES (44, '民族', '东乡族', 0);
INSERT INTO `t_code` VALUES (45, '民族', '纳西族', 0);
INSERT INTO `t_code` VALUES (46, '民族', '景颇族', 0);
INSERT INTO `t_code` VALUES (47, '民族', '柯尔克孜族', 0);
INSERT INTO `t_code` VALUES (48, '民族', '土族', 0);
INSERT INTO `t_code` VALUES (49, '民族', '达翰尔族', 0);
INSERT INTO `t_code` VALUES (50, '民族', '仫佬族', 0);
INSERT INTO `t_code` VALUES (51, '民族', '羌族', 0);
INSERT INTO `t_code` VALUES (52, '民族', '布朗族', 0);
INSERT INTO `t_code` VALUES (53, '民族', '撒拉族', 0);
INSERT INTO `t_code` VALUES (54, '民族', '仡佬族', 0);
INSERT INTO `t_code` VALUES (55, '民族', '锡伯族', 0);
INSERT INTO `t_code` VALUES (56, '民族', '阿昌族', 0);
INSERT INTO `t_code` VALUES (57, '民族', '普米族', 0);
INSERT INTO `t_code` VALUES (58, '民族', '塔吉克族', 0);
INSERT INTO `t_code` VALUES (59, '民族', '怒族', 0);
INSERT INTO `t_code` VALUES (60, '民族', '乌孜别克族', 0);
INSERT INTO `t_code` VALUES (61, '民族', '俄罗斯族', 0);
INSERT INTO `t_code` VALUES (62, '民族', '鄂温克族', 0);
INSERT INTO `t_code` VALUES (63, '民族', '德昂族', 0);
INSERT INTO `t_code` VALUES (64, '民族', '保安族', 0);
INSERT INTO `t_code` VALUES (65, '民族', '裕固族', 0);
INSERT INTO `t_code` VALUES (66, '民族', '京族', 0);
INSERT INTO `t_code` VALUES (67, '民族', '塔塔尔族', 0);
INSERT INTO `t_code` VALUES (68, '民族', '独龙族', 0);
INSERT INTO `t_code` VALUES (69, '民族', '鄂伦春族', 0);
INSERT INTO `t_code` VALUES (70, '民族', '赫哲族', 0);
INSERT INTO `t_code` VALUES (71, '民族', '门巴族', 0);
INSERT INTO `t_code` VALUES (72, '民族', '珞巴族', 0);
INSERT INTO `t_code` VALUES (73, '民族', '基诺族', 0);
INSERT INTO `t_code` VALUES (74, '部门类型', '管理部门', 0);
INSERT INTO `t_code` VALUES (75, '部门类型', '生产部门', 0);
INSERT INTO `t_code` VALUES (76, '任职状态', '试用', 0);
INSERT INTO `t_code` VALUES (77, '任职状态', '在职', 0);
INSERT INTO `t_code` VALUES (78, '任职状态', '挂靠', 0);
INSERT INTO `t_code` VALUES (79, '任职状态', '自动离职', 0);
INSERT INTO `t_code` VALUES (80, '任职状态', '辞退', 0);

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `N_DEPT_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `VC_DEPT_CODE` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  `VC_DEPT_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `N_DEPT_TYPE` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '部门类型',
  `N_PARENT_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '上级部门ID',
  `VC_LOCATION` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `VC_POST_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `VC_TELEPHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `VC_FAX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `VC_MAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  PRIMARY KEY (`N_DEPT_ID`) USING BTREE,
  INDEX `FK_DEPT_REF_DEPT`(`N_PARENT_ID`) USING BTREE,
  INDEX `FK_TYPE_REF_CODE`(`N_DEPT_TYPE`) USING BTREE,
  INDEX `N_DEPT_ID`(`N_DEPT_ID`) USING BTREE,
  INDEX `N_DEPT_ID_2`(`N_DEPT_ID`) USING BTREE,
  INDEX `N_DEPT_ID_3`(`N_DEPT_ID`) USING BTREE,
  CONSTRAINT `FK_DEPT_REF_DEPT` FOREIGN KEY (`N_PARENT_ID`) REFERENCES `t_dept` (`n_dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TYPE_REF_CODE` FOREIGN KEY (`N_DEPT_TYPE`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (1, 'D10000', '综合部', 74, NULL, '四川成都', '610000', '10000000000', '023-123456', '123456@321.com');
INSERT INTO `t_dept` VALUES (2, 'D20001', '技术部', 75, 1, '北京', '100000', '12345678910', '023-321456', '321@asd.com');
INSERT INTO `t_dept` VALUES (3, 'D20002', '项目工作室A', 75, 2, '四川成都', '610000', '65478912332', '023-546461', '6545@354.com');
INSERT INTO `t_dept` VALUES (4, 'D20003', '项目工作室B', 75, 2, '浙江杭州', '546321', '45653184654', '023-645134', '684135@asd.com');
INSERT INTO `t_dept` VALUES (5, 'D20004', '项目A工作组', 75, 3, '江苏苏州', '845312', '35431354121', '023-453354', 'afh@sdifh.com');
INSERT INTO `t_dept` VALUES (6, 'D30001', '财务部', 74, 1, '天津', '245331', '84354846431', '023-534131', 'aehf@asof.com');
INSERT INTO `t_dept` VALUES (7, 'D30002', '财务办公厅', 74, 6, '重庆', '354515', '45131531351', '023-955155', 'asdja@soda.com');
INSERT INTO `t_dept` VALUES (8, 'D40001', '人事部', 74, 1, '湖南长沙', '453312', '35413515513', '023-563153', 'asifj@sovj.com');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee`  (
  `N_EMP_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '员工信息ID',
  `N_DEPT_ID` int(10) UNSIGNED NOT NULL COMMENT '部门ID',
  `N_TITLE_ID` int(10) UNSIGNED NOT NULL COMMENT '职称ID',
  `N_POST_ID` int(10) UNSIGNED NOT NULL COMMENT '岗位ID',
  `VC_EMP_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `VC_EMP_CODE` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工编号',
  `N_GENDER` int(10) UNSIGNED NOT NULL COMMENT '员工性别',
  `VC_IDCARD_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `D_BIRTHDAY` date NOT NULL COMMENT '出身年月',
  `VC_NATIVE_PLACE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工籍贯',
  `N_EDU_LEVEL` int(10) UNSIGNED NOT NULL COMMENT '员工学历',
  `N_NATION` int(10) UNSIGNED NOT NULL COMMENT '民族',
  `N_PARTY` int(10) UNSIGNED NOT NULL COMMENT '政治面貌',
  `N_HEALTH` int(10) UNSIGNED NOT NULL COMMENT '健康状况',
  `N_REG_TYPE` int(10) UNSIGNED NOT NULL COMMENT '户口类型',
  `N_STATUS` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '工作状态',
  PRIMARY KEY (`N_EMP_ID`) USING BTREE,
  INDEX `FK_EMP_REF_DEPT`(`N_DEPT_ID`) USING BTREE,
  INDEX `FK_EMP_REF_POST`(`N_POST_ID`) USING BTREE,
  INDEX `FK_EMP_REF_TITLE`(`N_TITLE_ID`) USING BTREE,
  INDEX `FK_EDU_LEVEL_REF_CODE`(`N_EDU_LEVEL`) USING BTREE,
  INDEX `FK_NATION_REF_CODE`(`N_NATION`) USING BTREE,
  INDEX `FK_PARTY_REF_CODE`(`N_PARTY`) USING BTREE,
  INDEX `FK_HEALTH_REF_CODE`(`N_HEALTH`) USING BTREE,
  INDEX `FK_REG_TYPE_REF_CODE`(`N_REG_TYPE`) USING BTREE,
  INDEX `FK_STATUS_REF_CODE`(`N_STATUS`) USING BTREE,
  INDEX `FK_GENDER_REF_CODE`(`N_GENDER`) USING BTREE,
  CONSTRAINT `FK_EDU_LEVEL_REF_CODE` FOREIGN KEY (`N_EDU_LEVEL`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_EMP_REF_TITLE` FOREIGN KEY (`N_TITLE_ID`) REFERENCES `t_title` (`n_title_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_HEALTH_REF_CODE` FOREIGN KEY (`N_HEALTH`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_NATION_REF_CODE` FOREIGN KEY (`N_NATION`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PARTY_REF_CODE` FOREIGN KEY (`N_PARTY`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_REG_TYPE_REF_CODE` FOREIGN KEY (`N_REG_TYPE`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_STATUS_REF_CODE` FOREIGN KEY (`N_STATUS`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_EMP_REF_POST` FOREIGN KEY (`N_POST_ID`) REFERENCES `t_post` (`n_post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_EMP_REF_DEPT` FOREIGN KEY (`N_DEPT_ID`) REFERENCES `t_dept` (`n_dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_GENDER_REF_CODE` FOREIGN KEY (`N_GENDER`) REFERENCES `t_code` (`n_code_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES (1, 2, 5, 1, '张三', 'E00001', 1, '512345678912345678', '1989-06-15', '山东', 7, 19, 14, 15, 3, 77);
INSERT INTO `t_employee` VALUES (2, 3, 5, 2, '李四', 'E00002', 2, '132456789654123847', '1986-09-08', '湖北', 9, 19, 11, 15, 3, 77);
INSERT INTO `t_employee` VALUES (3, 5, 4, 4, '王五', 'E00003', 1, '314551531515455644', '1990-07-07', '四川', 7, 19, 14, 16, 3, 77);
INSERT INTO `t_employee` VALUES (4, 5, 4, 5, '赵六', 'E00004', 1, '012355135135435453', '1999-08-09', '云南', 8, 19, 12, 15, 3, 76);

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post`  (
  `N_POST_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `VC_POST_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `N_PARENT_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '上级岗位ID',
  `VC_DUTY` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位职责',
  `VC_QUALIFICATION` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任职资格',
  `VC_PURVIEW` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位权限',
  `VC_WORK_CONTENT` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作内容',
  PRIMARY KEY (`N_POST_ID`) USING BTREE,
  INDEX `FK_POST_REF_POST`(`N_PARENT_ID`) USING BTREE,
  INDEX `N_POST_ID`(`N_POST_ID`) USING BTREE,
  INDEX `N_POST_ID_2`(`N_POST_ID`) USING BTREE,
  INDEX `N_POST_ID_3`(`N_POST_ID`) USING BTREE,
  INDEX `N_POST_ID_4`(`N_POST_ID`) USING BTREE,
  CONSTRAINT `FK_POST_REF_POST` FOREIGN KEY (`N_PARENT_ID`) REFERENCES `t_post` (`n_post_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES (1, '技术部经理', NULL, '负责技术部相关事宜', '本科以上学历，任职5年以上', '技术部人事管理', '管理技术部运作');
INSERT INTO `t_post` VALUES (2, '项目经理', 1, '负责产品开发相关工作', '本科以上学历，参与项目开发3次以上', '项目开发组管理', '管理项目开发');
INSERT INTO `t_post` VALUES (3, '架构师', 2, '负责产品架构', '本科以上学历', '无', '对产品进行技术架构');
INSERT INTO `t_post` VALUES (4, '程序员', 2, '负责产品开发', '本科及以上学历', '无', '进行产品开发');
INSERT INTO `t_post` VALUES (5, '测试员', 2, '负责产品测试', '本科及以上学历', '无', '进行产品测试');
INSERT INTO `t_post` VALUES (6, '财务部经理', NULL, '负责财务部相关事宜', '本科及以上学历，任职5年以上', '财务部人事管理', '管理财务部运作');
INSERT INTO `t_post` VALUES (7, '会计员', 6, '负责公司财务内容', '本科以上学历，有专业资格证', '无', '财务相关内容');
INSERT INTO `t_post` VALUES (8, '审计员', 6, '负责公司产品财务审计', '本科以上学历', '无', '审计相关内容');

-- ----------------------------
-- Table structure for t_title
-- ----------------------------
DROP TABLE IF EXISTS `t_title`;
CREATE TABLE `t_title`  (
  `N_TITLE_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '职称ID',
  `VC_TITLE_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称名称',
  `VC_TITLE_CODE` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称编号',
  `VC_QUALIFICATION` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称资格',
  `VC_DUTY` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职称职责',
  `VC_WORK_TARGET` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作目标',
  PRIMARY KEY (`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_2`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_3`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_4`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_5`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_6`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_7`(`N_TITLE_ID`) USING BTREE,
  INDEX `N_TITLE_ID_8`(`N_TITLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_title
-- ----------------------------
INSERT INTO `t_title` VALUES (1, '会计', 'S001', '本科及以上学历', '负责财务相关', '账目记录、财务报告');
INSERT INTO `t_title` VALUES (2, '工程师', 'S002', '本科及以上学历', '负责项目工程', '公司产品的生产等');
INSERT INTO `t_title` VALUES (3, '审计', 'S003', '本科及以上学历', '负责产品审计工作', '可行性分析等');
INSERT INTO `t_title` VALUES (4, '技术员', 'S004', '本科及以上学历', '负责产品研发', '编码、测试等');
INSERT INTO `t_title` VALUES (5, '高级工程师', 'S005', '本科及以上学历', '负责产品架构和策划', '产品架构、策划等');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `N_USER_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `VC_USERNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `VC_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `N_ROLE` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户角色',
  PRIMARY KEY (`N_USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456789', 1);
INSERT INTO `t_user` VALUES (2, 'user1', '123456', 0);
INSERT INTO `t_user` VALUES (3, 'user2', '123456', 0);
INSERT INTO `t_user` VALUES (4, 'user3', '123456', 0);

SET FOREIGN_KEY_CHECKS = 1;
