-- MySQL dump 10.13  Distrib 5.5.45, for Linux (x86_64)
--
-- Host: localhost    Database: pasupukumkuma
-- -------------------------------------------------------
-- Server version	5.5.45-cll-lve

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`admin_id`, `email`, `password`) VALUES (5,'idwt365@gmail.com','h4jmtzHyjiMmRqoaHHpH8hj0gF2SsVtfKE9ytJTDQyyG8njJU/3A/kgtTNcjX1dtqITiTi99lLjw6X8G4dcUcw==');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `astrology_subscription_amount`
--

DROP TABLE IF EXISTS `astrology_subscription_amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `astrology_subscription_amount` (
  `subscription_amount_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(30) NOT NULL,
  `per` varchar(10) NOT NULL,
  PRIMARY KEY (`subscription_amount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `astrology_subscription_amount`
--

LOCK TABLES `astrology_subscription_amount` WRITE;
/*!40000 ALTER TABLE `astrology_subscription_amount` DISABLE KEYS */;
INSERT INTO `astrology_subscription_amount` (`subscription_amount_id`, `amount`, `per`) VALUES (3,'500','Year');
/*!40000 ALTER TABLE `astrology_subscription_amount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(100) NOT NULL,
  `puja_id` int(11) NOT NULL,
  `puja_samagri` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(50) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` (`cart_id`, `ip_address`, `puja_id`, `puja_samagri`, `date`, `time`, `datetime`) VALUES (1,'::1',3,0,'2015-08-22','2pm-4pm','2015-08-22 07:37:28'),(6,'49.205.93.121',3,0,'2012-12-12','2am-9am','2015-08-25 12:25:09'),(7,'49.205.93.121',2,1,'2015-12-12','8am-8am','2015-08-25 12:25:40'),(8,'49.205.93.121',1,0,'2012-12-12','1am-4am','2015-08-25 12:26:09'),(9,'103.232.129.138',3,0,'2015-09-19','4am-7am','2015-09-19 01:33:46'),(11,'49.206.241.31',2,1,'2016-05-26','4am-5am','2015-10-26 04:52:35'),(13,'27.6.178.158',4,0,'2015-11-21','8am-5pm','2015-11-20 09:25:14'),(14,'49.204.90.19',3,0,'2015-12-15','4am-8pm','2015-11-20 10:19:04'),(15,'49.205.72.91',4,1,'2011-12-15','4am-6am','2015-11-25 11:03:04'),(16,'27.6.179.49',4,1,'2015-12-03','3am-6am','2015-12-03 09:15:34'),(18,'183.82.207.220',2,1,'2015-12-15','5pm-7am','2015-12-10 05:59:35'),(23,'27.6.178.254',3,0,'1970-01-01','1am-1am','2016-01-18 10:22:03'),(26,'183.82.209.7',4,0,'2016-02-19','5am-6am','2016-01-27 09:21:23'),(28,'27.6.178.254',4,0,'2016-01-29','4pm-7pm','2016-01-29 07:41:37');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_puja_samagri`
--

DROP TABLE IF EXISTS `cart_puja_samagri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_puja_samagri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `puja_id` int(11) NOT NULL,
  `ip_address` varchar(100) NOT NULL,
  `puja_samagri` varchar(255) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_puja_samagri`
--

LOCK TABLES `cart_puja_samagri` WRITE;
/*!40000 ALTER TABLE `cart_puja_samagri` DISABLE KEYS */;
INSERT INTO `cart_puja_samagri` (`id`, `puja_id`, `ip_address`, `puja_samagri`, `datetime`) VALUES (2,2,'49.205.93.121','4','2015-08-25 12:23:26'),(3,3,'49.205.93.121','3','2015-08-25 12:27:11'),(5,2,'49.206.241.31','5','2015-10-26 04:51:59'),(7,4,'115.98.163.112','6,7','2015-11-04 03:55:57'),(8,4,'49.205.72.91','6,7,8','2015-11-25 11:02:35'),(9,4,'27.6.179.49','6,7','2015-12-03 09:14:54'),(10,2,'183.82.207.220','4,5','2015-12-10 05:59:03');
/*!40000 ALTER TABLE `cart_puja_samagri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ci_sessions`
--

DROP TABLE IF EXISTS `ci_sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ci_sessions` (
  `session_id` varchar(40) NOT NULL DEFAULT '0',
  `ip_address` varchar(45) NOT NULL DEFAULT '0',
  `user_agent` varchar(255) NOT NULL,
  `last_activity` int(10) unsigned NOT NULL DEFAULT '0',
  `user_data` text NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `last_activity_idx` (`last_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ci_sessions`
--

LOCK TABLES `ci_sessions` WRITE;
/*!40000 ALTER TABLE `ci_sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `ci_sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `subject` text NOT NULL,
  `query` longtext NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` (`contact_id`, `name`, `email`, `phone`, `subject`, `query`, `datetime`) VALUES (1,'sravan','sravan@gmail.com','9908646301','test mail','wsfljs lfjsl fosiufws fpp sfposkfs fss','2015-08-09 08:00:15'),(3,'admin','ewqew@kjsd.com','9908646301','kjahca lahlfaf','erte etertge etgyrethfgb','2015-08-09 08:03:29'),(4,'siri','sirisha.angani@gmail.com','34','11111',',,,,,,,,,,,,,,,,,,,,,,,,,,,,,','2016-01-11 07:03:06'),(5,'testing','test@gmail.com','654654','111111111111','111111111111111111111111111111111111111111111111111','2016-01-18 11:27:01');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nakshyatras`
--

DROP TABLE IF EXISTS `nakshyatras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nakshyatras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nakshyatram` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nakshyatras`
--

LOCK TABLES `nakshyatras` WRITE;
/*!40000 ALTER TABLE `nakshyatras` DISABLE KEYS */;
INSERT INTO `nakshyatras` (`id`, `nakshyatram`) VALUES (2,'Aswini'),(3,'Bharani'),(4,'Krithika'),(5,'Rohini '),(6,'Mrigashiras'),(7,'Aarudra');
/*!40000 ALTER TABLE `nakshyatras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puja_orders`
--

DROP TABLE IF EXISTS `puja_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puja_orders` (
  `puja_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ip_address` varchar(100) NOT NULL,
  `transaction_token` varchar(10) NOT NULL,
  `puja_id` int(11) NOT NULL,
  `amount` varchar(50) NOT NULL,
  `payed` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`puja_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puja_orders`
--

LOCK TABLES `puja_orders` WRITE;
/*!40000 ALTER TABLE `puja_orders` DISABLE KEYS */;
INSERT INTO `puja_orders` (`puja_order_id`, `user_id`, `ip_address`, `transaction_token`, `puja_id`, `amount`, `payed`, `datetime`) VALUES (5,3,'::1','HvMh4oKL',3,'2250',1,'2015-08-08 08:05:11'),(6,8,'115.98.160.196','4nXNo5k0',2,'9000',1,'2015-08-23 09:27:14'),(7,8,'115.98.160.196','sWSvExer',2,'7000',1,'2015-08-23 09:27:47'),(8,3,'124.123.152.20','WoQNaCG9',2,'7000',1,'2015-08-24 08:50:23'),(9,0,'183.82.209.7','nHsMEVJ5',3,'2250',1,'2015-11-09 04:32:42'),(10,0,'183.82.209.7','NrBRledO',4,'2116',1,'2015-12-03 04:24:08'),(11,5,'183.82.215.180','akb9xv0K',3,'2000',0,'2016-01-11 07:27:24'),(12,5,'183.82.215.180','KkqZrdt2',3,'2000',0,'2016-01-11 07:38:14');
/*!40000 ALTER TABLE `puja_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puja_orders_details`
--

DROP TABLE IF EXISTS `puja_orders_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puja_orders_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `puja_order_id` int(11) NOT NULL,
  `puja_id` int(11) NOT NULL,
  `puja_samagri` varchar(150) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puja_orders_details`
--

LOCK TABLES `puja_orders_details` WRITE;
/*!40000 ALTER TABLE `puja_orders_details` DISABLE KEYS */;
INSERT INTO `puja_orders_details` (`id`, `puja_order_id`, `puja_id`, `puja_samagri`, `date`, `time`) VALUES (3,5,3,'1,2,3','2015-08-11','8am-10am'),(4,6,2,'','1970-01-01','1am-1am'),(5,6,3,'1,2','1970-01-01','2am-6am'),(6,7,2,'','1970-01-01','1am-1am'),(7,8,2,'','2015-08-28','4am-8am'),(8,9,3,'1,2,3','2015-10-19','5am-6am'),(9,10,4,'','2015-10-19','5am-8am'),(10,11,3,'','1970-01-01','1am-2am'),(11,12,3,'','2222-04-21','2am-2am');
/*!40000 ALTER TABLE `puja_orders_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puja_samagri`
--

DROP TABLE IF EXISTS `puja_samagri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puja_samagri` (
  `puja_samagri_id` int(11) NOT NULL AUTO_INCREMENT,
  `puja_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` varchar(10) NOT NULL,
  `price` varchar(10) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`puja_samagri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puja_samagri`
--

LOCK TABLES `puja_samagri` WRITE;
/*!40000 ALTER TABLE `puja_samagri` DISABLE KEYS */;
INSERT INTO `puja_samagri` (`puja_samagri_id`, `puja_id`, `name`, `quantity`, `price`, `datetime`) VALUES (1,3,'Cocanut','10','150','2015-08-01 11:49:00'),(2,3,'Pasupu','200gms','50','2015-08-01 04:17:33'),(3,3,'Kumkuma','200gms','50','2015-08-01 04:18:44'),(4,2,'fruits','i dzn','120','2015-08-25 11:45:01'),(5,2,'coconuut','5','50','2015-08-25 11:45:38'),(6,4,'PASUPU','250 GRAMS','20','2015-10-30 02:27:27'),(7,4,'KUMKUMA','250 GRAMS','20','2015-10-30 02:27:56'),(8,4,'coconut','5','100','2015-11-25 10:44:51');
/*!40000 ALTER TABLE `puja_samagri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pujas`
--

DROP TABLE IF EXISTS `pujas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pujas` (
  `puja_id` int(11) NOT NULL AUTO_INCREMENT,
  `puja_name` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `duration` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`puja_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pujas`
--

LOCK TABLES `pujas` WRITE;
/*!40000 ALTER TABLE `pujas` DISABLE KEYS */;
INSERT INTO `pujas` (`puja_id`, `puja_name`, `description`, `duration`, `price`, `photo`, `datetime`) VALUES (2,'KEDARESWARA VRATAM','vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv','1 Hour','7,000','sample.jpg','2015-07-29 08:45:11'),(3,'SATYANARAYANA VRATAM','lakjsdal djaskjd alkjda l dlaj dla dlaksjd','2 Hours','2,000','sample.jpg','2015-07-29 08:46:51'),(4,'GRUHA PRAVESHAM','GRUHA PRAVESHAM','2 HOURS','2116','sample.jpg','2015-10-30 02:24:18');
/*!40000 ALTER TABLE `pujas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriptions` (
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `amount` varchar(10) NOT NULL,
  `per` varchar(10) NOT NULL,
  `status` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`subscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` (`subscription_id`, `user_id`, `amount`, `per`, `status`, `datetime`) VALUES (5,7,'500','Year',1,'2015-08-22 08:25:50'),(6,8,'500','Year',1,'2015-08-23 09:31:13'),(7,9,'500','Year',1,'2015-08-25 12:31:56'),(8,4,'500','Year',0,'2016-01-08 02:35:42'),(9,4,'500','Year',0,'2016-01-08 02:35:55'),(10,5,'500','Year',0,'2016-01-11 07:34:22'),(11,5,'500','Year',0,'2016-01-11 09:45:57');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_requests`
--

DROP TABLE IF EXISTS `user_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_requests` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `subject` text NOT NULL,
  `message` longtext NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_requests`
--

LOCK TABLES `user_requests` WRITE;
/*!40000 ALTER TABLE `user_requests` DISABLE KEYS */;
INSERT INTO `user_requests` (`request_id`, `user_id`, `subject`, `message`, `datetime`) VALUES (1,3,'hello Test','lkwqlfdjqw ijdoqw qowuoq wuoq w lkwqlfdjqw ijdoqw qowuoq wuoq w','2015-08-17 07:33:08'),(2,8,'hi','plz','2015-08-23 09:20:49'),(3,9,'dvsdgsd','ssgsfgfg','2015-08-25 12:11:20');
/*!40000 ALTER TABLE `user_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_requests_reply`
--

DROP TABLE IF EXISTS `user_requests_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_requests_reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `message` longtext NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_requests_reply`
--

LOCK TABLES `user_requests_reply` WRITE;
/*!40000 ALTER TABLE `user_requests_reply` DISABLE KEYS */;
INSERT INTO `user_requests_reply` (`reply_id`, `request_id`, `user_id`, `message`, `datetime`) VALUES (1,2,8,'xfkgjdfkgjdfgj','2015-08-25 11:52:22'),(2,3,9,'gsfdgfgdfg','2015-08-25 12:11:54');
/*!40000 ALTER TABLE `user_requests_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `birth_place` varchar(255) NOT NULL,
  `birth_time` varchar(50) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `raasi` varchar(150) NOT NULL,
  `nakshyatram` varchar(150) NOT NULL,
  `address` varchar(255) NOT NULL,
  `area` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `random` varchar(30) NOT NULL,
  `status` int(11) NOT NULL,
  `subcription_status` int(11) NOT NULL DEFAULT '0',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `name`, `email`, `password`, `phone`, `dob`, `birth_place`, `birth_time`, `gender`, `raasi`, `nakshyatram`, `address`, `area`, `city`, `state`, `country`, `random`, `status`, `subcription_status`, `datetime`) VALUES (4,'sravan','sravanreddy.jukanti@gmail.com','nY4ekXuNHUH2GFczKpqwqpxQPWna8O4m8ePd90Eu3Grx9QsY4Mr29yArwnphuVMLva/dwoY5foYXnTmf0ZRaEQ==','9700814778','1990-06-03','hyderabad',': AM','Male','','','hyderabad','hyderabad','Hyderabad','Telangana','India','NFBwp6s7MC5ycO2k',1,0,'2016-01-08 02:33:37'),(5,'sirisha','sirisha.angani@gmail.com','wbwUo0JWpQ97zDgkHKr1qm7340lZhSpqY5+8siz7t3wTwb6X/DmtaxlgpAHU9sbfx9HEzMz1bcvJrh6ZBAFDrg==','8179729727','1988-07-30','hyderabad','9:38 AM','Female','Scorpio','6','hhhhhhsssssssssss','ameerpet','hyderabad','telangana','india','SRcBsF6V8ZGtNKd9',1,0,'2016-01-11 06:33:45'),(6,'satya','siri@gmail.com','UrrKlRBHiIql72xWreng1AjLqnzDC4LXM5MdTeSa6xnQamLp8zArR9Mc8ZiFHgm6H/jkf9EwBO8vS+GkOUMwJw==','1111','1990-04-25','hy','1:1 AM','Male','Aries','2','hhhhhhsssssssssss','ameerpet','hyderabad','telangana','india','uvoqpiDSrx7g3Azn',0,0,'2016-01-11 06:39:44'),(7,'yogi','kondavitiyogi@gmail.com','i/R9B3BQoyPYaG8H4SBP1dSbLXTkQ84lAZrVYDHbouHtVjm98Tc5mCHlqWj0DKoGTRDRfkpJ4KQ1a69P4DHsoA==','8008439741','1991-02-10','srikakulam','6:46 AM','Male','Sagittarius','4','3-2-332a','kukatpally','hyderabad','telangana','india','RTFfKILPhQXcNpG4',1,0,'2016-01-12 10:09:33'),(8,'murali','katragaddamurali704@gmail.com','WGB5zfkNszO3KyY9uSMLxxPYnLyp4iB49BfW9gjgf+gnJbzRbGIMTO3sLYmW0QfhHXGkUNAaXUgmpVD00xORtw==','9618616704','1990-04-04','ongole','1:1 AM','Male','Scorpio','3','h no 32-345','hhhhhhhhhhhhhhhhhh','hyderabad','andhrapradesh','india','P8fIoENDpmiKGr71',0,0,'2016-01-29 06:33:22');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pasupukumkuma'
--

--
-- Dumping routines for database 'pasupukumkuma'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-02  4:23:17
