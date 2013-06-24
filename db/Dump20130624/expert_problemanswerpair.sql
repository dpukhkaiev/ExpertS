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
-- Table structure for table `problemanswerpair`
--

DROP TABLE IF EXISTS `problemanswerpair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problemanswerpair` (
  `idProblemAnswerPair` int(11) NOT NULL AUTO_INCREMENT,
  `Answer_idAnswer` int(11) DEFAULT NULL,
  `Cause_idCause` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProblemAnswerPair`),
  KEY `FKD2D16B97A7BBA56F` (`Cause_idCause`),
  KEY `FKD2D16B9722CFFACA` (`Answer_idAnswer`),
  CONSTRAINT `FKD2D16B9722CFFACA` FOREIGN KEY (`Answer_idAnswer`) REFERENCES `answer` (`idAnswer`),
  CONSTRAINT `FKD2D16B97A7BBA56F` FOREIGN KEY (`Cause_idCause`) REFERENCES `cause` (`idCause`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problemanswerpair`
--

LOCK TABLES `problemanswerpair` WRITE;
/*!40000 ALTER TABLE `problemanswerpair` DISABLE KEYS */;
INSERT INTO `problemanswerpair` VALUES (113,26,19),(114,27,16),(115,28,18),(116,29,16),(117,30,16),(118,31,17),(119,27,17),(120,30,18),(121,29,17),(122,27,18),(123,31,20),(124,29,NULL),(125,27,NULL),(126,30,19),(127,28,19),(128,26,20),(129,30,NULL),(130,28,20),(131,26,NULL),(132,31,NULL),(133,28,NULL),(134,32,22),(135,33,NULL),(136,34,25),(137,35,24),(138,36,23),(139,37,25),(140,38,24),(141,39,22),(142,40,21),(143,41,23),(144,40,NULL),(145,32,26),(146,39,23),(147,41,24),(148,36,26),(149,39,25),(150,41,25),(151,35,27),(152,38,26),(153,41,27),(154,34,NULL),(155,37,NULL),(156,39,27),(157,32,NULL),(158,36,NULL),(159,38,NULL),(160,41,NULL),(161,35,NULL),(162,39,NULL),(163,42,28),(164,43,32),(165,44,28),(166,45,29),(167,46,30),(168,47,28),(169,42,29),(170,44,30),(171,47,29),(172,42,30),(173,45,31),(174,47,32),(175,42,31),(176,44,32),(177,46,31),(178,42,NULL),(179,45,33),(180,46,34),(181,43,33),(182,44,34),(183,47,33),(184,43,34),(185,45,35),(186,47,NULL),(187,43,35),(188,44,NULL),(189,46,35),(190,43,NULL),(191,45,NULL),(192,46,NULL);
/*!40000 ALTER TABLE `problemanswerpair` ENABLE KEYS */;
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
