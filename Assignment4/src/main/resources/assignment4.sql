-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: assignment4
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `author` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `image` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  `removed` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_book_user_idx` (`user_id`),
  CONSTRAINT `fk_book_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Nhà giả kim','Paulo Coelho','','2018-04-08 08:44:23','2018-04-09 19:09:20','coverBook.jpg',0,2,0),(2,'Em Sẽ Đến Cùng Cơn Mưa','Ichikawa Takujii','','2018-04-08 08:44:28','2018-04-10 15:23:55','coverBook.jpg',0,2,1),(3,'Conan','Tac gia','Truyen tranh','2018-02-27 17:00:30','2018-04-24 16:04:08','coverBook.jpg',1,1,0),(4,'Sông ngầm','Lôi Mễ','truyện','2018-02-27 17:00:30','2018-04-12 14:22:10','coverBook.jpg',1,1,0),(5,'Điều Kỳ Diệu Của Tiệm Tạp Hóa','tác giả','sách','2018-04-08 08:47:09','2018-04-24 15:50:13','coverBook.jpg',1,2,0),(6,'A Teapoon of Earth and Sea','aaaaa','','2018-04-08 08:51:48','2018-04-09 15:11:16','coverBook.jpg',1,2,1),(7,'Sự Im Lặng Của Bầy Cừu ','Thomas Harris','','2018-04-08 08:55:26','2018-04-23 21:32:47','coverBook.jpg',0,2,1),(8,'Lỗi Thuộc Về Những Vì Sao ','John Green ','Mặc dù phép màu y học đã giúp thu hẹp khối u và ban thêm vài năm sống cho Hazel nhưng cuộc đời cô bé đang ở vào giai đoạn cuối, từng chương kế tiếp được viết theo kết quả chẩn đoán. Nhưng khi có một nhân vật điển trai tên là Augustus Waters đột nhiên xuất hiện tại Hội Tương Trợ Bệnh Nhi Ung Thư, câu chuyện của Hazel sắp được viết lại hoàn toàn.\n\nSâu sắc, táo bạo, ngang tàng, và thô ráp, Khi lỗi thuộc về những vì sao là tác phẩm thương tâm và tham vọng nhất của John Green, tác giả của những giải thưởng, nhưng đồng thời lại khám phá một cách khéo léo nét hài hước, li kỳ, và bi thảm của việc sống và việc yêu.','2018-04-08 08:59:28','2018-04-23 21:09:58','coverBook.jpg',1,2,0),(9,'Điều Kỳ Diệu Của Tiệm Tạp Hóa','aaaa','','2018-04-08 10:21:52','2018-04-08 10:21:52','coverBook.jpg',1,2,0),(10,'The Spy','Paulo Coelho','','2018-04-08 11:57:58','2018-04-08 11:57:58','coverBook.jpg',1,1,0),(11,'Sau Lưng Một Vạt Nắng ','  Fuyu','','2018-04-08 13:37:39','2018-04-23 21:50:39','coverBook.jpg',0,1,0),(12,'Thần Điêu Đại Hiệp','Kim Dung','','2018-04-09 15:09:46','2018-04-09 15:09:46','coverBook.jpg',0,1,0),(13,'The Spy','Paulo Coelho','','2018-04-08 11:57:58','2018-04-08 11:57:58','coverBook.jpg',0,1,0),(14,'Kindaichi','Kindaichi','','2018-04-09 18:16:47','2018-04-09 19:10:24','coverBook.jpg',0,1,0),(15,'Truyện','Lôi Mễ','','2018-04-09 18:30:14','2018-04-09 18:30:14','coverBook.jpg',0,1,1),(16,'Khu vườn ngôn từ','Khu vườn ngôn từ','truyện nhật','2018-04-12 09:30:53','2018-04-12 09:32:09','coverBook.jpg',1,2,0),(17,'test','test','','2018-04-12 16:00:27','2018-04-12 16:00:26','coverBook.jpg',0,2,1),(18,'Kindaichi','Fumiya Satou','','2018-04-17 15:46:31','2018-04-23 19:32:38','coverBook.jpg',0,2,1),(22,'abc','abc','','2018-04-21 16:21:21','2018-04-21 16:21:21','coverBook.jpg',0,1,0),(23,'abc','abc','','2018-04-21 16:26:30','2018-04-21 16:26:30','coverBook.jpg',0,1,0),(24,'Bạch Dạ Hành','Higashino Keigo','Kosuke, chủ một tiệm cầm đồ bị sát hại tại một ngôi nhà chưa hoàn công, một triệu yên mang theo người cũng bị cướp mất.\n\nSau đó một tháng, nghi can Fumiyo được cho rằng có quan hệ tình ái với nạn nhân và đã sát hại ông để cướp một triệu yên, cũng chết tại nhà riêng vì ngộ độc khí ga. Vụ án mạng ông chủ tiệm cầm đồ rơi vào bế tắc và bị bỏ xó.\n\nNhưng với hai đứa trẻ mười một tuổi, con trai nạn nhân và con gái nghi can, vụ án mạng năm ấy chưa bao giờ kết thúc. Sinh tồn và trưởng thành dưới bóng đen cái chết của bố mẹ, cho đến cuối đời, Ryoji vẫn luôn khao khát được một lần đi dưới ánh mặt trời, còn Yukiho cứ ra sức vẫy vùng rồi mãi mãi chìm vào đêm trắng.','2018-04-23 20:43:32','2018-04-23 20:43:32','coverBook.jpg',1,4,0),(25,'Bí Mật Của Naoko ','Higashino Keigo','Cuộc sống của Hirasule trôi qua hết sức bình lặng, cho đến một ngày tai nạn giao thông khủng khiếp xảy ra và gã mất đi người vợ yêu quý nhất của mình, còn đứa con gái bé bỏng vẫn trong tình trạng hôn mê bất tỉnh. Nhưng chỉ sau một đêm, con gái gã tỉnh lại và một mực xưng mình là Naoko, vợ gã. Dường như linh hồn của Naoko đã nhập vào thể xác con gái, còn Monami thực sự đã chết. Rốt cuộc Hirasuke đã mất vợ hay con gái trong vụ tai nạn ấy?\n\nBí mật của Naoko đã giành Giải thưởng của Hiệp hội các Nhà văn viết truyện kỳ bí Nhật Bản vào năm 1999, và là một trong những tác phẩm quan trọng nhất trong sự nghiệp của Higashino Keigo, bậc thầy truyện trinh thám Nhật thế kỷ XX.','2018-04-23 20:46:03','2018-04-23 20:46:03','coverBook.jpg',1,4,0),(26,'5 Centimet Trên Giây ','Shinkai Makoto','5cm/s không chỉ là vận tốc của những cánh anh đào rơi ...','2018-04-23 21:49:01','2018-04-23 21:49:01','coverBook.jpg',0,1,0),(27,'kindaichi','tac gia','','2018-04-24 16:05:29','2018-04-24 16:05:29','coverBook.jpg',0,1,0),(28,'Khi Lỗi Thuộc Về Những Vì Sao','John Green','','2018-04-24 16:06:32','2018-04-24 16:06:32','coverBook.jpg',0,1,0),(29,'user1','user1','','2018-04-24 16:09:53','2018-04-24 16:09:53','coverBook.jpg',1,2,0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` text COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_1_idx` (`user_id`),
  KEY `fk_comment_2_idx` (`book_id`),
  CONSTRAINT `fk_comment_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Sách hay',1,2,'2018-04-08 08:44:23','2018-04-08 08:44:23'),(2,'Bìa đẹp',2,2,'2018-04-08 08:44:23','2018-04-08 08:44:23'),(3,'hi',2,2,'2018-04-15 10:03:18','2018-04-15 10:03:18'),(4,'Truyện hay',1,3,'2018-04-15 10:04:03','2018-04-15 10:04:03'),(5,'Test',2,3,'2018-04-15 10:08:17','2018-04-15 10:08:17'),(6,'hello',1,2,'2018-04-17 16:47:23','2018-04-17 16:47:23'),(7,'Sự Im Lặng của Bầy Cừu',4,7,'2018-04-23 21:33:44','2018-04-23 21:33:44'),(8,'hiiiiiiiiiiiiiii',2,3,'2018-04-24 15:47:45','2018-04-24 15:47:45');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3),(3),(3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_SUPER_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `role_id` int(11) NOT NULL,
  `enabled` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_1_idx` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',1,1),(2,'user1@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',2,1),(3,'nhu@gmail.com','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.',2,1),(4,'superadmin@gmail.com','$2a$10$PyCCx.00o2tUFriW0ZbWuuhgsGwlz3IG0P49NYTdbC3trO0J1OVA.',3,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24 17:46:28
