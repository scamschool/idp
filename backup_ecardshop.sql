-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (x86_64)
--
-- Host: localhost    Database: ecardshop
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ecardshop`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ecardshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ecardshop`;

--
-- Table structure for table `cards101`
--

DROP TABLE IF EXISTS `cards101`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards101` (
  `id` int NOT NULL,
  `cardset` varchar(5) DEFAULT NULL,
  `cardname` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `rarity` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `qty` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards101`
--

LOCK TABLES `cards101` WRITE;
/*!40000 ALTER TABLE `cards101` DISABLE KEYS */;
INSERT INTO `cards101` VALUES (1,'SWSH','Sinistea','Psychic','Common',1,43),(2,'SWSH','Polteageist','Psychic','Rare',3,33),(3,'RCL','Galarian Runerigus','Fighting','Rare',3,23),(4,'VIV','Dhelmise','Grass','Uncommon',2,50),(5,'VIV','Duskull','Psychic','Common',1,28),(6,'VIV','Dusclops','Psychic','Uncommon',2,71),(7,'VIV','Dusknoir','Psychic','Holo',4,14),(8,'VIV','Lycanroc','Fighting','Rare',3,29),(9,'EVS','Marshadow','Psychic','Holo',4,18),(10,'LOR','Phantump','Grass','Common',1,22),(11,'LOR','Trevenant','Grass','Holo',4,21),(12,'LOR','Litwick','Fire','Common',1,16),(13,'LOR','Lampent','Fire','Uncommon',2,52),(14,'LOR','Chandelure','Fire','Holo',4,11),(15,'LOR','Gastly','Psychic','Common',1,41),(16,'LOR','Haunter','Psychic','Uncommon',2,36),(17,'LOR','Gengar','Psychic','Holo',4,28),(18,'LOR','Banette','Psychic','Rare',3,30),(19,'LOR','Spectrier','Psychic','Holo',4,10),(20,'SIT','Zubat','Dark','Common',1,19),(21,'SV1','Houndoom','Fire','Holo',4,62),(22,'SV1','Shuppet','Psychic','Common',1,57),(23,'SV1','Drifloon','Psychic','Common',1,26),(24,'SV1','Drifblim','Psychic','Uncommon',2,15),(25,'SV1','Greavard','Psychic','Common',1,27),(26,'SV1','Houndstone','Psychic','Holo',4,24),(27,'PAL','Pikachu','Electric','Holo',4,43),(28,'PAL','Mismagius','Psychic','Uncommon',2,51),(29,'PAL','Mimikyu','Psychic','Holo',4,35),(30,'PAL','Murkrow','Dark','Common',1,33);
/*!40000 ALTER TABLE `cards101` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_records`
--

DROP TABLE IF EXISTS `order_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_records` (
  `id` int DEFAULT NULL,
  `qty_ordered` int DEFAULT NULL,
  `cust_name` varchar(30) DEFAULT NULL,
  `cust_email` varchar(30) DEFAULT NULL,
  `cust_phone` char(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_records`
--

LOCK TABLES `order_records` WRITE;
/*!40000 ALTER TABLE `order_records` DISABLE KEYS */;
INSERT INTO `order_records` VALUES (4,2,'Jonathan','jonathan@xyz.com','99998888'),(5,2,'Jonathan','jonathan@xyz.com','99998888'),(5,2,'Jonathan','jonathan@xyz.com','99998888'),(3,2,'Jonathan','jonathan@xyz.com','99998888'),(4,4,'Paul','paul@abc.com','99991111'),(28,2,'Jonathan','jonathan@xyz.com','99998888'),(27,2,'Jonathan','jonathan@xyz.com','99998888'),(27,2,'Jonathan','jonathan@xyz.com','99998888');
/*!40000 ALTER TABLE `order_records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-25 14:44:41
