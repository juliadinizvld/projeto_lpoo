-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicaveterinaria
-- ------------------------------------------------------
-- Server version	8.3.0

DROP DATABASE IF EXISTS `clinicaveterinaria`;

CREATE DATABASE `clinicaveterinaria`;

USE `clinicaveterinaria`;

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
-- Table structure for table `consultas`
--

DROP TABLE IF EXISTS `consultas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataConsulta` date NOT NULL,
  `nomeMedico` varchar(45) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `medicacao` varchar(255) NOT NULL,
  `id_pet` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pet` (`id_pet`),
  CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`id_pet`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas`
--

LOCK TABLES `consultas` WRITE;
/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
INSERT INTO `consultas` VALUES (16,'2024-08-28','Rafael Correia','aaeseasloakse´p\naseop´keas´p\nasepókeasóeas\naseokeaspókesa','Shampoo',5),(17,'2024-08-29','Rafael Correia','asdasdkmdaskp	asókasdads\nasdo,msaoed	das','Testosterona',5);
/*!40000 ALTER TABLE `consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `idade` int NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `tipoFuncionario` enum('ADMINISTRADOR','ATENDENTE') NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `cep` varchar(8) NOT NULL,
  `numeroCasa` int NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (5,'Rafael Correia',26,'819983213092','12442495423','ADMINISTRADOR','MASCULINO','52221060',60,'Sudeste','Cajueiro','Recife','PE');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicosveterinarios`
--

DROP TABLE IF EXISTS `medicosveterinarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicosveterinarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `idade` int NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `tipoFuncionario` enum('ADMINISTRADOR','ATENDENTE') NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `cep` varchar(8) NOT NULL,
  `numeroCasa` int NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `rmv` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicosveterinarios`
--

LOCK TABLES `medicosveterinarios` WRITE;
/*!40000 ALTER TABLE `medicosveterinarios` DISABLE KEYS */;
INSERT INTO `medicosveterinarios` VALUES (9,'Rafael Correia',32,'309128309128','12309312093','ADMINISTRADOR','MASCULINO','09321830',329,'Sudeste','Cajueiro','Recife','PE','CRM/PE91238-30');
/*!40000 ALTER TABLE `medicosveterinarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `especie` enum('CACHORRO','GATO') NOT NULL,
  `dataNascimento` date NOT NULL,
  `sexo` enum('MACHO','FÊMEA') NOT NULL,
  `raca` varchar(45) NOT NULL,
  `peso` double NOT NULL,
  `alergias` varchar(150) NOT NULL,
  `vacinas` varchar(150) NOT NULL,
  `id_tutor` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tutor` (`id_tutor`),
  CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`id_tutor`) REFERENCES `tutores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (5,'Belinha','CACHORRO','2015-05-30','FÊMEA','Vira-lata',50.42,'Poeira','Anti-rábica',2),(7,'Tunai','CACHORRO','1996-04-20','MACHO','Vira-lata',50,'Poeira','Raiva',2);
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` enum('CONSULTA','EXAME','CIRURGIA','VACINA','GERAL') DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `quantidade` int NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (12,'GERAL','Antipulgas',50,29.9),(13,'GERAL','Ração para Cães Adultos',200,120),(14,'GERAL','Coleira Anti-Pulgas',75,45.5),(15,'GERAL','Vermífugo',100,32),(16,'GERAL','Ração para Gatos',150,95),(17,'GERAL','Shampoo Antialérgico',40,22.3),(18,'GERAL','Brinquedo Bola',60,15.9);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutores`
--

DROP TABLE IF EXISTS `tutores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `email` varchar(100) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `numeroCasa` int NOT NULL,
  `dataNascimento` date NOT NULL,
  `cep` varchar(8) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutores`
--

LOCK TABLES `tutores` WRITE;
/*!40000 ALTER TABLE `tutores` DISABLE KEYS */;
INSERT INTO `tutores` VALUES (2,'Rafael Correia Costa','12442452321','MASCULINO','rafaelcosta@gmail.com','PE','Recife','081999328932',60,'1999-02-27','52221060','Cajueiro','Sudeste');
/*!40000 ALTER TABLE `tutores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-30  3:35:42
