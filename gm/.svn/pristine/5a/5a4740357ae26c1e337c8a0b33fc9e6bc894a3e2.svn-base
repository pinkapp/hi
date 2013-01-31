/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.23 : Database - gm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `manager_type` */

DROP TABLE IF EXISTS `manager_type`;

CREATE TABLE `manager_type` (
  `typeId` tinyint(4) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(10) NOT NULL,
  `valid` tinyint(1) NOT NULL DEFAULT '1',
  `note` varchar(100) DEFAULT '',
  `rights` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `manager_type` */

insert  into `manager_type`(`typeId`,`typeName`,`valid`,`note`,`rights`) values (1,'超级管理员',1,'超级管理员包含所有权限，不能修改，不能删除',''),(2,'策划',1,'策划','2,21,22,23,24,115,3,108,109,4,41,42,45'),(3,'客服',1,'客服','1,110,135,134'),(7,'系统测试',1,'系统测试','2,5,1,21,22,23,24,115,139,134,137,3,108,109,51,52,110,111,112,113,57,19,138,140,141,142,143,144,158,149,145,146,147,148,136'),(10,'一般管理员',1,'管理员','2,24,115');

/*Table structure for table `managers` */

DROP TABLE IF EXISTS `managers`;

CREATE TABLE `managers` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `userType` varchar(4) DEFAULT '1',
  `valid` tinyint(1) DEFAULT '1',
  `note` varchar(100) DEFAULT '',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `users_userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `managers` */

insert  into `managers`(`userId`,`userName`,`password`,`userType`,`valid`,`note`) values (1,'admin','21218CCA77804D2BA1922C33E0151105','1',NULL,'admin为特殊用户，不能修改，不能删除'),(3,'hdc','21218CCA77804D2BA1922C33E0151105','10',NULL,'hhh'),(58,'huangdc','F379EAF3C831B04DE153469D1BEC345E','10',NULL,''),(81,'woshicehua','444444','2',NULL,''),(82,'test','098F6BCD4621D373CADE4E832627B4F6','7',NULL,'');

/*Table structure for table `rights` */

DROP TABLE IF EXISTS `rights`;

CREATE TABLE `rights` (
  `rightId` int(11) NOT NULL AUTO_INCREMENT,
  `rightName` varchar(20) NOT NULL DEFAULT '',
  `iconCls` varchar(10) DEFAULT '',
  `rlink` varchar(50) DEFAULT '',
  `rdesc` varchar(10) DEFAULT '',
  `parentId` int(11) DEFAULT NULL,
  `rseq` int(11) DEFAULT NULL,
  `valid` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`rightId`)
) ENGINE=MyISAM AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

/*Data for the table `rights` */

insert  into `rights`(`rightId`,`rightName`,`iconCls`,`rlink`,`rdesc`,`parentId`,`rseq`,`valid`) values (1,'数据查询','icon-ok','','dff',0,5,1),(2,'基本管理','icon-back','','ss',0,1,1),(3,'充值管理','icon-ok','','ss',0,2,1),(4,'聊天管理','icon-back','','',0,3,1),(5,'玩家管理','icon-ok','','',0,4,1),(21,'踢人','icon-cut','mods/kick','',2,1,1),(22,'封账号','icon-back','mods/close','',2,2,1),(23,'封IP','icon-back','mods/closeIP','',2,3,1),(24,'发信','icon-back','mods/sendLetter','',2,4,1),(19,'竞技场查询','icon-ok','mods/arenaInfo','',1,9,1),(17,'国家人口分布','','','',1,7,1),(18,'国战数据查询','','','',1,8,1),(16,'拍卖行交易记录查询','','','',1,6,1),(41,'聊天关键字设置','','','',4,1,1),(42,'实时聊天监控','','','',4,2,1),(45,'禁言','','','',4,3,1),(51,'玩家登录查询','icon-ok','mods/loginInfo','',5,1,1),(52,'同IP查询','icon-ok','mods/sameIP','',5,2,1),(53,'礼包使用记录','','','',5,3,1),(54,'行动力使用记录','','','',5,4,1),(55,'活力使用记录','','','',5,5,1),(145,'每日登录统计','icon-back','mods/loginCount','',140,6,1),(134,'创建玩家','icon-back','mods/baseInfo_add','创建一个玩家账号',2,7,1),(115,'发金币','icon-back','mods/sendGold','',2,5,1),(114,'成就查询','','','',1,5,1),(113,'公会信息','icon-back','mods/guildInfo','',1,4,1),(111,'玩家英雄信息','icon-back','mods/heroInfo','',1,2,1),(110,'玩家基本信息','icon-back','mods/baseInfo','',1,1,1),(109,'玩家充值记录','icon-back','mods/rechargeLog','',3,2,1),(108,'玩家消费记录','icon-back','mods/consumeLog','',3,1,1),(56,'功勋使用记录','','','',1,6,1),(57,'邮件记录','icon-back','mods/mailInfo','',1,7,1),(112,'玩家建筑信息','icon-back','mods/buildInfo','',1,3,1),(107,'宝具系统查询','','','',1,10,1),(136,'玩家留存率','icon-back','mods/retentionRate','',140,12,1),(137,'修改玩家功能性建筑','icon-back','mods/funcBuildInfo_edit','',2,8,1),(138,'玩家道具信息','icon-ok','mods/propInfo','',1,11,1),(139,'修改玩家道具','icon-back','mods/propInfo_edit','',2,6,1),(140,'运营平台','icon-ok','','',0,7,1),(141,'每日注册统计','icon-back','mods/regCount','',140,1,1),(142,'每日充值统计','icon-back','mods/rechargeCount','',140,2,1),(143,'玩家充值排行','icon-back','mods/rechargeRank','',140,3,1),(144,'玩家月充值排行','icon-back','mods/rechargeRank1','',140,4,1),(146,'支付方式统计','icon-back','mods/paywayCount','',140,7,1),(147,'玩家年龄段统计','icon-back','mods/ageGroupCount','',140,8,1),(148,'玩家职业统计','icon-back','mods/careerCount','',140,9,1),(149,'充值玩家统计','icon-back','mods/rechargeCount1','',140,6,1),(152,'修改玩家英雄属性','icon-back','','',2,9,1),(151,'修改玩家基本信息','icon-back','','',2,10,1),(153,'接触背包和仓库格子','icon-back','','',2,12,1),(154,'扩地','icon-back','','',2,11,1),(155,'移除功能性建筑','icon-back','','',2,13,1),(156,'修改关卡进度','icon-back','','',2,14,1),(157,'立刻完成任务目标','icon-back','','',2,15,1),(158,'玩家日期段充值排行','icon-back','mods/rechargeRank2','',140,5,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
