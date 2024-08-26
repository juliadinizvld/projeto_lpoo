-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicaveterinaria
-- ------------------------------------------------------
-- Server version	8.3.0

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
INSERT INTO `funcionarios` VALUES (5,'Rafael Correia Costa',25,'819998398293','12338932893','ATENDENTE','MASCULINO','52221060',60,'Sudeste','Cajueiro','Recife','PE'),(6,'Rafaela Joana',32,'392183091280','03192832019','ADMINISTRADOR','MASCULINO','54140841',50,'RJAS','eAJI','Olinda','PE'),(7,'joao da costa',24,'239832938918','92318093128','ATENDENTE','MASCULINO','42412412',42,'SOIEJASIO1223','asekaesp','eoaskpeas','PE');
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
  `sexo` enum('MASCULINO','FEMININO') NOT NULL,
  `cep` varchar(8) NOT NULL,
  `numeroCasa` int NOT NULL,
  `rua` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `rmv` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicosveterinarios`
--

LOCK TABLES `medicosveterinarios` WRITE;
/*!40000 ALTER TABLE `medicosveterinarios` DISABLE KEYS */;
INSERT INTO `medicosveterinarios` VALUES (3,'aepeasok',13,'312098031298','90312809231','MASCULINO','31209831',59,'teste','teste','teste','PE','CRM/PE09123-83');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (2,'Bob Marley','CACHORRO','2023-12-20','MACHO','Golden Retriever',44.12,'Poeira','Anti-rábica',2),(4,'Ruby','GATO','2018-02-20','FÊMEA','Vira-lata',20,'Poeira','Anti-rábica',4),(5,'Belinha','CACHORRO','2015-05-30','FÊMEA','Vira-lata',50.42,'Poeira','Anti-rábica',2),(6,'Raiejpoaes','GATO','2024-12-23','FÊMEA','aspekaes',54.23,'aoiesjaes','easpj',5),(7,'Tunai','CACHORRO','1997-04-20','MACHO','Vira-lata',42.49,'Poeira','Raiva',2),(8,'AEOjs','CACHORRO','2024-10-29','MACHO','aepijsa',49.48,'AEJIa','aesdopija',5),(9,'Teste','CACHORRO','2023-12-29','MACHO','bebe',42.41,'aspij','asdepok',4),(10,'easeas','CACHORRO','2022-12-23','MACHO','aeseas',42.34,'teste','teste',4),(11,'asejek','CACHORRO','2024-02-27','MACHO','eoakoea',32.13,'eaoskjepase','easpk',6);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (3,'CONSULTA','Teste',5,332.23),(4,'CONSULTA','teaesjp',42,332.31),(5,'EXAME','teaesjp',42,332.31),(6,'CONSULTA','Roacutan',50,233.02),(7,'CONSULTA','das',42,323.12);
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
INSERT INTO `tutores` VALUES (2,'Rafael Correia Costa','23109310238','MASCULINO','rafaelcostateste@teste.teste','PE','Recife','081999328932',60,'1999-02-27','52221060','Cajuerio','Sudeste'),(4,'Joana D\'arc','31298321098','MASCULINO','aspjeasp@apeiosjpea.com','PE','Olinda','309218091328',50,'2003-03-27','93128392','teste','teste'),(5,'asoejheas','12938231908','MASCULINO','aseojheas@areoijase.com','PE','Recife','81999896516',950,'8241-03-23','52929289','eapsjkse','ASIJ'),(6,'aseasaes','12312312312','MASCULINO','iaejoiaes','PE','aesjoiaes','82980231980',50,'1999-02-27','32918093','eioasj','oasejea');
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

-- Dump completed on 2024-08-23  0:18:11
