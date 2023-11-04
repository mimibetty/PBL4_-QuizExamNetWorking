-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `rollNo` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fatherName` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `motherName` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contactNo` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tenthUniversityName` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tenthPercentage` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tenthPassoutYear` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `twelveUniversityName` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `twelvePercentage` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `twelvePassoutYear` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `graduationUniversityName` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `graduationPercentage` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `graduationPassoutYear` varchar(5) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `marks` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('23','Nguyên','Phương ','Hùng','Male','1245336','anhnguyen2805@gmail.com','BK','100','2020','BK','100','2023','BK','100','2026','123 Nguyen Van Linh',0),('2324','Hùng','Phương ','Hoàng','Male','132436','nguyenanh@gmail.com','12','20','2023','12','2023','2026','123','123','2030','123 Nguyen Luong bang',1),('46','ANH NGUYEN','Hùng','Phương','Male','12354367','nguyenanhnguyen@gmail.com','BK','100','2020','BK','100','2023','BK','100','2026','123 Nguyen Van Linh',7),('1235','Toàn','Lý','Hải','Male','133456','toanvl98@gmail.com','Bách Khoa','100','2020','Bách KHoa','100','2023','fpt','100','2026','123 Nguyễn Hữu Thọ',5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-13 15:07:23
