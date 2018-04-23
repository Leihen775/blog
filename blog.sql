/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-04-23 22:56:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客ID',
  `publishsort` int(1) DEFAULT NULL COMMENT '发布类别(0:原创,1:转载,2:翻译)',
  `title` varchar(32) DEFAULT NULL COMMENT '博客标题',
  `content` text COMMENT '博客内容',
  `category_id` int(11) DEFAULT NULL COMMENT '博客分类ID',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `clickcount` int(11) DEFAULT NULL COMMENT '浏览次数',
  `enjoycount` int(11) DEFAULT NULL COMMENT '被赞次数',
  `commentcount` int(11) DEFAULT NULL COMMENT '评论数量',
  `state` int(1) DEFAULT NULL COMMENT '存在状态(0:草稿,1:已发布,2:已删除,)',
  `is_private` int(1) DEFAULT NULL COMMENT '是否私密(0:公开,1:私密,)',
  `user_id` int(11) DEFAULT NULL COMMENT '发布人ID',
  PRIMARY KEY (`id`),
  KEY `ba_categoryID` (`category_id`),
  KEY `ba_userID` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('15', '0', '第一条数据', '这是添加的第一条测试数据', '2', '2018-04-21 14:35:31', '89', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('16', '0', '第二条数据', '这是添加的第二条测试数据', '5', '2018-04-21 14:36:45', '115', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('17', '0', '第三条数据', '这是添加的第三条测试数据', '3', '2018-04-21 14:37:34', '22', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('18', '0', '第四条数据', '这是添加的第四条数据', '2', '2018-04-22 14:05:33', '234', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('19', '1', '第五条数据', '这是添加的第五条测试数据', '1', '2018-04-22 08:32:08', '324', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('20', '0', '第六条数据', '这是添加的第六条数据', '4', '2018-04-22 18:33:43', '556', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('21', '0', '第七条数据', '这是添加的第七条数据', '9', '2018-04-23 08:34:42', '225', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('22', '0', '第八条数据', '这是添加的第八条数据', '7', '2018-04-23 09:35:35', '174', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('23', '0', '第九条数据', '这是添加的第九条数据', '6', '2018-04-23 10:37:16', '113', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('24', '0', '第十条数据', '这是添加的第十条数据', '8', '2018-04-23 11:37:22', '119', null, null, '0', '0', '0');
INSERT INTO `blog_article` VALUES ('25', '0', '第十一条数据', '这是添加的第十一条数据', '5', '2018-04-23 12:37:27', '52', null, null, '0', '0', '0');

-- ----------------------------
-- Table structure for blog_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客文章和标签关系ID',
  `article_id` int(11) DEFAULT NULL COMMENT '博客文章ID',
  `tag_id` int(11) DEFAULT NULL COMMENT '博客标签ID',
  PRIMARY KEY (`id`),
  KEY `bat_articleID` (`article_id`),
  KEY `bat_tagID` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article_tag
-- ----------------------------
INSERT INTO `blog_article_tag` VALUES ('3', '15', '2');
INSERT INTO `blog_article_tag` VALUES ('4', '15', '3');
INSERT INTO `blog_article_tag` VALUES ('5', '16', '1');
INSERT INTO `blog_article_tag` VALUES ('7', '17', '3');
INSERT INTO `blog_article_tag` VALUES ('8', '17', '4');
INSERT INTO `blog_article_tag` VALUES ('11', '18', '1');
INSERT INTO `blog_article_tag` VALUES ('12', '18', '3');
INSERT INTO `blog_article_tag` VALUES ('13', '19', '2');
INSERT INTO `blog_article_tag` VALUES ('14', '20', '4');
INSERT INTO `blog_article_tag` VALUES ('15', '21', '3');
INSERT INTO `blog_article_tag` VALUES ('16', '22', '4');
INSERT INTO `blog_article_tag` VALUES ('19', '24', '1');
INSERT INTO `blog_article_tag` VALUES ('20', '25', '1');
INSERT INTO `blog_article_tag` VALUES ('21', '25', '4');
INSERT INTO `blog_article_tag` VALUES ('24', '23', '2');
INSERT INTO `blog_article_tag` VALUES ('25', '23', '3');

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(32) DEFAULT NULL COMMENT '分类名称',
  `code` varchar(8) DEFAULT NULL COMMENT '分类编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1', '人工智能', '1201');
INSERT INTO `blog_category` VALUES ('2', '云计算/大数据', '1202');
INSERT INTO `blog_category` VALUES ('3', '区块链', '1203');
INSERT INTO `blog_category` VALUES ('4', '数据库', '1204');
INSERT INTO `blog_category` VALUES ('5', '程序人生', '1205');
INSERT INTO `blog_category` VALUES ('6', '游戏开发', '1206');
INSERT INTO `blog_category` VALUES ('7', '研发管理', '1207');
INSERT INTO `blog_category` VALUES ('8', '前端', '1208');
INSERT INTO `blog_category` VALUES ('9', '移动开发', '1209');
INSERT INTO `blog_category` VALUES ('10', '物联网', '1210');

-- ----------------------------
-- Table structure for blog_collect
-- ----------------------------
DROP TABLE IF EXISTS `blog_collect`;
CREATE TABLE `blog_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏表ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `url` varchar(64) DEFAULT NULL COMMENT '地址',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `article_id` int(11) DEFAULT NULL COMMENT '博客文章ID',
  PRIMARY KEY (`id`),
  KEY `bco_userID` (`user_id`),
  KEY `bco_articleID` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_collect
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `content` text COMMENT '评论内容',
  `publish_time` datetime DEFAULT NULL COMMENT '评论时间',
  `article_id` int(11) DEFAULT NULL COMMENT '博客文章ID',
  `user_id` int(11) DEFAULT NULL COMMENT '评论者ID',
  `recipient_uid` int(11) DEFAULT NULL COMMENT '收到评论的用户ID',
  `pid` int(11) DEFAULT NULL COMMENT '父级评论',
  PRIMARY KEY (`id`),
  KEY `bc_articleid` (`article_id`),
  KEY `bc_getuserid` (`recipient_uid`),
  KEY `bc_pid` (`pid`),
  KEY `bc_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_enjoy
-- ----------------------------
DROP TABLE IF EXISTS `blog_enjoy`;
CREATE TABLE `blog_enjoy` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章喜欢表ID',
  `user_id` int(11) DEFAULT NULL COMMENT '文章喜欢人ID',
  `article_id` int(11) DEFAULT NULL COMMENT '文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_enjoy
-- ----------------------------

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag` varchar(32) DEFAULT NULL COMMENT '标签名称',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `bt_userid` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('1', 'java', '1');
INSERT INTO `blog_tag` VALUES ('2', 'spring', '1');
INSERT INTO `blog_tag` VALUES ('3', 'mybatis', '1');
INSERT INTO `blog_tag` VALUES ('4', 'springMVC', '1');

-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统通知表',
  `content` text COMMENT '通知内容',
  `publish_time` datetime DEFAULT NULL COMMENT '通知时间',
  `sender_id` int(11) DEFAULT NULL COMMENT '发信者ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_message
-- ----------------------------

-- ----------------------------
-- Table structure for sys_message_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_message_user`;
CREATE TABLE `sys_message_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统消息与用户关系表ID',
  `recipient_uid` int(11) DEFAULT NULL COMMENT '接受者ID',
  `message_id` int(11) DEFAULT NULL COMMENT '系统消息ID',
  `is_sysmessage` int(1) DEFAULT NULL COMMENT '是否为系统通知(0:否,1:是)',
  `state` int(1) DEFAULT NULL COMMENT '存在状态(0:未查看,1:已查看,2:已删除)',
  PRIMARY KEY (`id`),
  KEY `smu_userID` (`recipient_uid`),
  KEY `smu_messageID` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_message_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `rank` varchar(255) DEFAULT NULL COMMENT '角色权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '一级权限');
INSERT INTO `sys_role` VALUES ('2', '注册用户', '二级权限');
INSERT INTO `sys_role` VALUES ('3', '普通用户', '三级权限');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL COMMENT '用户角色关系ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user_attention
-- ----------------------------
DROP TABLE IF EXISTS `user_attention`;
CREATE TABLE `user_attention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '关注人ID',
  `attention_uid` int(11) DEFAULT NULL COMMENT '被关注人ID',
  PRIMARY KEY (`id`),
  KEY `ua_attentionid` (`attention_uid`),
  KEY `ua_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_attention
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户信息表ID',
  `accountnum` varchar(32) DEFAULT NULL COMMENT '账号',
  `username` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `realname` varchar(16) DEFAULT NULL COMMENT '真实姓名',
  `job` varchar(32) DEFAULT NULL COMMENT '工作',
  `sex` int(1) DEFAULT '0' COMMENT '性别(0:男,1:女)',
  `birth` date DEFAULT NULL COMMENT '生日',
  `trade_id` int(11) DEFAULT NULL COMMENT '行业ID',
  `adress` varchar(32) DEFAULT NULL COMMENT '所在地区',
  `email` varchar(32) DEFAULT NULL COMMENT '用户邮箱',
  `summary` text COMMENT '个人简介',
  `image_path` varchar(64) DEFAULT NULL COMMENT '图片路径',
  `birth_private` int(1) DEFAULT '0' COMMENT '生日是否私密(0:否1:是)',
  `realname_private` int(1) DEFAULT NULL COMMENT '真实姓名是否私密(0:否1:是)',
  `address_private` int(1) DEFAULT NULL COMMENT '地址是否私密(0:否1:是)',
  `attentioncount` int(11) DEFAULT NULL COMMENT '关注数',
  `fanscount` int(11) DEFAULT NULL COMMENT '粉丝数',
  `articlecount` int(11) DEFAULT NULL COMMENT '原创文章数量',
  `commentcount` int(11) DEFAULT NULL COMMENT '评论数量',
  `praisecount` int(11) DEFAULT NULL COMMENT '喜欢数量',
  PRIMARY KEY (`id`),
  KEY `ui_tradeid` (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_trade
-- ----------------------------
DROP TABLE IF EXISTS `user_trade`;
CREATE TABLE `user_trade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL COMMENT '行业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_trade
-- ----------------------------
