-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment2
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `StaffId` int(11) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL DEFAULT '',
  `BirthYear` int(11) unsigned NOT NULL,
  `Country` varchar(20) NOT NULL DEFAULT '',
  `Department` varchar(50) NOT NULL DEFAULT '',
  `Position` varchar(20) NOT NULL DEFAULT '',
  `WorkDays` int(11) unsigned NOT NULL DEFAULT '0',
  `Allowance` int(11) unsigned NOT NULL DEFAULT '0',
  `CoefficientSalary` float unsigned NOT NULL DEFAULT '0',
  `Career` varchar(10) NOT NULL DEFAULT 'NV',
  PRIMARY KEY (`StaffId`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`StaffId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (2,'Mai Khôi',1992,'Huế','Kế toán','Trưởng phòng',25,1000,1.2,'NV'),(3,'Trần Văn Huy',1993,'Đà Nẵng','Marketing','Trưởng phòng',26,1000,3,'NV'),(24,'Phan Mạnh Quỳnh',1990,'Hà Tĩnh','Kế toán','Nhân viên',25,400,3,'NV');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `TeacherId` int(11) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL DEFAULT '',
  `BirthYear` int(11) unsigned NOT NULL,
  `Country` varchar(20) NOT NULL DEFAULT '',
  `Faculty` varchar(50) NOT NULL DEFAULT '',
  `Degree` varchar(20) NOT NULL DEFAULT '',
  `ClassHours` int(11) unsigned NOT NULL DEFAULT '0',
  `Allowance` int(11) unsigned NOT NULL DEFAULT '0',
  `CoefficientSalary` float unsigned NOT NULL DEFAULT '0',
  `Career` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`TeacherId`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`TeacherId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (2,'Nguyen Van A ',1990,'Da nang','CNTT','Cử nhân',60,300,2.1,'GV'),(17,'Lê Na',1992,'Hà Giang','CNTT','Thạc sĩ',30,900,2.5,'');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL DEFAULT '',
  `Password` varchar(20) NOT NULL DEFAULT '',
  `Role` varchar(20) NOT NULL DEFAULT '',
  `Active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123','admin',1),(2,'user2','123','user',1),(3,'user3','123','user',1),(4,'user4','123','admin',1),(17,'user8','123','user',1),(24,'user5','123','user',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'assignment2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08 14:15:18
