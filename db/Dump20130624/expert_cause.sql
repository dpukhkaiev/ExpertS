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
-- Table structure for table `cause`
--

DROP TABLE IF EXISTS `cause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cause` (
  `idCause` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(255) NOT NULL,
  `Rule_idRule` int(11) DEFAULT NULL,
  `probability` double NOT NULL,
  PRIMARY KEY (`idCause`),
  KEY `FK3DE0449A746CBC8` (`Rule_idRule`),
  CONSTRAINT `FK3DE0449A746CBC8` FOREIGN KEY (`Rule_idRule`) REFERENCES `rule` (`idRule`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cause`
--

LOCK TABLES `cause` WRITE;
/*!40000 ALTER TABLE `cause` DISABLE KEYS */;
INSERT INTO `cause` VALUES (16,'Impossibility connecting to WS',NULL,0),(17,'Impossibility connecting to WS',NULL,0),(18,'Do not have rights fo this WS',NULL,0),(19,'Inappropriate work of network adapter’s software',NULL,0),(20,'Disconnected network cable',NULL,0),(21,'Check the state of power supply generator',NULL,0),(22,'Check backup files for system restore',NULL,0),(23,'Immediately check signalling links MSC - BBS',NULL,0),(24,'Board replacement is needed!',NULL,0),(25,'Check Planned Works.It is possible that someone is configuring BSC',NULL,0),(26,'Emergency sitaution! Contact vendor.',NULL,0),(27,'Can\'t determine problem',NULL,0),(28,'МТС безлимит',NULL,0),(29,'МТС стандарт',NULL,0),(30,'МТС VIP',NULL,0),(31,'МТС Золотой номер',NULL,0),(32,'Киевстар безлимит',NULL,0),(33,'Киевстар стандарт',NULL,0),(34,'Киевстар VIP',NULL,0),(35,'Киевстар Золотой номер',NULL,0);
/*!40000 ALTER TABLE `cause` ENABLE KEYS */;
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
