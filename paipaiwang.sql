/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.54-log : Database - paipaiwang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`paipaiwang` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `super_user` tinyint(1) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`username`,`password`,`super_user`,`remark`,`create_time`) values ('paipaiwang','A28A786E44E23E10B9B02467F691DC1E',1,'管理系统默认超级管理员，不允许删除以及更改权限','2017-04-08 14:36:37'),('xiaojiazhou','A28A786E44E23E10B9B02467F691DC1E',1,'','2017-04-10 15:19:30'),('yichimai','A28A786E44E23E10B9B02467F691DC1E',0,'nihaoa a a a','2017-04-10 15:17:21');

/*Table structure for table `t_advertisement` */

DROP TABLE IF EXISTS `t_advertisement`;

CREATE TABLE `t_advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture` varchar(50) NOT NULL,
  `url` varchar(50) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_advertisement` */

insert  into `t_advertisement`(`id`,`picture`,`url`,`remark`,`create_time`,`title`) values (1,'a60ae312-f288-4ad3-a841-a852d18f2c9b.jpg','http://www.baidu.com','balabala','2017-04-29 15:52:05','某某商品特价'),(2,'adv.jpg','www.baidu.com','balabala','2017-04-12 21:47:08','广告轮播图的标题（鼠标停止的时候显示）'),(3,'adv.jpg','www.baidu.com','balabala','2017-04-12 21:47:08','广告轮播图的标题（鼠标停止的时候显示）'),(4,'adv.jpg','www.baidu.com','balabala','2017-04-12 21:47:08','广告轮播图的标题（鼠标停止的时候显示）');

/*Table structure for table `t_auction` */

DROP TABLE IF EXISTS `t_auction`;

CREATE TABLE `t_auction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_auction` */

insert  into `t_auction`(`id`,`item_id`,`user_id`,`price`,`remark`) values (8,1000000036,26,10000,NULL),(9,1000000036,25,11000,NULL),(10,1000000036,26,11500,NULL),(11,1000000036,27,12000,NULL),(12,1000000037,27,2000,NULL),(13,1000000037,27,3500,NULL),(14,1000000037,27,6500,NULL),(15,1000000039,27,100,NULL);

/*Table structure for table `t_collection` */

DROP TABLE IF EXISTS `t_collection`;

CREATE TABLE `t_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `collect_time` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_collection` */

insert  into `t_collection`(`id`,`item_id`,`user_id`,`collect_time`,`remark`) values (6,1000000036,26,'2017-04-28 00:34:11',NULL),(7,1000000038,27,'2017-05-08 22:03:37',NULL);

/*Table structure for table `t_daybook` */

DROP TABLE IF EXISTS `t_daybook`;

CREATE TABLE `t_daybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `admin_username` varchar(30) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `price` double NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_daybook` */

/*Table structure for table `t_freeze` */

DROP TABLE IF EXISTS `t_freeze`;

CREATE TABLE `t_freeze` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_freeze` */

/*Table structure for table `t_intervene` */

DROP TABLE IF EXISTS `t_intervene`;

