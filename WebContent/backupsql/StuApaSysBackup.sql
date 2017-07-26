-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: stuaptsys
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Current Database: `stuaptsys`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `stuaptsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stuaptsys`;

--
-- Table structure for table `apartment`
--

DROP TABLE IF EXISTS `apartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartment` (
  `apartno` varchar(5) NOT NULL,
  `lvdornum` int(11) NOT NULL,
  `stutotnum` int(11) NOT NULL,
  `stulivnum` int(11) NOT NULL,
  `area` float NOT NULL,
  `levels` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`apartno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment`
--

LOCK TABLES `apartment` WRITE;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
INSERT INTO `apartment` VALUES ('D1',15,420,0,600,7),('D5',20,80,0,200,6),('X10',20,480,0,200.8,6),('X11',20,480,0,200,6),('X12',20,480,0,400,6),('X2',20,80,0,200,5),('X3',20,80,0,200,6),('X4',20,80,0,200,6),('X5',20,80,0,200,6),('X6',20,0,0,100.8,6),('X7',20,0,0,200,6),('X8',20,480,0,200.8,6),('X9',20,480,0,300,6);
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `costno` varchar(10) NOT NULL,
  `dorno` varchar(10) NOT NULL,
  `rctype` tinyint(4) NOT NULL,
  `rcmoney` int(11) NOT NULL,
  `rctime` datetime NOT NULL,
  `used` int(11) NOT NULL,
  `remain` int(11) NOT NULL,
  `totmoney` int(11) NOT NULL,
  PRIMARY KEY (`costno`),
  KEY `dorno` (`dorno`),
  CONSTRAINT `cost_ibfk_1` FOREIGN KEY (`dorno`) REFERENCES `dormitory` (`dorno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormitory`
--

DROP TABLE IF EXISTS `dormitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dormitory` (
  `dorno` varchar(10) NOT NULL,
  `apartno` varchar(10) NOT NULL,
  `stutotnum` tinyint(4) NOT NULL,
  `stulivnum` tinyint(4) NOT NULL,
  `stuno` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`dorno`),
  KEY `apartno` (`apartno`),
  KEY `stuno` (`stuno`),
  CONSTRAINT `dormitory_ibfk_1` FOREIGN KEY (`apartno`) REFERENCES `apartment` (`apartno`),
  CONSTRAINT `dormitory_ibfk_2` FOREIGN KEY (`stuno`) REFERENCES `student` (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory`
--

LOCK TABLES `dormitory` WRITE;
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
INSERT INTO `dormitory` VALUES ('D1-101','D1',4,0,NULL),('D1-102','D1',4,0,NULL),('D1-103','D1',4,0,NULL),('D1-104','D1',4,0,NULL),('D1-105','D1',4,0,NULL),('D1-106','D1',4,0,NULL),('D1-107','D1',4,0,NULL),('D1-108','D1',4,0,NULL),('D1-109','D1',4,0,NULL),('D1-110','D1',4,0,NULL),('D1-111','D1',4,0,NULL),('D1-112','D1',4,0,NULL),('D1-113','D1',4,0,NULL),('D1-114','D1',4,0,NULL),('D1-115','D1',4,0,NULL),('D1-201','D1',4,0,NULL),('D1-202','D1',4,0,NULL),('D1-203','D1',4,0,NULL),('D1-204','D1',4,0,NULL),('D1-205','D1',4,0,NULL),('D1-206','D1',4,0,NULL),('D1-207','D1',4,0,NULL),('D1-208','D1',4,0,NULL),('D1-209','D1',4,0,NULL),('D1-210','D1',4,0,NULL),('D1-211','D1',4,0,NULL),('D1-212','D1',4,0,NULL),('D1-213','D1',4,0,NULL),('D1-214','D1',4,0,NULL),('D1-215','D1',4,0,NULL),('D1-301','D1',4,0,NULL),('D1-302','D1',4,0,NULL),('D1-303','D1',4,0,NULL),('D1-304','D1',4,0,NULL),('D1-305','D1',4,0,NULL),('D1-306','D1',4,0,NULL),('D1-307','D1',4,0,NULL),('D1-308','D1',4,0,NULL),('D1-309','D1',4,0,NULL),('D1-310','D1',4,0,NULL),('D1-311','D1',4,0,NULL),('D1-312','D1',4,0,NULL),('D1-313','D1',4,0,NULL),('D1-314','D1',4,0,NULL),('D1-315','D1',4,0,NULL),('D1-401','D1',4,0,NULL),('D1-402','D1',4,0,NULL),('D1-403','D1',4,0,NULL),('D1-404','D1',4,0,NULL),('D1-405','D1',4,0,NULL),('D1-406','D1',4,0,NULL),('D1-407','D1',4,0,NULL),('D1-408','D1',4,0,NULL),('D1-409','D1',4,0,NULL),('D1-410','D1',4,0,NULL),('D1-411','D1',4,0,NULL),('D1-412','D1',4,0,NULL),('D1-413','D1',4,0,NULL),('D1-414','D1',4,0,NULL),('D1-415','D1',4,0,NULL),('D1-501','D1',4,0,NULL),('D1-502','D1',4,0,NULL),('D1-503','D1',4,0,NULL),('D1-504','D1',4,0,NULL),('D1-505','D1',4,0,NULL),('D1-506','D1',4,0,NULL),('D1-507','D1',4,0,NULL),('D1-508','D1',4,0,NULL),('D1-509','D1',4,0,NULL),('D1-510','D1',4,0,NULL),('D1-511','D1',4,0,NULL),('D1-512','D1',4,0,NULL),('D1-513','D1',4,0,NULL),('D1-514','D1',4,0,NULL),('D1-515','D1',4,0,NULL),('D1-601','D1',4,0,NULL),('D1-602','D1',4,0,NULL),('D1-603','D1',4,0,NULL),('D1-604','D1',4,0,NULL),('D1-605','D1',4,0,NULL),('D1-606','D1',4,0,NULL),('D1-607','D1',4,0,NULL),('D1-608','D1',4,0,NULL),('D1-609','D1',4,0,NULL),('D1-610','D1',4,0,NULL),('D1-611','D1',4,0,NULL),('D1-612','D1',4,0,NULL),('D1-613','D1',4,0,NULL),('D1-614','D1',4,0,NULL),('D1-615','D1',4,0,NULL),('D1-701','D1',4,0,NULL),('D1-702','D1',4,0,NULL),('D1-703','D1',4,0,NULL),('D1-704','D1',4,0,NULL),('D1-705','D1',4,0,NULL),('D1-706','D1',4,0,NULL),('D1-707','D1',4,0,NULL),('D1-708','D1',4,0,NULL),('D1-709','D1',4,0,NULL),('D1-710','D1',4,0,NULL),('D1-711','D1',4,0,NULL),('D1-712','D1',4,0,NULL),('D1-713','D1',4,0,NULL),('D1-714','D1',4,0,NULL),('D1-715','D1',4,0,NULL),('X12-101','X12',4,0,NULL),('X12-102','X12',4,0,NULL),('X12-103','X12',4,0,NULL),('X12-104','X12',4,0,NULL),('X12-105','X12',4,0,NULL),('X12-106','X12',4,0,NULL),('X12-107','X12',4,0,NULL),('X12-108','X12',4,0,NULL),('X12-109','X12',4,0,NULL),('X12-110','X12',4,0,NULL),('X12-111','X12',4,0,NULL),('X12-112','X12',4,0,NULL),('X12-113','X12',4,0,NULL),('X12-114','X12',4,0,NULL),('X12-115','X12',4,0,NULL),('X12-116','X12',4,0,NULL),('X12-117','X12',4,0,NULL),('X12-118','X12',4,0,NULL),('X12-119','X12',4,0,NULL),('X12-120','X12',4,0,NULL),('X12-201','X12',4,0,NULL),('X12-202','X12',4,0,NULL),('X12-203','X12',4,0,NULL),('X12-204','X12',4,0,NULL),('X12-205','X12',4,0,NULL),('X12-206','X12',4,0,NULL),('X12-207','X12',4,0,NULL),('X12-208','X12',4,0,NULL),('X12-209','X12',4,0,NULL),('X12-210','X12',4,0,NULL),('X12-211','X12',4,0,NULL),('X12-212','X12',4,0,NULL),('X12-213','X12',4,0,NULL),('X12-214','X12',4,0,NULL),('X12-215','X12',4,0,NULL),('X12-216','X12',4,0,NULL),('X12-217','X12',4,0,NULL),('X12-218','X12',4,0,NULL),('X12-219','X12',4,0,NULL),('X12-220','X12',4,0,NULL),('X12-301','X12',4,0,NULL),('X12-302','X12',4,0,NULL),('X12-303','X12',4,0,NULL),('X12-304','X12',4,0,NULL),('X12-305','X12',4,0,NULL),('X12-306','X12',4,0,NULL),('X12-307','X12',4,0,NULL),('X12-308','X12',4,0,NULL),('X12-309','X12',4,0,NULL),('X12-310','X12',4,0,NULL),('X12-311','X12',4,0,NULL),('X12-312','X12',4,0,NULL),('X12-313','X12',4,0,NULL),('X12-314','X12',4,0,NULL),('X12-315','X12',4,0,NULL),('X12-316','X12',4,0,NULL),('X12-317','X12',4,0,NULL),('X12-318','X12',4,0,NULL),('X12-319','X12',4,0,NULL),('X12-320','X12',4,0,NULL),('X12-401','X12',4,0,NULL),('X12-402','X12',4,0,NULL),('X12-403','X12',4,0,NULL),('X12-404','X12',4,0,NULL),('X12-405','X12',4,0,NULL),('X12-406','X12',4,0,NULL),('X12-407','X12',4,0,NULL),('X12-408','X12',4,0,NULL),('X12-409','X12',4,0,NULL),('X12-410','X12',4,0,NULL),('X12-411','X12',4,0,NULL),('X12-412','X12',4,0,NULL),('X12-413','X12',4,0,NULL),('X12-414','X12',4,0,NULL),('X12-415','X12',4,0,NULL),('X12-416','X12',4,0,NULL),('X12-417','X12',4,0,NULL),('X12-418','X12',4,0,NULL),('X12-419','X12',4,0,NULL),('X12-420','X12',4,0,NULL),('X12-501','X12',4,0,NULL),('X12-502','X12',4,0,NULL),('X12-503','X12',4,0,NULL),('X12-504','X12',4,0,NULL),('X12-505','X12',4,0,NULL),('X12-506','X12',4,0,NULL),('X12-507','X12',4,0,NULL),('X12-508','X12',4,0,NULL),('X12-509','X12',4,0,NULL),('X12-510','X12',4,0,NULL),('X12-511','X12',4,0,NULL),('X12-512','X12',4,0,NULL),('X12-513','X12',4,0,NULL),('X12-514','X12',4,0,NULL),('X12-515','X12',4,0,NULL),('X12-516','X12',4,0,NULL),('X12-517','X12',4,0,NULL),('X12-518','X12',4,0,NULL),('X12-519','X12',4,0,NULL),('X12-520','X12',4,0,NULL),('X12-601','X12',4,0,NULL),('X12-602','X12',4,0,NULL),('X12-603','X12',4,0,NULL),('X12-604','X12',4,0,NULL),('X12-605','X12',4,0,NULL),('X12-606','X12',4,0,NULL),('X12-607','X12',4,0,NULL),('X12-608','X12',4,0,NULL),('X12-609','X12',4,0,NULL),('X12-610','X12',4,0,NULL),('X12-611','X12',4,0,NULL),('X12-612','X12',4,0,NULL),('X12-613','X12',4,0,NULL),('X12-614','X12',4,0,NULL),('X12-615','X12',4,0,NULL),('X12-616','X12',4,0,NULL),('X12-617','X12',4,0,NULL),('X12-618','X12',4,0,NULL),('X12-619','X12',4,0,NULL),('X12-620','X12',4,0,NULL);
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dorsup`
--

DROP TABLE IF EXISTS `dorsup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dorsup` (
  `supno` varchar(11) NOT NULL,
  `supname` varchar(10) NOT NULL,
  `apartno` varchar(10) DEFAULT NULL,
  `phonenum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`supno`),
  KEY `apartno` (`apartno`),
  CONSTRAINT `dorsup_ibfk_1` FOREIGN KEY (`apartno`) REFERENCES `apartment` (`apartno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dorsup`
--

LOCK TABLES `dorsup` WRITE;
/*!40000 ALTER TABLE `dorsup` DISABLE KEYS */;
/*!40000 ALTER TABLE `dorsup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `dorno` varchar(10) NOT NULL,
  `goodno` varchar(10) NOT NULL,
  `gdname` varchar(10) NOT NULL,
  `gdcount` int(11) NOT NULL,
  PRIMARY KEY (`goodno`),
  KEY `dorno` (`dorno`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`dorno`) REFERENCES `dormitory` (`dorno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hygiene`
--

DROP TABLE IF EXISTS `hygiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hygiene` (
  `hygno` varchar(10) NOT NULL,
  `dorno` varchar(10) NOT NULL,
  `cktime` datetime NOT NULL,
  `hyscore` int(11) NOT NULL,
  `hytext` tinytext,
  PRIMARY KEY (`hygno`),
  KEY `dorno` (`dorno`),
  CONSTRAINT `hygiene_ibfk_1` FOREIGN KEY (`dorno`) REFERENCES `dormitory` (`dorno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hygiene`
--

LOCK TABLES `hygiene` WRITE;
/*!40000 ALTER TABLE `hygiene` DISABLE KEYS */;
/*!40000 ALTER TABLE `hygiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `living`
--

DROP TABLE IF EXISTS `living`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `living` (
  `livno` int(11) NOT NULL,
  `stuno` varchar(11) NOT NULL,
  `dorno` varchar(10) NOT NULL,
  `intime` datetime NOT NULL,
  `outime` datetime DEFAULT NULL,
  PRIMARY KEY (`livno`),
  KEY `stuno` (`stuno`),
  KEY `dorno` (`dorno`),
  CONSTRAINT `living_ibfk_1` FOREIGN KEY (`stuno`) REFERENCES `student` (`stuno`),
  CONSTRAINT `living_ibfk_2` FOREIGN KEY (`dorno`) REFERENCES `dormitory` (`dorno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `living`
--

LOCK TABLES `living` WRITE;
/*!40000 ALTER TABLE `living` DISABLE KEYS */;
/*!40000 ALTER TABLE `living` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairs`
--

DROP TABLE IF EXISTS `repairs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repairs` (
  `repno` varchar(10) NOT NULL,
  `dorno` varchar(10) NOT NULL,
  `gname` varchar(10) NOT NULL,
  `writime` datetime NOT NULL,
  `reptime` datetime DEFAULT NULL,
  `isrepair` tinyint(1) DEFAULT NULL,
  `reptext` tinytext,
  PRIMARY KEY (`repno`),
  KEY `dorno` (`dorno`),
  KEY `repairs_ibfk_2` (`gname`),
  CONSTRAINT `repairs_ibfk_1` FOREIGN KEY (`dorno`) REFERENCES `dormitory` (`dorno`),
  CONSTRAINT `repairs_ibfk_2` FOREIGN KEY (`gname`) REFERENCES `goods` (`goodno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairs`
--

LOCK TABLES `repairs` WRITE;
/*!40000 ALTER TABLE `repairs` DISABLE KEYS */;
/*!40000 ALTER TABLE `repairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stuno` varchar(11) NOT NULL,
  `stuname` varchar(20) NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `major` varchar(20) NOT NULL,
  `classname` varchar(20) NOT NULL,
  `phonenum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('20144221036','邹帆',1,'计算机科学与技术','计科1401','1234545'),('20144221037','严子超',1,'计算机科学与技术','计科1401','18154325052'),('20144221038','邹浩',1,'计算机科学与技术','计科1401','181123456'),('20144221039','熊潇',1,'计算机科学与技术','计科1401','19123123'),('博弈','123',1,'计算机科学与技术','计科1401','111111231233');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` varchar(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `permission` tinyint(4) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','21232F297A57A5A743894A0E4A801FC3',1),('dorsup','6B7E8E085E657E5D622E38C677C25E6B',2),('student','CD73502828457D15655BBD7A63FB0BC8',3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-26 23:44:26
