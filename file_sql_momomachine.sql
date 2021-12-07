-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: momo_machine
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,10000,1638867612977),(2,10000,1638875655106),(3,310000,1638875693657),(4,10000,1638876008985),(5,0,1638882675888),(6,0,1638882791639),(7,0,1638882853576),(8,10000,1638882892559),(9,20000,1638884031502),(10,10000,1638885247181),(11,10000,1638888034588),(12,20000,1638888102731),(13,100000,1638888127875),(14,200000,1638888205587),(15,200000,1638888229363),(16,20000,1638888318338),(17,20000,1638888687898),(18,50000,1638888779579),(19,100000,1638889615737),(20,200000,1638891829944),(21,100000,1638891972080),(22,200000,1638892006296),(23,200000,1638892127593),(24,100000,1638892182688),(25,200000,1638892263649),(26,10000,1638892434871),(27,100000,1638892477727),(28,100000,1638892499623),(29,200000,1638892943384),(30,210000,1638893226023),(31,250000,1638893246495),(32,200000,1638896407641),(33,300000,1638896537503),(34,200000,1638897366758),(35,200000,1638897472174),(36,200000,1638897592418),(37,200000,1638897791417),(38,200000,1638897901578),(39,200000,1638898102494),(40,200000,1638899421124),(41,200000,1638899570327),(42,400000,1638899688940),(43,400000,1638900081216),(44,400000,1638900144121),(45,400000,1638900210859),(46,200000,1638900282658),(47,400000,1638900538439);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detail_bill`
--

LOCK TABLES `detail_bill` WRITE;
/*!40000 ALTER TABLE `detail_bill` DISABLE KEYS */;
INSERT INTO `detail_bill` VALUES (1,1,1,0,1),(2,1,11,1,0),(3,1,12,1,0),(4,1,13,1,0),(5,1,14,1,0),(6,1,15,1,0),(7,1,16,1,0),(8,1,17,2,0),(9,1,18,5,0),(10,1,19,9,0),(11,1,20,20,0),(12,1,21,10,0),(13,1,22,9,0),(14,1,23,20,0),(15,1,24,4,0),(16,1,25,4,0),(17,1,26,1,0),(18,1,28,9,0),(19,1,29,6,2),(20,1,31,4,0),(21,2,31,3,1),(22,3,31,4,0),(23,1,32,3,1),(24,2,32,1,0),(25,3,32,3,0),(26,3,33,6,1),(27,1,34,4,0),(28,2,34,1,0),(29,1,35,4,0),(30,2,35,4,1),(31,3,35,4,0),(32,1,36,4,1),(33,2,36,4,0),(34,3,36,5,0),(35,1,37,9,0),(36,3,37,4,0),(37,2,37,3,0),(38,1,38,4,0),(39,2,38,3,0),(40,3,38,3,0),(41,1,39,3,0),(42,1,40,16,1),(43,1,41,13,2),(44,2,41,3,0),(45,3,41,2,0),(46,1,42,6,1),(47,1,43,3,1),(48,3,43,6,0),(49,1,44,6,2),(50,2,44,6,1),(51,3,44,9,0),(52,3,45,12,0),(53,1,45,9,1),(54,2,45,6,0),(55,3,46,3,0),(56,3,47,10,1),(57,1,47,4,0),(58,2,47,1,0);
/*!40000 ALTER TABLE `detail_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Coke',10000,'coke'),(2,'Pepsi',10000,'pepsi'),(3,'Soda',20000,'soda');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'2021-12-08',50,30000);
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-08  1:27:32