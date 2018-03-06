-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: assignment3
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
  `title` varchar(100) CHARACTER SET utf8 NOT NULL,
  `author` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `picture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (42,'Ánh Sáng thành phố','Lôi Mễ','2018-10-10 00:00:00','2018-02-26 21:51:44',3,'bookAva.jpg','trinh thám'),(43,'Độc giả thứ 7','Lôi Mễ','2018-10-10 00:00:00','2018-10-10 00:00:00',3,'bookAva.jpg',''),(45,'Phía Sau Nghi Can X','  Higashino ','2018-02-26 21:48:38','2018-02-27 16:42:34',7,'bookAva.jpg','Khi nhấn chuông cửa nhà nghi can chính của một vụ án mới, điều tra viên Kusanagi không biết rằng anh sắp phải đương đầu với một thiên tài ẩn dật. Kusanagi càng không thể ngờ rằng, chỉ một câu nói vô thưởng vô phạt của anh đã kéo người bạn thân, Manabu Yukawa, một phó giáo sư vật lý tài năng, vào vụ án. Và điều làm sững sờ nhất, đó là vụ án kia chẳng qua cũng chỉ như một bài toán cấp ba đơn giản, tuy nhiên ấn số X khi được phơi bày ra lại không đem đến hạnh phúc cho bất cứ ai…  Với một giọng văn tỉnh táo và dung dị, Higashino Keigo đã đem đến cho độc giả hơn cả một cuốn tiểu thuyết trinh thám. Mô tả tội ác không phải điều hấp dẫn nhất ở đây, mà còn là những giằng xé nội tâm thầm kín, những nhân vật bình dị, và sự quan tâm sâu sa tới con người. Tác phẩm đã đem lại cho Higashino Keigo Giải Naoki lần thứ 134, một  giải thưởng văn học lâu đời sánh ngang giải Akutagawa tại Nhật.'),(46,'Bạch Dạ Hành','Higashino Keigo','2018-02-26 21:49:53','2018-02-26 21:49:53',8,'bookAva.jpg','Kosuke, chủ một tiệm cầm đồ bị sát hại tại một ngôi nhà chưa hoàn công, một triệu yên mang theo người cũng bị cướp mất.  Sau đó một tháng, nghi can Fumiyo được cho rằng có quan hệ tình ái với nạn nhân và đã sát hại ông để cướp một triệu yên, cũng chết tại nhà riêng vì ngộ độc khí ga. Vụ án mạng ông chủ tiệm cầm đồ rơi vào bế tắc và bị bỏ xó.  Nhưng với hai đứa trẻ mười một tuổi, con trai nạn nhân và con gái nghi can, vụ án mạng năm ấy chưa bao giờ kết thúc. Sinh tồn và trưởng thành dưới bóng đen cái chết của bố mẹ, cho đến cuối đời, Ryoji vẫn luôn khao khát được một lần đi dưới ánh mặt trời, còn Yukiho cứ ra sức vẫy vùng rồi mãi mãi chìm vào đêm trắng.'),(47,'Mạnh Hơn Sợ Hãi ','Marc Levy','2018-02-26 21:50:30','2018-02-26 21:50:30',8,'bookAva.jpg','Bức thư tìm được trong xác chiếc máy bay vùi mình trong khe núi Trắng đã thổi bùng trong Suzie Baker hy vọng đòi lại công lý cho gia đình. Và trong khi mạng lưới mật vụ Mỹ rùng rùng chuyển động hòng cản bước cô, cô gặp Andrew Stilman. Anh là một tài năng thực sự trong lĩnh vực phóng sự điều tra, và anh trở thành người cộng sự để cùng cô lật lại vụ kỳ án. Hai con người khát khao công lý, cùng mang trong tim một tình yêu lớn hơn mọi hình dung, liệu có thể vượt qua những cạm bẫy và mưu mô trong hành trình phá án giờ đã trở nên không thể thiếu nếu muốn giữ được mạng sống của cô gái trẻ?'),(48,'Chân Trời Đảo Ngược ','  Marc Levy','2018-02-26 21:51:29','2018-02-26 21:51:29',3,'bookAva.jpg','Ý thức của chúng ta nằm ở đâu?  Liệu chúng ta có thể sao chép và lưu giữ ký ức bên ngoài thân xác con người không?  Liệu tình yêu có thể đảo ngược quy luật khắc nghiệt về sự hữu hạn của cuộc sống trong thời gian và không gian?  Xúc động, ly kỳ nhưng cũng đầy hài hước và lạc quan, Marc Levy đưa chúng ta đến với câu chuyện tình thách thức thời gian, không gian và bệnh tật, khiến ta trân trọng hơn những điều tưởng chừng nhỏ bé trong cuộc sống.  \"Một trong những tiểu thuyết xúc động nhất của Marc Levy. Người đẹp ngủ trong rừng phiên bản 2.0, với một trong những nhân vật nữ thành công nhất.\"'),(49,'Đề thi đẫm máu','Lôi Mễ','2018-02-26 21:52:18','2018-02-26 21:52:18',3,'bookAva.jpg','Truyện trinh thám kinh dị'),(50,'Nhà Giả Kim ','Paulo Coelho ','2018-02-26 21:53:54','2018-02-26 21:53:54',7,'bookAva.jpg','Tất cả những trải nghiệm trong chuyến phiêu du theo đuổi vận mệnh của mình đã giúp Santiago thấu hiểu được ý nghĩa sâu xa nhất của hạnh phúc, hòa hợp với vũ trụ và con người.'),(51,'The Spy ','Paulo Coelho','2018-02-26 21:54:27','2018-02-26 21:54:27',7,'bookAva.jpg','HER ONLY CRIME WAS TO BE AN INDEPENDENT WOMAN  When Mata Hari arrived in Paris she was penniless. Within months she was the most celebrated woman in the city.  As a dancer, she shocked and delighted audiences; as a courtesan, she bewitched the era’s richest and most powerful men.  But as paranoia consumed a country at war, Mata Hari’s lifestyle brought her under suspicion. In 1917, she was arrested in her hotel room on the Champs Elysees, and accused of espionage. Told in Mata Hari’s voice through her final letter, The Spy is the unforgettable story of a woman who dared to defy convention and who paid the ultimate price.'),(52,'5 Centimet Trên Giây ','Shinkai Makoto','2018-02-26 21:57:28','2018-02-26 21:57:28',7,'bookAva.jpg',''),(54,'conan tập 2','conan','2018-02-27 17:00:30','2018-02-27 17:01:19',9,'bookAva.jpg','');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `rolename` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`role_id`),
  CONSTRAINT `fk_username` FOREIGN KEY (`role_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (3,'admin_default'),(5,'admin'),(7,'user'),(8,'admin'),(9,'user'),(10,'user');
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
  `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'admin','123',1),(4,'nhu1','123',1),(5,'nhu123','123',1),(7,'ahihi','123',1),(8,'nhu','123',1),(9,'aha','123',1),(10,'totoro','123',1);
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

-- Dump completed on 2018-03-06 14:33:16
