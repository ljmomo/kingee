/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : junly

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-24 18:15:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '资源名称',
  `symbol` varchar(64) DEFAULT NULL COMMENT '资源标识',
  `url` varchar(512) DEFAULT NULL COMMENT '菜单(资源)路径',
  `icon` varchar(512) DEFAULT NULL COMMENT '菜单小图标地址',
  `parent_id` int(20) NOT NULL DEFAULT '0',
  `menu_order` int(20) DEFAULT NULL,
  `is_usable` varchar(10) DEFAULT '1' COMMENT '是否可用,1：可用，0不可用',
  `remark` varchar(512) DEFAULT NULL COMMENT '资源备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', 'system', '', '&#xe690;', '0', null, '1', '', null);
INSERT INTO `sys_menu` VALUES ('2', '组织机构', 'orign', '../systemManage/organizationStructure.html', '&#xe947;', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('3', '角色管理', 'sysuser', '../systemManage/userManage.html', '&#xe77b;', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('4', '用户管理', 'sysrole', '../systemManage/roleManage.html', '&#xea62;', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('5', '用户反馈', 'userfree', '../systemManage/userFeedback.html', '&#xe6e4;', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('6', '帮助中心', 'helpcenter', '../systemManage/helpCenter.html', '&#xe659;', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('7', '电磁阀管理', 'dcfmanager', '', '&#xe642;', '0', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('8', '送检管理', 'jcmanager', '../electricityManage/inspectManage.html', '&#xe622;', '7', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('9', '测试管理', 'testmanager', '../electricityManage/testManage.html', '&#xe75f;', '7', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('10', '产品管理', 'productmanager', '../electricityManage/productManage.html', '&#xe61b;', '7', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('11', '分类管理', 'classisymanager', '../electricityManage/classifyManage.html', '&#xe60d;', '7', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('12', '数据库管理', 'dataMange', '../electricityManage/dataManage.html', '&#xe60e;', '7', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('13', '用户管理', 'usermanager', '', '&#xe77b;', '0', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('14', '会员管理', 'usemanager', '../userManage/userManage.html', '&#xe600;', '13', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('15', '交流圈管理', 'exchangemanage', '../userManage/exchangeManage.html', '&#xe60b;', '13', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('16', '资料管理', 'infomanage', '', '&#xe6ae;', '0', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('17', '专业课堂', 'professionclassroom', '../dataManage/majorClassroom.html', '&#xe601;', '16', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('18', '行业动态', 'industystate', '../dataManage/industyState.html', '&#xe649;', '16', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('19', '消息管理', 'messagemanage', '', '&#xe60e;', '0', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('20', '消息管理', 'newsmanage', '../newsManage/newsManage.html', '&#xe60e;', '19', null, '1', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '888888');
INSERT INTO `sys_role` VALUES ('3', '权限角色', '100003');
INSERT INTO `sys_role` VALUES ('4', '用户中心', '100002');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `authority_mode` int(1) DEFAULT '10' COMMENT '10-一次性授权模式  20-可重复授权模式',
  `create_time` datetime DEFAULT NULL COMMENT '授权创建时间',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13213 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  `user_type` int(11) NOT NULL DEFAULT '0' COMMENT 'SYSTEM_MANAGER(0, "平台管理员")  DEALER(1, "经销商") COMMON_MEMBER(2, "普通会员")',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('12', 'admin', '4afdc875a67a55528c224ce088be2ab8', '2016-05-27 22:34:19', '1', '0');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `user_id` varchar(20) NOT NULL COMMENT '用户名',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '性别：0-保密 1-男  2-女',
  `birthday` varchar(22) DEFAULT NULL COMMENT '生日',
  `auth_type` int(11) NOT NULL DEFAULT '0' COMMENT '验证类型：0：暂未验证，1：手机已验证，2：email已验证，3：手机email都已验证',
  `head_url` varchar(255) DEFAULT NULL,
  `user_from` int(11) NOT NULL DEFAULT '10' COMMENT '用户来源：10-App注册  20-网站注册  30-第三方平台   (40-网络宣传  50-线下宣传)',
  `user_level` int(11) DEFAULT '0' COMMENT '用户等级 0 普通 1 黄金',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登陆IP',
  `last_login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('12', null, '0', null, '0', 'https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png', '10', '0', null, '2017-03-23 20:12:30', '2017-03-23 20:12:30', '2017-03-23 20:12:30');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('12', '4');
INSERT INTO `sys_user_role` VALUES ('11', '3');
INSERT INTO `sys_user_role` VALUES ('11', '4');
INSERT INTO `sys_user_role` VALUES ('1', '1');

-- ----------------------------
-- Procedure structure for init_shiro_demo
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_shiro_demo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `init_shiro_demo`()
BEGIN	
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - 
*********************************************************************
*/
/*表结构插入*/
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role` */
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role_permission` */
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*Table structure for table `u_user` */
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*Table structure for table `u_user_role` */
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/
/*所有的表数据插入*/
/*Data for the table `u_permission` */
insert  into `u_permission`(`id`,`url`,`name`) values (4,'/permission/index.shtml','权限列表'),(6,'/permission/addPermission.shtml','权限添加'),(7,'/permission/deletePermissionById.shtml','权限删除'),(8,'/member/list.shtml','用户列表'),(9,'/member/online.shtml','在线用户'),(10,'/member/changeSessionStatus.shtml','用户Session踢出'),(11,'/member/forbidUserById.shtml','用户激活&禁止'),(12,'/member/deleteUserById.shtml','用户删除'),(13,'/permission/addPermission2Role.shtml','权限分配'),(14,'/role/clearRoleByUserIds.shtml','用户角色分配清空'),(15,'/role/addRole2User.shtml','角色分配保存'),(16,'/role/deleteRoleById.shtml','角色列表删除'),(17,'/role/addRole.shtml','角色列表添加'),(18,'/role/index.shtml','角色列表'),(19,'/permission/allocation.shtml','权限分配'),(20,'/role/allocation.shtml','角色分配');
/*Data for the table `u_role` */
insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');
/*Data for the table `u_role_permission` */
insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);
/*Data for the table `u_user` */
insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','9c3250081c7b1f5c6cbb8096e3e1cd04','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);
/*Data for the table `u_user_role` */
insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);
   
    END
;;
DELIMITER ;