CREATE TABLE `t_intervene` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(1) NOT NULL,
  `order_id` int(11) NOT NULL,
  `for_what` varchar(255) DEFAULT NULL,
  `for_why` varchar(255) DEFAULT NULL,
  `state` tinyint(1) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_intervene` */

insert  into `t_intervene`(`id`,`type`,`order_id`,`for_what`,`for_why`,`state`,`remark`,`create_time`) values (1,0,1000000036,'买家损坏物品后恶意退货','买家损坏物品后恶意退货',0,NULL,'2017-04-30 00:06:11'),(2,1,1000000037,'退款并要求卖家赔偿','买家迟迟不发货',1,NULL,'2017-05-08 09:04:03'),(3,0,1000000037,'买家赔偿商品损坏损失费用','买家恶意损坏商品后退货',1,NULL,'2017-05-15 09:56:55'),(4,1,1000000036,'退货','卖家不肯退货',0,NULL,'2017-05-15 09:57:55'),(5,0,1000000039,'解决卖家恶意退货','卖家恶意退货',1,NULL,'2017-05-17 23:09:05'),(6,1,1000000039,'卖家赔偿损失','卖家不赔偿物品损坏的金额',1,NULL,'2017-05-17 23:11:21');

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `brief` varchar(40) NOT NULL,
  `type` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `price` double NOT NULL,
  `price_add` double NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `publish_time` datetime NOT NULL,
  `picture1` varchar(50) DEFAULT NULL,
  `picture2` varchar(50) DEFAULT NULL,
  `picture3` varchar(50) DEFAULT NULL,
  `identify_picture` varchar(50) DEFAULT NULL,
  `item_description` varchar(10000) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `owner` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000040 DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`id`,`name`,`brief`,`type`,`number`,`price`,`price_add`,`start_date`,`end_date`,`publish_time`,`picture1`,`picture2`,`picture3`,`identify_picture`,`item_description`,`remark`,`owner`,`state`) values (1000000036,'水墨画','祖传水墨画',2,1,10000,500,'2017-04-28','2017-04-28','2017-04-28 00:19:38','fd4dca86-4092-4919-8264-c591da4f14a2.jpg',NULL,NULL,NULL,'某朝代祖辈相传而来的水墨画','备注信息',25,5),(1000000037,'山水画','祖传的山水画',2,1,2000,500,'2017-04-29','2017-04-29','2017-04-29 15:55:46','02400488-6515-4944-b246-3801bbbb8936.jpg',NULL,NULL,NULL,'祖传而来的山水画，很值钱','备注信息',25,5),(1000000038,'清明上河图','',2,1,200,50,'2017-05-08','2017-05-08','2017-05-08 09:37:43','3a4b1304-1563-427e-acd3-580601609dd2.jpg',NULL,NULL,NULL,'','备注信息',25,4),(1000000039,'你好啊','啊啊啊',17,1,100,50,'2017-05-17','2017-05-17','2017-05-17 22:27:06','3307693f-a0b9-4a16-b063-8cd61e50202e.jpg',NULL,NULL,NULL,'','备注信息',25,5);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `create_date` date NOT NULL,
  `finish_time` datetime DEFAULT NULL,
  `send_name` varchar(20) DEFAULT NULL,
  `send_phone` varchar(20) DEFAULT NULL,
  `send_address` varchar(200) DEFAULT NULL,
  `send_postcode` varchar(20) DEFAULT NULL,
  `send_others` varchar(200) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `evaluate` tinyint(1) NOT NULL,
  `evaluation` varchar(10000) DEFAULT NULL,
  `return_reason` varchar(10000) DEFAULT NULL,
  `last_state_time` datetime DEFAULT NULL,
  `express_company` varchar(20) DEFAULT NULL,
  `express_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`user_id`,`price`,`create_date`,`finish_time`,`send_name`,`send_phone`,`send_address`,`send_postcode`,`send_others`,`remark`,`state`,`evaluate`,`evaluation`,`return_reason`,`last_state_time`,`express_company`,`express_id`) values (1000000036,27,12000,'2017-04-29','2017-04-29 11:26:51','尼古拉斯*赵四','17123123123','你卢卡斯的撒旦个','888888','最好发圆通快递',NULL,3,1,'请了专家鉴定，能确定是正品，好评',NULL,'2017-04-29 11:26:51','圆通快递','6666666'),(1000000037,27,6500,'2017-04-30','2017-05-08 09:27:45','尼古拉斯*赵四','17123123123','在那遥远的地方','000000','',NULL,5,0,NULL,'暴力快递，商品被损坏','2017-05-08 09:33:54','顺丰快递','8888888888'),(1000000039,27,100,'2017-05-17','2017-05-17 22:28:58','尼古拉斯*赵四','17123123123','你卢卡斯的撒旦个','888888','',NULL,8,0,NULL,'商品运送过程中损坏','2017-05-17 22:29:32','圆通快递','8888888');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `parent` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`,`parent`,`remark`) values (1,'书法绘画',0,NULL),(2,'绘画',1,NULL),(3,'书法',1,NULL),(4,'古籍文献',1,NULL),(5,'西画雕塑',0,NULL),(6,'油画',5,NULL),(7,'水彩',5,NULL),(8,'雕塑',5,NULL),(9,'古瓷珠宝',0,NULL),(10,'玉器',9,NULL),(11,'陶瓷',9,NULL),(12,'木器',9,NULL),(13,'当代工艺',0,NULL),(14,'珠宝',13,NULL),(15,'金属器',13,NULL),(16,'各类杂货',0,NULL),(17,'二手商品',0,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobiphone` varchar(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realname` varchar(10) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `gender` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `user_money` double NOT NULL,
  `freeze` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`mobiphone`,`username`,`password`,`realname`,`idcard`,`gender`,`email`,`address`,`postcode`,`remark`,`user_money`,`freeze`) values (25,'13123123123','葬爱家族*忘了爱','4297F44B13955235245B2497399D7A93','张三','440888888888888888',1,'aaa@aa.com','广东海洋大学某宿舍','000000',NULL,41300,0),(26,'14123123123','葬爱家族*硪不蓜','4297F44B13955235245B2497399D7A93','李四','440888888888888888',1,'aaaa@a.com','广东思考的风景阿里','000000',NULL,10000,0),(27,'17123123123','尼古拉斯*赵四','4297F44B13955235245B2497399D7A93','赵日天','440888888888888888',1,'a@aa.com','你卢卡斯的撒旦个','888888',NULL,100000,0),(28,'15123123123','nihao','4297F44B13955235245B2497399D7A93','张三','4408888888888888',1,'aa@aa.com','广东海洋大学某宿舍','000000',NULL,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
