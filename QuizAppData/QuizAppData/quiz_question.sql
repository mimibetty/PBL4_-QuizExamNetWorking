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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Opt1` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Opt2` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Opt3` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Opt4` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Answer` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Which of the below is valid way to instantiate an array in java?','int myArray [] = {1, 3, 5};','int myArray [] [] = {1,2,3,4};','int [] myArray = (5, 4, 3);','int [] myArray = {“1”, “2”, “3”};','int myArray [] = {1, 3, 5};'),(2,'Which of the below are reserved keyword in Java?','array','def','null','int','int'),(3,'What are the valid statements for static keyword in Java?','We can have static block in a class.','The static block in a class is executed every time an object of class is created.','We can have static method implementations in interface.','We can define static block inside a method.','We can have static method implementations in interface.'),(4,'Which of the following statements are true for inheritance in Java?','The “extend” keyword is used to extend a class in java.','You can extend multiple classes in java.','Private members of the superclass are accessible to the subclass.','We can’t extend Final classes in java.','We can’t extend Final classes in java.'),(5,'What is the size of byte variable?','8 bit','16 bit','32 bit','64 bit',' 8 bit'),(6,'What is the size of float variable?','8 bit','16 bit','32 bit','64 bit','32 bit'),(7,'What is the default value of byte variable?','0','0.0','null','not defined','0'),(8,'Which of the following is true about String?','String is mutable.','String is immutable.','String is a data type.','None of the above.','String is immutable.'),(9,'What is JIT compiler?','JIT improves the runtime performance of computer programs based on bytecode.','JIT is an application development framework.','JIT is an implementation of the Java Virtual Machine which executes Java programs.','None of the above.','JIT improves the runtime performance of computer programs based on bytecode.'),(10,'What is function overriding?','If a subclass uses a method that is already provided by its parent class, it is known as Method Overriding.','If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.','Both of the above.','None of the above.','If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding.');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
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
