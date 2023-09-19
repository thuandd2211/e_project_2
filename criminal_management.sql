-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: criminal_management
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `fullname` varchar(150) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'thuan','123456','Thuận Đặng','Nam',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime`
--

DROP TABLE IF EXISTS `crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crime_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime`
--

LOCK TABLES `crime` WRITE;
/*!40000 ALTER TABLE `crime` DISABLE KEYS */;
INSERT INTO `crime` VALUES (1,'Tội phá hoại tài sản công cộng'),(2,'Tội rửa tiền'),(3,'Tội cố ý gây thương tích hoặc gây tổn hại cho sức khỏe của người khác'),(4,'Tội lạm dụng tín nhiệm chiếm đoạt tài sản'),(5,'Tội trộm cắp tài sản'),(6,'Làm giả con dấu, tài liệu của cơ quan, tổ chức'),(7,'Tội tham nhũng'),(8,'Tội làm giả cổ phiếu chứng khoán'),(9,'Tội trốn thuế'),(10,'Tội đánh bạc'),(11,'Tội mại dâm'),(12,'Tội lừa đảo chiếm đoạt tài sản'),(13,'Tội bắt, giữ hoặc giam người trái pháp luật'),(14,'Tội buôn lậu'),(15,'Tội tàng trữ, mua, bán, sử dụng trái phép chất ma túy'),(16,'Tội tổ chức đánh bạc'),(17,'Tội môi giới mại dâm'),(18,'Tội bắt cóc, buôn bán phụ nữ, trẻ em'),(19,'Tội giết người'),(20,'Tội gây mất trật tự, trị an nơi công cộng');
/*!40000 ALTER TABLE `crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime_profile`
--

DROP TABLE IF EXISTS `crime_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crime_type_id` int(11) DEFAULT NULL,
  `number_of_criminal` int(11) DEFAULT '0',
  `actual_date` date DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`),
  KEY `crime_type_id_idx` (`crime_type_id`),
  CONSTRAINT `crime_type_id` FOREIGN KEY (`crime_type_id`) REFERENCES `crime_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime_profile`
--

