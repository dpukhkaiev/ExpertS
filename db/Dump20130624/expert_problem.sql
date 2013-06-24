CREATE DATABASE  IF NOT EXISTS `expert` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `expert`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: expert
-- ------------------------------------------------------
-- Server version	5.5.21

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
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problem` (
  `idProblem` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `Subject_Area_idSubject_Area` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProblem`),
  KEY `FK50C55A7F270F482C` (`Subject_Area_idSubject_Area`),
  CONSTRAINT `FK50C55A7F270F482C` FOREIGN KEY (`Subject_Area_idSubject_Area`) REFERENCES `subject_area` (`idSubject_Area`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES (10,'Problem character','What is the problem’s character?',1),(11,'Cable','What is the state of network cable?',1),(12,'Access to WS','What is the state of web service?',1),(13,'Power','Are there any power alarms on BSC?',2),(14,'Transmission','You have done transmission check. Are links down?',2),(15,'OS','Can you see that OS is working in wrong and unusual way?',2),(16,'Switch','Are there any communication faults between MSC and BSC?',2),(17,'Hardware','Are there any faulty boards on BSC?',2),(20,'Оператор','Выберите оператора:',3),(21,'Тарифный план','Выберите тарифный план:',3),(22,'Номер','Выберите тип номера:',3);
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-25  0:51:48
