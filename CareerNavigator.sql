/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : careernavigator

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 09/05/2025 13:48:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `avatarUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `type` int(0) DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1111', 'e10adc3949ba59abbe56e057f20f883e', NULL, 1);
INSERT INTO `account` VALUES ('123', 'e10adc3949ba59abbe56e057f20f883e', NULL, 1);
INSERT INTO `account` VALUES ('12345611', '96e79218965eb72c92a549dd5a330112', NULL, 1);
INSERT INTO `account` VALUES ('test', 'e10adc3949ba59abbe56e057f20f883e', NULL, 2);

-- ----------------------------
-- Table structure for ansrecord
-- ----------------------------
DROP TABLE IF EXISTS `ansrecord`;
CREATE TABLE `ansrecord`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `paperid` int(0) DEFAULT NULL COMMENT '试卷id',
  `exeId` int(0) DEFAULT NULL COMMENT '题目id',
  `op` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '选项',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `ansrecord_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for assessment
-- ----------------------------
DROP TABLE IF EXISTS `assessment`;
CREATE TABLE `assessment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `paperid` int(0) DEFAULT NULL COMMENT '试卷id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `analysis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '分析',
  `advice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '建议',
  `assessmenttime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评估时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `assessment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `msg` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '消息内容',
  `interviewid` int(0) DEFAULT NULL COMMENT '面试id',
  `chattime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发送时间',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `interviewid`(`interviewid`) USING BTREE,
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`interviewid`) REFERENCES `interview` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `jobid` int(0) DEFAULT NULL COMMENT '岗位id',
  `commentdate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论时间',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评论内容',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论类型',
  `fatherid` int(0) DEFAULT NULL COMMENT '父评论id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `jobid`(`jobid`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`jobid`) REFERENCES `job` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for discussion
-- ----------------------------
DROP TABLE IF EXISTS `discussion`;
CREATE TABLE `discussion`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户ID（关联account.username）',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `parent_id` int(0) DEFAULT 0 COMMENT '父评论ID（0表示顶级评论）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主题帖标题（可选）',
  `jobId` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `discussion_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of discussion
-- ----------------------------
INSERT INTO `discussion` VALUES (2, '123', '感谢分享，请问如何学习Spring Boot？', 1, '2025-05-07 17:01:38', '', NULL);
INSERT INTO `discussion` VALUES (3, '123', '感谢分享，请问如何学习Spring Boot？', 1, '2025-05-07 17:01:50', '', NULL);

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education`  (
  `eduid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学校',
  `degree` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学历',
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `startDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开始时间',
  `endDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结束时间',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`eduid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `education_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for honors