LOCK TABLES `crime_profile` WRITE;
/*!40000 ALTER TABLE `crime_profile` DISABLE KEYS */;
INSERT INTO `crime_profile` VALUES (1,1,12,'2021-03-21',NULL),(3,3,6,'2021-03-21',NULL),(4,1,12,'2021-03-21',NULL),(5,1,12,'2021-03-21',NULL),(6,2,2,'2021-03-21',NULL),(7,3,6,'2021-03-21',NULL),(8,1,12,'2021-03-21',NULL),(9,1,12,'2021-03-21',NULL),(10,1,12,'2021-03-21',NULL),(11,1,12,'2021-03-21',NULL),(12,1,12,'2021-03-21',NULL),(13,3,6,'2021-03-21',NULL),(14,3,6,'2021-03-21',NULL),(15,3,6,'2021-03-21',NULL),(16,1,12,'2021-03-21',NULL),(17,2,2,'2021-03-21',NULL),(18,1,12,'2021-03-21',NULL),(19,3,6,'2021-03-21',NULL),(20,1,12,'2021-03-21',NULL),(22,2,0,'2023-09-21','nah'),(23,2,0,'2023-09-06','nah'),(24,3,0,'2023-09-01','hmm'),(25,3,0,'2023-09-09','test'),(26,3,0,'2023-08-30','5h'),(27,2,0,'2023-09-15',''),(28,3,3,'2023-09-13','10h');
/*!40000 ALTER TABLE `crime_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime_type`
--

DROP TABLE IF EXISTS `crime_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crime` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime_type`
--

LOCK TABLES `crime_type` WRITE;
/*!40000 ALTER TABLE `crime_type` DISABLE KEYS */;
INSERT INTO `crime_type` VALUES (1,'Hành Chính'),(2,'Dân Sự'),(3,'Hình Sự');
/*!40000 ALTER TABLE `crime_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `has_crime`
--

DROP TABLE IF EXISTS `has_crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `has_crime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crime_id` int(11) DEFAULT NULL,
  `prisoner_id` int(11) DEFAULT NULL,
  `crime_profile_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `has_crime_id_idx` (`crime_id`),
  KEY `has_crime_profile_id_idx` (`crime_profile_id`),
  KEY `has_prisoner_id_idx` (`prisoner_id`),
  CONSTRAINT `has_crime_id` FOREIGN KEY (`crime_id`) REFERENCES `crime` (`id`),
  CONSTRAINT `has_crime_profile_id` FOREIGN KEY (`crime_profile_id`) REFERENCES `crime_profile` (`id`),
  CONSTRAINT `has_prisoner_id` FOREIGN KEY (`prisoner_id`) REFERENCES `prisoner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `has_crime`
--

LOCK TABLES `has_crime` WRITE;
/*!40000 ALTER TABLE `has_crime` DISABLE KEYS */;
INSERT INTO `has_crime` VALUES (1,1,1,1),(3,3,3,3),(4,4,4,4),(5,5,5,5),(6,6,6,6),(7,7,7,7),(8,8,8,8),(9,9,9,9),(10,10,10,10),(11,11,11,11),(12,12,12,12),(13,13,13,13),(14,13,14,14),(15,15,15,15),(16,16,16,16),(17,17,17,17),(18,18,18,18),(19,19,19,19),(20,20,20,20),(43,1,1,28),(44,2,1,28),(45,1,2,28),(46,4,3,28);
/*!40000 ALTER TABLE `has_crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identify`
--

DROP TABLE IF EXISTS `identify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `identify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identify_number` varchar(12) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `native_place` text,
  `place_of_permanent` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identify`
--

LOCK TABLES `identify` WRITE;
/*!40000 ALTER TABLE `identify` DISABLE KEYS */;
INSERT INTO `identify` VALUES (1,'010000000000','Trần Khang','1995-02-04','TP Biên Hòa, tỉnh Đồng Nai','TP Biên Hòa, tỉnh Đồng Nai'),(2,'020000000000','Trần Văn Tuấn','2001-02-04','huyện Hòa Thành, tỉnh Tây Ninh','huyện Hòa Thành, tỉnh Tây Ninh'),(3,'030000000000','Trương Văn Khải','1984-05-07','huyện Quỳnh Lưu, tỉnh Nghệ An','huyện Quỳnh Lưu, tỉnh Nghệ An'),(4,'040000000000','Ngô Văn Tuấn','1983-02-03','Thành phố Hội An, tỉnh Quảng Nam','Thành phố Hội An, tỉnh Quảng Nam'),(5,'050000000000','Võ Thị Hồng Đào','2003-02-13','Thành phố Huế, tỉnh Thừa Thiên-Huế','Thành phố Huế, tỉnh Thừa Thiên-Huế'),(6,'060000000000','Châu Hồng Đạt','1993-03-05','huyện Ngọc Hiển, tỉnh Cà Mau','huyện Ngọc Hiển, tỉnh Cà Mau'),(7,'070000000000','Lê Văn Thiện','1999-12-02','Thành phố Việt Trì, tỉnh Phú Thọ','Thành phố Việt Trì, tỉnh Phú Thọ'),(8,'080000000000','Huỳnh Trương Phi','2004-04-03','TP Thái Bình, tỉnh Thái Bình','TP Thái Bình, tỉnh Thái Bình'),(9,'090000000000','Nguyễn Viết Sơn','1983-03-04','huyện Gia Lâm, TP. Hà Nội','huyện Gia Lâm, TP. Hà Nội'),(10,'100000000000','Mai Minh Bừng','2000-03-06','quận Ngô Quyền, TP. Hải Phòng','quận Ngô Quyền, TP. Hải Phòng'),(11,'110000000000','Phùng Mạnh Linh','1995-03-07','huyện Trần Đề, tỉnh Sóc Trăng','huyện Trần Đề, tỉnh Sóc Trăng'),(12,'120000000000','Lê Hằng Nga','1994-04-06','TP Cao Lãnh, tỉnh Đồng Tháp','TP Cao Lãnh, tỉnh Đồng Tháp'),(13,'130000000000','Nguyễn Duy Trọng','1997-12-07','Thị xã Vĩnh Châu, tỉnh Sóc Trăng','	Thị xã Vĩnh Châu, tỉnh Sóc Trăng'),(14,'140000000000','Đặng Văn Hải','1995-04-05','huyện Bù Gia mập, tỉnh Bình Phước','huyện Bù Gia mập, tỉnh Bình Phước'),(15,'150000000000','Trần Công Minh','1938-03-05','huyện Vạn Ninh, tỉnh Khánh Hoà','huyện Vạn Ninh, tỉnh Khánh Hoà'),(16,'160000000000','Võ Thị Hường','2004-12-08','huyện Bù Đăng, tỉnh Bình Phước','huyện Bù Đăng, tỉnh Bình Phước'),(17,'170000000000','Trương Tuấn Anh','1936-11-06','huyện Kế Sách, tỉnh Sóc Trăng','huyện Kế Sách, tỉnh Sóc Trăng'),(18,'180000000000','Nguyễn Minh Luân','1964-03-07','TP Cao Lãnh, tỉnh Đồng Tháp','TP Cao Lãnh, tỉnh Đồng Tháp'),(19,'190000000000','Tòng Văn Seo','1964-10-04','Tân Uyên, tỉnh Lai Châu','Tân Uyên, tỉnh Lai Châu'),(20,'200000000000','Nguyễn Vũ Linh','1987-04-06','huyện Cao Lãnh, tỉnh Đồng Tháp','huyện Cao Lãnh, tỉnh Đồng Tháp');
/*!40000 ALTER TABLE `identify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prisoner`
--

DROP TABLE IF EXISTS `prisoner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prisoner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roll_no` varchar(45) DEFAULT NULL,
  `fullname` varchar(150) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `identify_id` int(11) DEFAULT NULL,
  `execution_date` date DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `note` text,
  `status` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `identify_id_idx` (`identify_id`),
  KEY `room_id_idx` (`room_id`),
  CONSTRAINT `identify_id` FOREIGN KEY (`identify_id`) REFERENCES `identify` (`id`),
  CONSTRAINT `room_name_id` FOREIGN KEY (`room_id`) REFERENCES `room_name` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prisoner`
--

LOCK TABLES `prisoner` WRITE;
/*!40000 ALTER TABLE `prisoner` DISABLE KEYS */;
INSERT INTO `prisoner` VALUES (1,'P01','Trần Khang','Nam',170,60,1,'2021-03-21','2024-03-31',1,NULL,'Đang thụ án'),(2,'P02','Trần Văn Tuấn','Nam',174,62,2,'2021-03-21','2024-03-31',2,NULL,'Đang thụ án'),(3,'P03','Trương Văn Khải','Nam',173,67,3,'2021-03-21','2024-03-31',3,NULL,'Đang thụ án'),(4,'P04','Ngô Văn Tuấn','Nam',163,64,4,'2021-03-21','2024-03-31',1,NULL,'Đang thụ án'),(5,'P05','Võ Thị Hồng Đào','Nữ',154,46,5,'2021-03-21','2024-03-31',2,NULL,'Đang thụ án'),(6,'P06','Châu Hồng Đạt','Nam',173,63,6,'2021-03-21','2024-03-31',3,NULL,'Đang thụ án'),(7,'P07','Lê Văn Thiện','Nam',170,62,7,'2021-03-21','2024-03-31',4,NULL,'Đang thụ án'),(8,'P08','Huỳnh Trương Phi','Nam',163,69,8,'2021-03-21','2024-03-31',5,NULL,'Đang thụ án'),(9,'P09','Nguyễn Viết Sơn','Nam',173,59,9,'2021-03-21','2024-03-31',6,NULL,'Đang thụ án'),(10,'P10','Mai Minh Bừng','Nam',174,60,10,'2021-03-21','2024-03-31',4,NULL,'Đang thụ án'),(11,'P11','Phùng Mạnh Linh','Nam',169,68,11,'2021-03-21','2024-03-31',5,NULL,'Đang thụ án'),(12,'P12','Lê Hằng Nga','Nữ',150,47,12,'2021-03-21','2024-03-31',6,NULL,'Đang thụ án'),(13,'P13','Nguyễn Duy Trọng','Nam',163,59,13,'2021-03-21','2024-03-31',7,NULL,'Đang thụ án'),(14,'P14','Đặng Văn Hải','Nam',165,64,14,'2021-03-21','2024-03-31',8,NULL,'Đang thụ án'),(15,'P15','Trần Công Minh','Nam',174,73,15,'2021-03-21','2024-03-31',9,NULL,'Đang thụ án'),(16,'P16','Võ Thị Hường','Nữ',157,40,16,'2021-03-21','2024-03-31',6,NULL,'Đang thụ án'),(17,'P17','Trương Tuấn Anh','Nam',173,73,17,'2021-03-21','2024-03-31',7,NULL,'Đang thụ án'),(18,'P18','Nguyễn Minh Luân','Nam',169,62,18,'2021-03-21','2024-03-31',8,NULL,'Đang thụ án'),(19,'P19','Tòng Văn Seo','Nam',163,67,19,'2021-03-21','2024-03-31',9,NULL,'Đang thụ án'),(20,'P20','Nguyễn Vũ Linh','Nam',168,70,20,'2021-03-21','2024-03-31',10,NULL,'Đang thụ án');
/*!40000 ALTER TABLE `prisoner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_name`
--

DROP TABLE IF EXISTS `room_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_name`
--

LOCK TABLES `room_name` WRITE;
/*!40000 ALTER TABLE `room_name` DISABLE KEYS */;
INSERT INTO `room_name` VALUES (1,'001'),(2,'002'),(3,'003'),(4,'004'),(5,'005'),(6,'006'),(7,'007'),(8,'008'),(9,'009'),(10,'010'),(11,'011'),(12,'012');
/*!40000 ALTER TABLE `room_name` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-19 22:19:48
