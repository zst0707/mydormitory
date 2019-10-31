/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : dormitory

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-10-30 18:00:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'lyl', '111111', 'lyl', '女', '18767765456');

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `dormId` int(11) NOT NULL AUTO_INCREMENT,
  `dormBuildId` int(11) DEFAULT NULL,
  `dormName` varchar(20) DEFAULT NULL,
  `dormType` varchar(20) DEFAULT NULL,
  `dormNumber` int(10) DEFAULT NULL,
  `dormTel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dormId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorm
-- ----------------------------
INSERT INTO `dorm` VALUES ('1', '1', '101', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('2', '1', '102', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('3', '2', '201', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('4', '2', '201', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('5', '3', '301', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('6', '3', '302', '男', '6', '12580');
INSERT INTO `dorm` VALUES ('7', '4', '401', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('8', '4', '402', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('9', '5', '501', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('10', '5', '502', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('11', '6', '601', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('12', '6', '602', '女', '6', '12580');
INSERT INTO `dorm` VALUES ('13', '1', '101', '男', '6', '12580');

-- ----------------------------
-- Table structure for dormbuild
-- ----------------------------
DROP TABLE IF EXISTS `dormbuild`;
CREATE TABLE `dormbuild` (
  `dormBuildId` int(11) NOT NULL AUTO_INCREMENT,
  `dormBuildName` varchar(20) DEFAULT NULL,
  `dormBuildDetail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dormBuildId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormbuild
-- ----------------------------
INSERT INTO `dormbuild` VALUES ('1', '1栋', '男生宿舍，50人');
INSERT INTO `dormbuild` VALUES ('2', '2栋', '男生宿舍，45人');
INSERT INTO `dormbuild` VALUES ('3', '3栋', '男生宿舍，54人');
INSERT INTO `dormbuild` VALUES ('4', '4栋', '女生宿舍，44人');
INSERT INTO `dormbuild` VALUES ('5', '5栋', '女生宿舍，48人');
INSERT INTO `dormbuild` VALUES ('6', '6栋', '女生宿舍，50人');

-- ----------------------------
-- Table structure for dormmanager
-- ----------------------------
DROP TABLE IF EXISTS `dormmanager`;
CREATE TABLE `dormmanager` (
  `dormManId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dormBuildId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dormManId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormmanager
-- ----------------------------
INSERT INTO `dormmanager` VALUES ('1', 'manager1', '111111', '1', 'manager1', '男', '111111');
INSERT INTO `dormmanager` VALUES ('2', 'manager2', '222222', '2', '小b', '男', '16786656764');
INSERT INTO `dormmanager` VALUES ('3', 'manager3', '333333', '3', '小c', '男', '15786656789');
INSERT INTO `dormmanager` VALUES ('4', 'manager4', '444444', '4', '小d', '女', '16787789876');
INSERT INTO `dormmanager` VALUES ('9', 'manager6', '666666', '6', 'hh', '女', '15556778987');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `studentNumber` varchar(20) DEFAULT NULL,
  `studentName` varchar(30) DEFAULT NULL,
  `dormBuildId` int(11) DEFAULT NULL,
  `dormName` varchar(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `detail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '001', '学生001', '1', '101', '2019-10-09', '晚归');
INSERT INTO `record` VALUES ('2', '002', '学生002', '1', '102', '2019-10-15', '晚归');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `studentNum` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `dormBuildId` int(11) DEFAULT NULL,
  `dormName` varchar(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '001', '111111', '学生001', '1', '101', '男', '111111111');
INSERT INTO `student` VALUES ('2', '002', '111111', '学生002', '1', '102', '男', '112');
INSERT INTO `student` VALUES ('3', '003', '111111', '学生003', '2', '201', '男', '113');
INSERT INTO `student` VALUES ('4', '004', '111111', '学生004', '2', '202', '男', '114');
INSERT INTO `student` VALUES ('5', '005', '111111', '学生005', '3', '301', '男', '115');
INSERT INTO `student` VALUES ('6', '006', '111111', '学生006', '3', '302', '男', '116');
INSERT INTO `student` VALUES ('7', '007', '111111', '学生007', '4', '401', '女', '117');
INSERT INTO `student` VALUES ('8', '008', '111111', '学生008', '4', '402', '女', '118');
INSERT INTO `student` VALUES ('9', '009', '111111', '学生009', '5', '501', '女', '119');
INSERT INTO `student` VALUES ('10', '010', '111111', '学生010', '5', '502', '女', '120');
INSERT INTO `student` VALUES ('11', '011', '111111', '学生011', '6', '601', '女', '121');
INSERT INTO `student` VALUES ('12', '012', '111111', '学生012', '6', '602', '女', '122');
INSERT INTO `student` VALUES ('24', '013', '111111', '13', '1', '101', '男', '155');
INSERT INTO `student` VALUES ('25', '014', '111111', '14', '1', '101', '男', '166');