-- ----------------------------
DROP TABLE IF EXISTS `honors`;
CREATE TABLE `honors`  (
  `honorid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `honorName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '荣誉',
  `date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '时间',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`honorid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `honors_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interview
-- ----------------------------
DROP TABLE IF EXISTS `interview`;
CREATE TABLE `interview`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `jobname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '岗位名称',
  `jobtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '岗位类型',
  `interviewtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '面试时间',
  `score` int(0) DEFAULT NULL COMMENT '面试评分',
  `analysis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '面试分析',
  `advice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '面试建议',
  `review` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '面试回顾',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `interview_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '岗位名称',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '公司名称',
  `salary` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '薪资',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '工作地点',
  `experience` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '经验要求',
  `education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学历要求',
  `jobtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '岗位类型',
  `jobdescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '岗位描述',
  `requirement` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '任职要求',
  `publishdate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (1, 'Java后端开发', 'XX科技', '15k-25k', '北京', '3-5年', '本科', '技术岗', '负责公司核心业务系统的后端开发与维护', '熟悉Spring Boot、MySQL，有分布式系统经验优先', '2024-03-10');
INSERT INTO `job` VALUES (2, '前端开发工程师', 'YY互联网', '12k-20k', '上海', '1-3年', '本科', '技术岗', '负责PC/移动端页面开发与优化', '精通Vue3，熟悉TypeScript，有组件库开发经验优先', '2024-03-11');
INSERT INTO `job` VALUES (3, 'Java后端开发', 'XX科技', '15k-25k', '北京', '3-5年', '本科', '技术岗', '负责公司核心业务系统的后端开发与维护', '熟悉Spring Boot、MySQL，有分布式系统经验优先', '2024-03-10');
INSERT INTO `job` VALUES (4, '前端开发工程师', 'YY互联网', '12k-20k', '上海', '1-3年', '本科', '技术岗', '负责PC/移动端页面开发与优化', '精通Vue3，熟悉TypeScript，有组件库开发经验优先', '2024-03-11');

-- ----------------------------
-- Table structure for jobapply
-- ----------------------------
DROP TABLE IF EXISTS `jobapply`;
CREATE TABLE `jobapply`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `jobid` int(0) DEFAULT NULL COMMENT '岗位id',
  `applydate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请时间',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `jobid`(`jobid`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `jobapply_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `jobapply_ibfk_2` FOREIGN KEY (`jobid`) REFERENCES `job` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobapply
-- ----------------------------
INSERT INTO `jobapply` VALUES (1, 'test', 1, '2025-05-07 16:04:18', '已投递');
INSERT INTO `jobapply` VALUES (2, '123', 1, '2025-05-07 16:10:36', '已投递');

-- ----------------------------
-- Table structure for personalinfo
-- ----------------------------
DROP TABLE IF EXISTS `personalinfo`;
CREATE TABLE `personalinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `university` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学校',
  `politicalStatus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '政治面貌',
  `website` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '个人网站',
  `avatar` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `age` int(0) DEFAULT NULL COMMENT '年龄',
  `applicationPosition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '申请岗位',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `personalinfo_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects`  (
  `projectid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `projectName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目名称',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色',
  `startDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开始时间',
  `endDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结束时间',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  `briefIntroduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '项目简介',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`projectid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简历标题',
  `createtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建时间',
  `score` int(0) DEFAULT NULL COMMENT '简历评分',
  `analysis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '简历分析',
  `advice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '简历建议',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简历类型',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '简历内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resume_assessment_record
-- ----------------------------
DROP TABLE IF EXISTS `resume_assessment_record`;
CREATE TABLE `resume_assessment_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评估记录ID',
  `resume_id` int(0) NOT NULL COMMENT '关联的简历ID',
  `assessment_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '评估结果内容 (JSON格式或其他文本)',
  `assessment_time` datetime(0) DEFAULT NULL COMMENT '评估时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_resume_id`(`resume_id`) USING BTREE,
  CONSTRAINT `fk_resume_assessment_resume` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '简历评估记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resumesetting
-- ----------------------------
DROP TABLE IF EXISTS `resumesetting`;
CREATE TABLE `resumesetting`  (
  `settingid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  `themeColor1` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主题颜色1',
  `themeColor2` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '主题颜色2',
  `fontSize` int(0) DEFAULT NULL COMMENT '字体大小',
  `sectionSpacing` int(0) DEFAULT NULL COMMENT '段落间距',
  `paragraphSpacing` int(0) DEFAULT NULL COMMENT '段落间距',
  `currentTemplate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当前模板',
  `padding_top_bottom` int(0) DEFAULT NULL COMMENT '内边距',
  `padding_left_right` int(0) DEFAULT NULL COMMENT '内边距',
  PRIMARY KEY (`settingid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `resumesetting_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for skills
-- ----------------------------
DROP TABLE IF EXISTS `skills`;
CREATE TABLE `skills`  (
  `skillid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `skillName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '技能',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`skillid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `skills_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for summary
-- ----------------------------
DROP TABLE IF EXISTS `summary`;
CREATE TABLE `summary`  (
  `summaryid` int(0) NOT NULL AUTO_INCREMENT,
  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '总结',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`summaryid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `summary_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `age` int(0) DEFAULT NULL COMMENT '年龄',
  `education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '教育水平',
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '专业',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `expectedjob` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '意向岗位',
  `graduationtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '毕业时间',
  `registertime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for workexperience
-- ----------------------------
DROP TABLE IF EXISTS `workexperience`;
CREATE TABLE `workexperience`  (
  `workid` int(0) NOT NULL AUTO_INCREMENT,
  `id` int(0) DEFAULT NULL COMMENT '标识',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '公司',
  `position` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职位',
  `startDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '开始时间',
  `endDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '结束时间',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '描述',
  `resumeid` int(0) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`workid`) USING BTREE,
  INDEX `resumeid`(`resumeid`) USING BTREE,
  CONSTRAINT `workexperience_ibfk_1` FOREIGN KEY (`resumeid`) REFERENCES `resume` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
