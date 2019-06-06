-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: doctorchamberdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `advice`
--

DROP TABLE IF EXISTS `advice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `advice_eng` varchar(255) NOT NULL,
  `advice_local` varchar(255) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `short_code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK86dm6hjqs3nk6npqvh0pb470m` (`short_code`,`doctor_no`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advice`
--

LOCK TABLES `advice` WRITE;
/*!40000 ALTER TABLE `advice` DISABLE KEYS */;
INSERT INTO `advice` VALUES (1,1,NULL,'2019-05-24 10:47:14',NULL,NULL,'Drank Mote water','Drank Mote water',137,'Drank Mote water'),(2,1,NULL,'2019-05-24 11:55:43',NULL,NULL,'sdsd','sdsd',137,'sdsd'),(3,1,NULL,'2019-06-06 12:45:21',NULL,NULL,'Please come in follow up after 7 days','Please come in follow up after 7 days',137,'cc'),(4,1,NULL,'2019-06-06 12:45:44',NULL,NULL,'At least 1 hour of outdoor games','At least 1 hour of outdoor games',137,'oo'),(5,1,NULL,'2019-06-06 12:46:03',NULL,NULL,'Follow up: after 10 days','Follow up: after 10 days',137,'f10'),(6,1,NULL,'2019-06-06 12:46:23',NULL,NULL,'Use Hot Water','Use Hot Water',137,'q'),(7,1,NULL,'2019-06-06 12:46:53',NULL,NULL,'Follow up after 6 months','Follow up after 6 months',137,'fff'),(8,1,NULL,'2019-06-06 12:47:28',NULL,NULL,'To come with CT scan films','To come with CT scan films',137,'ct'),(9,1,NULL,'2019-06-06 12:47:51',NULL,NULL,'Avoid dairy products,','Avoid dairy products,',137,'aaa'),(10,1,NULL,'2019-06-06 12:48:33',NULL,NULL,'No smoking','No smoking',137,'ss');
/*!40000 ALTER TABLE `advice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `form_link` varchar(255) DEFAULT NULL,
  `is_doctor` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `report_link` bigint(20) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  `user_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,1,'imran','2019-02-05 14:38:02','imran','2019-02-05 14:38:02','MD IMRAN HOSSAIN','homeTwo','','123',2,'imran',137),(2,1,'imran','2019-02-05 14:38:02','imran','2019-02-05 14:38:02','MD TAWFIQUE RAHAMAN','homeTwo','','123',2,'tawfique',101);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_complete`
--

DROP TABLE IF EXISTS `auto_complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto_complete` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `auto_com_type` int(11) NOT NULL,
  `auto_com_val_eng` varchar(255) DEFAULT NULL,
  `auto_com_val_local` varchar(255) DEFAULT NULL,
  `auto_key` varchar(255) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_complete`
--

LOCK TABLES `auto_complete` WRITE;
/*!40000 ALTER TABLE `auto_complete` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_complete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `form` varchar(255) DEFAULT NULL,
  `map_no` bigint(20) DEFAULT NULL,
  `preferred` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `strength` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `generic_no` bigint(20) NOT NULL,
  `manufacturer_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrqr5ywuo9w9osomx29db854ds` (`generic_no`),
  KEY `FKrlhlqjf8xj6sl74587wypb4mb` (`manufacturer_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chief_complain`
--

DROP TABLE IF EXISTS `chief_complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chief_complain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chief_complain`
--

LOCK TABLES `chief_complain` WRITE;
/*!40000 ALTER TABLE `chief_complain` DISABLE KEYS */;
INSERT INTO `chief_complain` VALUES (1,1,NULL,'2019-06-04 10:05:54',NULL,NULL,'Fever for 7 days',137),(2,1,NULL,'2019-06-04 10:06:05',NULL,NULL,'Cough for 3 days',137),(3,1,NULL,'2019-06-06 12:05:56',NULL,NULL,'Headache',137),(4,1,NULL,'2019-06-06 12:06:11',NULL,NULL,'Blurring of vision',137),(5,1,NULL,'2019-06-06 12:06:29',NULL,NULL,'H/O- Near Syncope',137),(6,1,NULL,'2019-06-06 12:06:57',NULL,NULL,'Pain in left breast',137),(7,1,NULL,'2019-06-06 12:07:11',NULL,NULL,'Neck node on left side of neck',137);
/*!40000 ALTER TABLE `chief_complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinical_history`
--

DROP TABLE IF EXISTS `clinical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinical_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinical_history`
--

LOCK TABLES `clinical_history` WRITE;
/*!40000 ALTER TABLE `clinical_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinical_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `appointment_dt` datetime DEFAULT NULL,
  `appointment_no` bigint(20) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `consult_in` bigint(20) DEFAULT NULL,
  `consult_out` bigint(20) DEFAULT NULL,
  `consultation_dt` datetime DEFAULT NULL,
  `consultation_dt_str` varchar(255) DEFAULT NULL,
  `consultation_id` varchar(255) DEFAULT NULL,
  `consultation_no` bigint(20) DEFAULT NULL,
  `consultation_time` datetime DEFAULT NULL,
  `consultation_type` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hospital_no` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  `shiftdtl_no` bigint(20) DEFAULT NULL,
  `slot_serial` bigint(20) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `total_record` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultation`
--

LOCK TABLES `consultation` WRITE;
/*!40000 ALTER TABLE `consultation` DISABLE KEYS */;
INSERT INTO `consultation` VALUES (1,0,'imran','2018-12-08 14:38:02','imrna','2018-12-08 14:38:02','23','2019-05-24 14:38:02',21212,'O+',1,0,'2019-05-24 14:38:02','2019-05-24 14:38:02','212121212',2121212,'2019-05-24 14:38:02','1','1990-12-08 14:38:02','Dr. Muhammad Tawfique',137,'2019-05-24 14:38:02','Male','HP1559544039729','Marid','Md ROHIM MEYA','0191876567',1,1,'2019-05-24 14:38:02',10),(2,1,'imran','2018-12-08 14:38:02','imrna','2018-12-08 14:38:02','23','2019-05-24 14:38:02',21212,'O+',1,0,'2019-05-24 14:38:02','2019-05-24 14:38:02','121212',21212121212,'2019-05-24 14:38:02','1','1990-12-08 14:38:02','Dr. Muhammad Tawfique',137,'2019-05-24 14:38:02','Male','HP1559544039728','Marid','MR KHAN','0191876567',1,1,'2019-05-24 14:38:02',10),(3,1,NULL,'2019-06-03 12:40:40',NULL,NULL,'55','2019-06-03 12:40:40',NULL,'O+',1,0,'2019-06-03 12:40:40',NULL,'CH1559544039727',1559544039727,'2019-06-03 12:40:40','1',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559544039727','Married','MD MOZAMMEL HOSSAIN','01916894486',1,1,'2019-05-24 14:38:02',10),(4,0,NULL,'2019-06-03 13:02:19',NULL,NULL,'28','2019-06-03 13:02:20',NULL,NULL,1,0,'2019-06-03 13:02:20',NULL,'CH1559545339511',1559545339511,'2019-06-03 13:02:20','1',NULL,'Dr. Muhammad Tawfique',137,NULL,'FEMALE','HP1559545339511','Married','MS RAZUNA KHANOM','0191875442',1,1,'2019-05-24 14:38:02',10),(5,1,NULL,'2019-06-04 10:43:39',NULL,NULL,'20','2019-06-04 10:43:39',NULL,NULL,1,0,'2019-06-04 10:43:39',NULL,'CH1559623419278',1559623419278,'2019-06-04 10:43:39','1',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559623419278','Married','MARUF ABDULLAH RION','0172323232',1,1,'2019-05-24 14:38:02',10),(6,0,NULL,'2019-06-04 10:46:05',NULL,NULL,'20','2019-06-04 10:46:05',NULL,NULL,1,0,'2019-06-04 10:46:05',NULL,'CH1559623565060',1559623565060,'2019-06-04 10:46:05','1',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559623565060','Single','FAHIM FOSIAL','0183132323',1,1,'2019-05-24 14:38:02',10),(7,1,NULL,'2019-06-04 10:59:00',NULL,NULL,'22','2019-06-04 10:59:00',NULL,NULL,1,0,'2019-06-04 10:59:00',NULL,'CH1559624339973',1559624339973,'2019-06-04 10:59:00','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559624339973','Single','RAYHAN MEYA','1063232323',1,1,'2019-05-24 14:38:02',10),(8,1,NULL,'2019-06-06 08:44:09',NULL,NULL,'45','2019-06-06 08:44:09',NULL,NULL,1,0,'2019-06-06 08:44:09',NULL,'CH1559789048732',1559789048732,'2019-06-06 08:44:09','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'FEMALE','HP1559789048732','Married','Ms Asia Begum','01786547689',NULL,NULL,NULL,NULL),(9,1,NULL,'2019-06-06 08:44:52',NULL,NULL,'35','2019-06-06 08:44:52',NULL,NULL,1,0,'2019-06-06 08:44:52',NULL,'CH1559789091747',1559789091747,'2019-06-06 08:44:52','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559789091747','Married','Md Mokter hossain','01786800987',NULL,NULL,NULL,NULL),(10,1,NULL,'2019-06-06 08:45:48',NULL,NULL,'25','2019-06-06 08:45:48',NULL,NULL,1,0,'2019-06-06 08:45:48',NULL,'CH1559789147831',1559789147831,'2019-06-06 08:45:48','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'FEMALE','HP1559789147831','Married','Sadia Akter','01678987543',NULL,NULL,NULL,NULL),(11,1,NULL,'2019-06-06 08:55:17',NULL,NULL,'40','2019-06-06 08:55:17',NULL,NULL,1,0,'2019-06-06 08:55:17',NULL,'CH1559789716612',1559789716612,'2019-06-06 08:55:17','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559789716612','Married','Mahubbur Rahaman','018976544332',NULL,NULL,NULL,NULL),(12,1,NULL,'2019-06-06 08:56:06',NULL,NULL,'20','2019-06-06 08:56:06',NULL,NULL,1,0,'2019-06-06 08:56:06',NULL,'CH1559789766159',1559789766159,'2019-06-06 08:56:06','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559789766159','Married','Zahidul Islam','0191876545',NULL,NULL,NULL,NULL),(13,1,NULL,'2019-06-06 08:56:53',NULL,NULL,'26','2019-06-06 08:56:53',NULL,NULL,1,0,'2019-06-06 08:56:53',NULL,'CH1559789813484',1559789813484,'2019-06-06 08:56:53','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'FEMALE','HP1559789813484','Married','Nuras Jahan','0178987654',NULL,NULL,NULL,NULL),(14,1,NULL,'2019-06-06 08:57:26',NULL,NULL,'29','2019-06-06 08:57:26',NULL,NULL,1,0,'2019-06-06 08:57:26',NULL,'CH1559789845848',1559789845848,'2019-06-06 08:57:26','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559789845848','Married','Rakib Meya','0191876765',NULL,NULL,NULL,NULL),(15,1,NULL,'2019-06-06 08:57:50',NULL,NULL,'28','2019-06-06 08:57:50',NULL,NULL,1,0,'2019-06-06 08:57:50',NULL,'CH1559789869974',1559789869974,'2019-06-06 08:57:50','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559789869974','Married','Fahim Fosial','0191876765',NULL,NULL,NULL,NULL),(16,1,NULL,'2019-06-06 08:58:35',NULL,NULL,'25','2019-06-06 08:58:35',NULL,NULL,1,0,'2019-06-06 08:58:35',NULL,'CH1559789914944',1559789914944,'2019-06-06 08:58:35','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'FEMALE','HP1559789914944','Married','Rima Akter','0191876765',NULL,NULL,NULL,NULL),(17,1,NULL,'2019-06-06 16:20:08',NULL,NULL,'45','2019-06-06 16:20:08',NULL,NULL,1,0,'2019-06-06 16:20:08',NULL,'CH1559816408222',1559816408222,'2019-06-06 16:20:08','2',NULL,'Dr. Muhammad Tawfique',137,NULL,'MALE','HP1559816408222',NULL,'Mr Lutfor Rahaman','01798643567',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `consultation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_user`
--

DROP TABLE IF EXISTS `core_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_user` (
  `id` bigint(20) NOT NULL,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `account_expire_date` datetime DEFAULT NULL,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `agent_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `password_expired` bit(1) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_user`
--

LOCK TABLES `core_user` WRITE;
/*!40000 ALTER TABLE `core_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `core_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnosis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `doctor_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosis`
--

LOCK TABLES `diagnosis` WRITE;
/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
INSERT INTO `diagnosis` VALUES (1,1,NULL,'2019-05-24 10:51:10',NULL,NULL,'CBC',137),(2,1,NULL,'2019-05-24 11:49:25',NULL,NULL,'High blood sugar',137),(3,1,NULL,'2019-05-24 11:54:13',NULL,NULL,'Bronchopneumonia',137),(4,1,NULL,'2019-05-24 11:54:15',NULL,NULL,'Viral Syndrome',137),(5,1,NULL,'2019-05-24 11:55:39',NULL,NULL,'Rhinitis with wheeze',137),(6,1,NULL,'2019-05-24 12:05:17',NULL,NULL,'VSD',137),(7,1,NULL,'2019-05-24 12:05:17',NULL,NULL,'HTN',137),(8,1,NULL,'2019-05-24 10:51:10',NULL,NULL,'Post CABG x 4 (on 15/08/17)',137),(9,1,NULL,'2019-05-24 11:49:25',NULL,NULL,'Hypothyroidism',137),(10,1,NULL,'2019-05-24 11:54:13',NULL,NULL,'Dydlepidemia',137),(11,1,NULL,'2019-05-24 11:54:15',NULL,NULL,'HBs Ag (+ve)',137),(12,1,NULL,'2019-05-24 11:55:39',NULL,NULL,'Sclerosing Lymphanitis',137),(13,1,NULL,'2019-05-24 12:05:17',NULL,NULL,'Iron Deficiency Anemia',137),(14,1,NULL,'2019-05-24 12:05:17',NULL,NULL,'Hb E Beta Thalassemia',137);
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_wise_pscrip`
--

DROP TABLE IF EXISTS `doctor_wise_pscrip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor_wise_pscrip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_id` varchar(255) NOT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `pres_form_id` bigint(20) DEFAULT NULL,
  `pres_peport_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKliilxoyh6rsjc7cpf94lqn1md` (`pres_form_id`),
  KEY `FKtgerl1ncraaodqx1bme7xyr8s` (`pres_peport_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_wise_pscrip`
--

LOCK TABLES `doctor_wise_pscrip` WRITE;
/*!40000 ALTER TABLE `doctor_wise_pscrip` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_wise_pscrip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `finalization`
--

DROP TABLE IF EXISTS `finalization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `finalization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `finalize_name` varchar(255) NOT NULL,
  `finalize_place_holder` varchar(255) DEFAULT NULL,
  `finalize_result` varchar(255) DEFAULT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `serial` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK31sywmjwl0toauvbc8ogrmduy` (`doctor_no`,`finalize_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `finalization`
--

LOCK TABLES `finalization` WRITE;
/*!40000 ALTER TABLE `finalization` DISABLE KEYS */;
/*!40000 ALTER TABLE `finalization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generic`
--

DROP TABLE IF EXISTS `generic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `age_message` varchar(255) DEFAULT NULL,
  `contraindication` varchar(255) DEFAULT NULL,
  `default_dose_bn` varchar(255) DEFAULT NULL,
  `default_dose_en` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `doses` varchar(255) DEFAULT NULL,
  `doses_info` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `indications` varchar(255) DEFAULT NULL,
  `lactation_info` varchar(255) DEFAULT NULL,
  `liver_disease_info` varchar(255) DEFAULT NULL,
  `max_age` bigint(20) DEFAULT NULL,
  `min_age` bigint(20) DEFAULT NULL,
  `other_precautions` varchar(255) DEFAULT NULL,
  `pregnancy_info` varchar(255) DEFAULT NULL,
  `renal_disease_info` varchar(255) DEFAULT NULL,
  `side_efects` varchar(255) DEFAULT NULL,
  `group_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2lbmmppfbxhnurui1v1f9bxxs` (`group_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generic`
--

LOCK TABLES `generic` WRITE;
/*!40000 ALTER TABLE `generic` DISABLE KEYS */;
/*!40000 ALTER TABLE `generic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_table`
--

DROP TABLE IF EXISTS `group_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_table`
--

LOCK TABLES `group_table` WRITE;
/*!40000 ALTER TABLE `group_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `history_name` varchar(255) NOT NULL,
  `history_place_holder` varchar(255) DEFAULT NULL,
  `history_serial` bigint(20) DEFAULT NULL,
  `input_type` int(11) NOT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `is_show_header` bit(1) DEFAULT NULL,
  `history_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKet4s1gx12h2k86nge2jp3hbsw` (`doctor_no`,`history_name`),
  KEY `FK68s2a4gsl643jxh401m1m80nh` (`history_group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,1,NULL,'2019-05-24 10:34:16',NULL,NULL,137,'Past Illness',NULL,1,2,'','',1),(2,1,NULL,'2019-05-24 10:50:30',NULL,NULL,137,'Present Illness',NULL,2,2,'','',1);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_group`
--

DROP TABLE IF EXISTS `history_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `is_show_header` bit(1) DEFAULT NULL,
  `serial` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_group`
--

LOCK TABLES `history_group` WRITE;
/*!40000 ALTER TABLE `history_group` DISABLE KEYS */;
INSERT INTO `history_group` VALUES (1,1,NULL,'2019-05-24 10:33:45',NULL,NULL,137,'Illness History','','',1);
/*!40000 ALTER TABLE `history_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_prescription_data`
--

DROP TABLE IF EXISTS `history_prescription_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_prescription_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `exam_data_type` int(11) DEFAULT NULL,
  `history_name` varchar(255) NOT NULL,
  `history_place_holder` varchar(255) DEFAULT NULL,
  `history_result` varchar(4000) DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `history_id` bigint(20) DEFAULT NULL,
  `history_group_id` bigint(20) NOT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ojrgb9kod1h1kvfk192pu5k` (`history_id`),
  KEY `FK7ut36m91f2yfq1k1q4efgc4e4` (`history_group_id`),
  KEY `FK63aibr4lsfvr4p4frsa1gjp44` (`prescription_no`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_prescription_data`
--

LOCK TABLES `history_prescription_data` WRITE;
/*!40000 ALTER TABLE `history_prescription_data` DISABLE KEYS */;
INSERT INTO `history_prescription_data` VALUES (1,1,NULL,'2019-06-04 10:43:07',NULL,NULL,0,'Past Illness',NULL,'fdsfsdf',1,0,1,1,1),(2,1,NULL,'2019-05-24 11:54:56',NULL,NULL,0,'Past Illness',NULL,'sdddddddddddddd',1,0,1,1,2),(3,1,NULL,'2019-05-24 11:54:56',NULL,NULL,0,'Present Illness',NULL,'sdddddddddddddddddd',2,0,2,1,2),(4,1,NULL,'2019-05-24 11:55:45',NULL,NULL,0,'Past Illness',NULL,'sdsd',1,0,1,1,2),(5,1,NULL,'2019-05-24 11:55:45',NULL,NULL,0,'Present Illness',NULL,'sdsdsd',2,0,2,1,2),(6,1,NULL,'2019-05-24 11:56:01',NULL,NULL,0,'Past Illness',NULL,'sdsd',1,0,1,1,2),(7,1,NULL,'2019-05-24 11:56:01',NULL,NULL,0,'Present Illness',NULL,'sdsdsd',2,0,2,1,2),(8,1,NULL,'2019-06-04 10:57:11',NULL,NULL,0,'Past Illness',NULL,'sdsd',1,0,1,1,2),(9,1,NULL,'2019-06-04 10:57:11',NULL,NULL,0,'Present Illness',NULL,'sdsdsd',2,0,2,1,2),(10,1,NULL,'2019-06-03 12:41:51',NULL,NULL,0,'Past Illness',NULL,'ERERE',1,0,1,1,3),(11,1,NULL,'2019-06-03 12:41:51',NULL,NULL,0,'Present Illness',NULL,'EFEER',2,0,2,1,3),(12,1,NULL,'2019-06-06 13:05:37',NULL,NULL,0,'Past Illness',NULL,'sfsdfdssdf',1,0,1,1,3),(13,1,NULL,'2019-06-06 13:05:37',NULL,NULL,0,'Present Illness',NULL,'wrwerwerwer',2,0,2,1,3);
/*!40000 ALTER TABLE `history_prescription_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investigation`
--

DROP TABLE IF EXISTS `investigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `investigation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `custome_name` varchar(255) NOT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `integrate_id` varchar(255) DEFAULT NULL,
  `integrate_no` bigint(20) DEFAULT NULL,
  `map_code` varchar(255) DEFAULT NULL,
  `integrate_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigation`
--

LOCK TABLES `investigation` WRITE;
/*!40000 ALTER TABLE `investigation` DISABLE KEYS */;
/*!40000 ALTER TABLE `investigation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_certificate_template`
--

DROP TABLE IF EXISTS `medical_certificate_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_certificate_template` (
  `id` bigint(20) NOT NULL,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `certificate_text` varchar(4000) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `is_default` bit(1) DEFAULT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_certificate_template`
--

LOCK TABLES `medical_certificate_template` WRITE;
/*!40000 ALTER TABLE `medical_certificate_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_certificate_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `description` varchar(4000) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pat_medical_certificate`
--

DROP TABLE IF EXISTS `pat_medical_certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pat_medical_certificate` (
  `id` bigint(20) NOT NULL,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `certificate_text` varchar(4000) NOT NULL,
  `consultation_no` varchar(255) DEFAULT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `hospital_no` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pat_medical_certificate`
--

LOCK TABLES `pat_medical_certificate` WRITE;
/*!40000 ALTER TABLE `pat_medical_certificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `pat_medical_certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_exam_group`
--

DROP TABLE IF EXISTS `physical_exam_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_exam_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `group_name` varchar(255) NOT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `is_show_header` bit(1) DEFAULT NULL,
  `serial` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_exam_group`
--

LOCK TABLES `physical_exam_group` WRITE;
/*!40000 ALTER TABLE `physical_exam_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_exam_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_examination`
--

DROP TABLE IF EXISTS `physical_examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_examination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `exam_name` varchar(255) NOT NULL,
  `exam_serial` bigint(20) DEFAULT NULL,
  `exam_unit` varchar(255) DEFAULT NULL,
  `input_type` int(11) NOT NULL,
  `is_enable` bit(1) DEFAULT NULL,
  `is_show_header` bit(1) DEFAULT NULL,
  `exam_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKada91yltc097voajepdiqn0ml` (`doctor_no`,`exam_name`),
  KEY `FKo0qym5o4h7ijfui0fnq7uvudm` (`exam_group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_examination`
--

LOCK TABLES `physical_examination` WRITE;
/*!40000 ALTER TABLE `physical_examination` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pres_form`
--

DROP TABLE IF EXISTS `pres_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pres_form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `form_link` varchar(255) NOT NULL,
  `form_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pres_form`
--

LOCK TABLES `pres_form` WRITE;
/*!40000 ALTER TABLE `pres_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `pres_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pres_report`
--

DROP TABLE IF EXISTS `pres_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pres_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `report_link` varchar(255) NOT NULL,
  `report_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pres_report`
--

LOCK TABLES `pres_report` WRITE;
/*!40000 ALTER TABLE `pres_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `pres_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `appointment_no` bigint(20) DEFAULT NULL,
  `consultant_id` varchar(255) DEFAULT NULL,
  `consultant_no` bigint(20) DEFAULT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `hospital_id` varchar(255) DEFAULT NULL,
  `is_patient_in` int(11) DEFAULT '0',
  `is_patient_out` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,1,'MD IMRAN HOSSAIN','2019-05-24 10:58:07','MD IMRAN HOSSAIN','2019-06-04 10:43:07',21212,'212121212',2121212,137,'32323',0,1),(2,1,'MD IMRAN HOSSAIN','2019-05-24 11:54:56','MD IMRAN HOSSAIN','2019-06-04 10:57:12',21212,'121212',21212121212,137,'323231',0,0),(3,1,'MD IMRAN HOSSAIN','2019-06-03 12:41:51','MD IMRAN HOSSAIN','2019-06-06 13:05:38',NULL,'CH1559544039727',1559544039727,137,'HP1559544039727',0,0),(4,1,'MD IMRAN HOSSAIN','2019-06-04 10:40:20','MD IMRAN HOSSAIN','2019-06-04 10:40:46',NULL,'CH1559545339511',1559545339511,137,'HP1559545339511',0,1),(5,1,'MD IMRAN HOSSAIN','2019-06-04 10:46:30','MD IMRAN HOSSAIN','2019-06-04 10:47:01',NULL,'CH1559623565060',1559623565060,137,'HP1559623565060',0,1);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_all_notes`
--

DROP TABLE IF EXISTS `prescription_all_notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_all_notes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `is_bold` int(11) NOT NULL,
  `notes_data` varchar(4000) NOT NULL,
  `notes_data_head` varchar(255) DEFAULT NULL,
  `notes_data_type` int(11) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35pwexkbhf1va6alb3mt4te6p` (`prescription_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_all_notes`
--

LOCK TABLES `prescription_all_notes` WRITE;
/*!40000 ALTER TABLE `prescription_all_notes` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescription_all_notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_details`
--

DROP TABLE IF EXISTS `prescription_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `head_no` bigint(20) DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `prescrition_data` varchar(4000) NOT NULL,
  `prescrition_data_type` int(11) DEFAULT NULL,
  `reference_id` bigint(20) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKijfhd8t9nkx7qtxjibk36kdyk` (`prescription_no`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_details`
--

LOCK TABLES `prescription_details` WRITE;
/*!40000 ALTER TABLE `prescription_details` DISABLE KEYS */;
INSERT INTO `prescription_details` VALUES (1,1,NULL,'2019-05-24 10:58:07',NULL,NULL,NULL,1,0,'CBC',6,NULL,1),(2,1,NULL,'2019-05-24 10:58:07',NULL,NULL,NULL,1,0,'Urin test',1,NULL,1),(3,1,NULL,'2019-05-24 11:49:27',NULL,NULL,NULL,2,0,'sdfsdfsd',6,NULL,1),(4,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,1,0,'CBC',6,NULL,2),(5,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,2,0,'tsh',6,NULL,2),(6,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,3,0,'antorher',6,NULL,2),(7,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,1,0,'Urin test',1,NULL,2),(8,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,2,0,'Blood Test',1,0,2),(9,1,NULL,'2019-05-24 11:54:56',NULL,NULL,NULL,1,0,'Drank Mote water',8,NULL,2),(17,1,NULL,'2019-05-24 12:05:34',NULL,NULL,NULL,2,0,'Blood Test',1,NULL,1),(16,1,NULL,'2019-05-24 12:05:20',NULL,NULL,NULL,3,0,'oooooo',6,NULL,1),(18,1,NULL,'2019-06-03 12:41:51',NULL,NULL,NULL,1,0,'CBC',6,NULL,3),(19,1,NULL,'2019-06-03 12:41:51',NULL,NULL,NULL,1,0,'Drank Mote water',8,NULL,3),(20,1,NULL,'2019-06-04 10:03:52',NULL,NULL,NULL,1,0,'Blood Test',1,NULL,3),(22,1,NULL,'2019-06-04 10:06:26',NULL,NULL,NULL,0,0,'<p>Thiis is a histrory</p>\n',5,NULL,3),(25,1,NULL,'2019-06-04 10:40:20',NULL,NULL,NULL,1,0,'Back Pain',7,NULL,4),(26,1,NULL,'2019-06-04 10:43:07',NULL,NULL,NULL,1,0,'Back Pain',7,NULL,1),(27,1,NULL,'2019-06-04 10:46:30',NULL,NULL,NULL,1,0,'Blood Test',1,NULL,5),(28,1,NULL,'2019-06-04 10:46:30',NULL,NULL,NULL,2,0,'Urin test',1,NULL,5),(29,1,NULL,'2019-06-04 10:46:30',NULL,NULL,NULL,1,0,'Back Pain',7,NULL,5),(30,1,NULL,'2019-06-04 10:46:30',NULL,NULL,NULL,1,0,'Drank Mote water',8,NULL,5),(31,1,NULL,'2019-06-06 12:42:43',NULL,NULL,NULL,2,0,'HTN',1,NULL,3),(32,1,NULL,'2019-06-06 12:42:43',NULL,NULL,NULL,3,0,'Iron Deficiency Anemia',1,NULL,3),(51,1,NULL,'2019-06-06 13:05:37',NULL,NULL,NULL,2,0,'Neck node on left side of neck',7,NULL,3),(34,1,NULL,'2019-06-06 12:42:43',NULL,NULL,NULL,4,0,'Viral Syndrome',1,NULL,3),(35,1,NULL,'2019-06-06 12:42:43',NULL,NULL,NULL,5,0,'High blood sugar',1,NULL,3),(44,1,NULL,'2019-06-06 12:49:57',NULL,NULL,NULL,2,0,'Use Hot Water',8,NULL,3),(45,1,NULL,'2019-06-06 12:49:57',NULL,NULL,NULL,3,0,'Avoid dairy products,',8,NULL,3),(50,1,NULL,'2019-06-06 13:05:37',NULL,NULL,NULL,3,0,'Pain in left breast',7,NULL,3),(49,1,NULL,'2019-06-06 13:05:37',NULL,NULL,NULL,1,0,'Back Pain',7,NULL,3),(48,1,NULL,'2019-06-06 13:04:58',NULL,NULL,NULL,4,0,'Follow up after 6 months',8,NULL,3);
/*!40000 ALTER TABLE `prescription_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_finalize`
--

DROP TABLE IF EXISTS `prescription_finalize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_finalize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `finalize_name` varchar(255) DEFAULT NULL,
  `finalize_result` varchar(4000) DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `finalization_id` bigint(20) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgw255eq6jw7t24wt3unnw0mvu` (`finalization_id`),
  KEY `FKqj5uft1qaj6fe5avcqc2lvnqd` (`prescription_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_finalize`
--

LOCK TABLES `prescription_finalize` WRITE;
/*!40000 ALTER TABLE `prescription_finalize` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescription_finalize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_medicine`
--

DROP TABLE IF EXISTS `prescription_medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_medicine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `dosage` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `form` varchar(255) DEFAULT NULL,
  `generic_name` varchar(255) DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `item_no` varchar(255) DEFAULT NULL,
  `item_qty` varchar(255) DEFAULT NULL,
  `medicine_comment` varchar(255) DEFAULT NULL,
  `prescrition_data_type` int(11) DEFAULT NULL,
  `reference_id` bigint(20) DEFAULT NULL,
  `relation_with_meal` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `strength` varchar(255) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsyekq71kof2u6qesspay4md1n` (`prescription_no`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_medicine`
--

LOCK TABLES `prescription_medicine` WRITE;
/*!40000 ALTER TABLE `prescription_medicine` DISABLE KEYS */;
INSERT INTO `prescription_medicine` VALUES (1,1,NULL,'2019-05-24 10:58:07',NULL,NULL,'Napa',NULL,NULL,'Paracetamal','Paracdtamal',1,0,'101','',NULL,4,101,NULL,'1000mg',NULL,1),(2,1,NULL,'2019-05-24 11:54:56',NULL,NULL,'Napa',NULL,'30 Day','Paracetamal','Paracdtamal',1,0,'101','',NULL,4,101,'After Meal','1000mg','500 Mg',2),(6,1,NULL,'2019-06-04 10:03:52',NULL,NULL,'Matazin mr-35','1+1+1','30 Day',NULL,NULL,2,0,'','400 pic','Drink more water',4,NULL,'After Meal','transdermal','500 Mg',3),(7,1,NULL,'2019-06-04 10:46:30',NULL,NULL,'Matazin mr-35','1+1+1','30 Day','','',1,0,NULL,'','Drink more water',4,NULL,'After Meal','transdermal','500 Mg',5),(8,1,NULL,'2019-06-04 10:46:30',NULL,NULL,'Napa','','30 Day','Paracetamal','Paracdtamal',2,0,NULL,'','',4,NULL,'After Meal','1000mg','500 Mg',5),(9,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Glucozid','0+0+1','Continual','','Glicliazide',1,1,NULL,'','',4,NULL,'After Meal','Oral','80 Mg',3),(10,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Napa','1+1+1','30 Day','Beximco','Paracetamol',3,0,NULL,'','Drank More Water',4,NULL,'After Meal','Oral','500 Mg',3),(11,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Neotack','1+0+1','CONT','','',4,0,NULL,'','',4,NULL,'Before Meal','Oral','150 Mg',3),(12,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Nitrocard','1+0+1','Continual','Usp','Nitroglycerin',5,1,NULL,'','',4,NULL,'After Meal','Oral','2.6 Mg',3),(13,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Ramoril','0+0+1','Continual','','Ramipril',6,0,NULL,'','',4,NULL,'After Meal','Oral','1.25',3),(15,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Bopam','0+0+1','Continual','','Bromzzepam',7,0,NULL,'','If less Sleep',4,NULL,'After Meal','Oral','3 Mg',3),(16,1,NULL,'2019-06-06 12:42:43',NULL,NULL,'Agoxin','1/2+0+0','Continual','DAR','Digoxin',8,0,NULL,'','',4,NULL,'After Meal','Oral','0.25',3);
/*!40000 ALTER TABLE `prescription_medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_physical_exam`
--

DROP TABLE IF EXISTS `prescription_physical_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_physical_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `exam_data_type` int(11) DEFAULT NULL,
  `exam_name` varchar(255) DEFAULT NULL,
  `exam_result` varchar(4000) DEFAULT NULL,
  `exam_unit` varchar(255) DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `exam_group_id` bigint(20) NOT NULL,
  `physical_exam_id` bigint(20) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl5oy0yp53rwe0fipwj8lrbnm5` (`exam_group_id`),
  KEY `FK1v8aeejq5bojr22b5ctmsjvuq` (`physical_exam_id`),
  KEY `FKau9l7osww1aag9ul7gyxdwpuo` (`prescription_no`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_physical_exam`
--

LOCK TABLES `prescription_physical_exam` WRITE;
/*!40000 ALTER TABLE `prescription_physical_exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescription_physical_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_preferences`
--

DROP TABLE IF EXISTS `prescription_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_preferences` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `preferences_key` varchar(255) NOT NULL,
  `preferences_type` varchar(255) NOT NULL,
  `preferences_value` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `preferences_data_type` int(11) NOT NULL,
  `preferences_serial` int(11) NOT NULL,
  `show_in_report` int(11) NOT NULL,
  `show_in_tab` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_preferences`
--

LOCK TABLES `prescription_preferences` WRITE;
/*!40000 ALTER TABLE `prescription_preferences` DISABLE KEYS */;
INSERT INTO `prescription_preferences` VALUES (1,1,NULL,NULL,NULL,NULL,'Clinical History 1','clinical_history_1','Clinical History','0','Clinical History 1',1,1,1,0),(2,1,NULL,NULL,NULL,NULL,'Clinical History 2','clinical_history_2','Clinical History','0','Clinical History 2',1,2,1,0),(3,1,NULL,NULL,NULL,NULL,'Chief Complain','chief_complain','Chief Complain','0','Chief Complain',1,3,1,0),(4,1,NULL,NULL,NULL,NULL,'Physical Examination','physical_exam','Physical Examination','0','Physical Examination',1,4,1,0),(5,1,NULL,NULL,NULL,NULL,'Investigation','investigation','Investigation','0','Investigation',1,5,1,0),(6,1,NULL,NULL,NULL,NULL,'Medication','medication','Medication','0','Medication',1,6,1,0),(7,1,NULL,NULL,NULL,NULL,'Diagnosis','diagnosis','Diagnosis','0','Diagnosis',1,7,1,0),(8,1,NULL,NULL,NULL,NULL,'Advice','advice','Advice','0','Advice',1,8,1,0),(9,1,NULL,NULL,NULL,NULL,'Finalization','finalization_1','Finalization','0','Finalization 1',1,9,1,0),(10,1,NULL,NULL,NULL,NULL,'Finalization','finalization_2','Finalization','0','Finalization 2',1,10,1,0),(11,1,NULL,NULL,NULL,NULL,'Hostory','history','History','0','History',1,11,1,0),(12,1,NULL,NULL,NULL,NULL,'report_footer_consultation_time','report_footer_consultation_time','report_footer_consultation_time','Footer Value','report_footer_consultation_time',4,12,1,0),(13,1,NULL,NULL,NULL,NULL,'Vital','vital','Vital','0','Vital',1,13,1,0),(14,1,NULL,NULL,NULL,NULL,'Referral','referral_key','Referral','0','Referral',1,14,1,0),(15,1,NULL,NULL,NULL,NULL,'General Note','general_note','General Note','0','General Note',5,15,1,0);
/*!40000 ALTER TABLE `prescription_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_user_preferences`
--

DROP TABLE IF EXISTS `prescription_user_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_user_preferences` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `user_no` bigint(20) NOT NULL,
  `user_preferences_key` varchar(255) NOT NULL,
  `preferences_type` varchar(255) NOT NULL,
  `user_preferences_value` varchar(255) DEFAULT NULL,
  `preferences_data_type` int(11) NOT NULL,
  `preferences_serial` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `show_in_report` int(11) NOT NULL DEFAULT '1',
  `show_in_tab` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_user_preferences`
--

LOCK TABLES `prescription_user_preferences` WRITE;
/*!40000 ALTER TABLE `prescription_user_preferences` DISABLE KEYS */;
INSERT INTO `prescription_user_preferences` VALUES (46,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'clinical_history_1','Clinical History','0',1,6,NULL,'Clinical History 1',0,1),(47,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'clinical_history_2','Clinical History','0',1,7,NULL,'Clinical History 2',0,1),(48,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(49,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'physical_exam','Physical Examination','0',1,8,NULL,'Physical Examination',0,1),(50,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'investigation','Investigation','1',1,2,NULL,'Investigation',1,1),(51,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'medication','Medication','1',1,4,NULL,'Medication',1,1),(52,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'diagnosis','Diagnosis','0',1,5,NULL,'Diagnosis',0,1),(53,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'advice','Advice','1',1,3,NULL,'Advice',1,1),(54,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'finalization_1','Finalization','0',1,9,NULL,'Finalization',0,1),(55,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',0,1),(56,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'history','History','0',1,11,NULL,'History',0,1),(57,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'report_footer_consultation_time','report_footer_consultation_time','Chamber: 12 PM - 8 PM (Saturday to Thursday)',4,12,NULL,'report_footer_consultation_time',0,1),(58,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'clinical_history_1','Clinical History 1','1',1,1,NULL,'Clinical History',1,0),(59,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'clinical_history_2','Clinical History 2','0',1,10,NULL,'Clinical History',1,0),(60,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'chief_complain','Chief Complain','1',1,2,NULL,'Chief Complain',1,0),(61,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(62,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'investigation','Investigation','1',1,4,NULL,'Investigation',1,0),(63,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'medication','Medication','1',1,5,NULL,'Medication',1,0),(64,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,0),(65,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'advice','Advice','1',1,7,NULL,'Advice',1,0),(66,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'finalization_1','Finalization 1','1',1,8,NULL,'Finalization',1,0),(67,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',0,0),(68,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'history','History','1',1,9,NULL,'History',1,0),(69,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(70,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'clinical_history_1','Clinical History 1','1',1,1,NULL,'Clinical History',1,1),(71,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'clinical_history_2','Clinical History 2','0',1,2,NULL,'Clinical History',0,0),(72,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'chief_complain','Chief Complain','1',1,4,NULL,'Chief Complain',1,1),(73,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(74,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'investigation','Investigation','1',1,5,NULL,'Investigation Advised',1,1),(75,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'medication','Medication','1',1,6,NULL,'Medication',1,1),(76,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(77,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'advice','Advice','1',1,8,NULL,'Advice',1,1),(78,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'finalization_1','Finalization','0',1,9,NULL,'Finalization 1',0,0),(79,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'finalization_2','Finalization 2','1',1,10,NULL,'Finalization',0,1),(80,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'history','History','1',1,11,NULL,'History',0,1),(81,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'report_footer_consultation_time','report_footer_consultation_time','Consulting Hours: Evening 11:00AM to 1:00PM (Saturday to Thursday)<br/>Report Viewing: After 1st visit within 7 days -Free (Take appointment for the reports too), Every Follow up visit needs appointment',4,12,NULL,'report_footer_consultation_time',1,0),(82,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'clinical_history_1','Clinical History','1',1,1,NULL,'Clinical History',1,1),(83,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'clinical_history_2','Finalization 4','0',1,4,NULL,'Clinical History 2',0,0),(84,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complain',1,1),(85,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'physical_exam','Physical Examination','1',1,5,NULL,'Physical Examination',1,1),(86,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'investigation','Investigation','1',1,6,NULL,'Investigation',1,1),(87,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'medication','Medication','1',1,7,NULL,'Medication',1,1),(88,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'diagnosis','Diagnosis','1',1,8,NULL,'Diagnosis',1,1),(89,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'advice','Advice','1',1,9,NULL,'Advice',1,1),(90,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'finalization_1','Finalization','0',1,10,NULL,'Finalization',0,0),(91,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'finalization_2','Finalization','1',1,11,NULL,'Finalization 2',0,1),(92,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'history','History','1',1,2,NULL,'History',0,1),(93,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'report_footer_consultation_time','report_footer_consultation_time','Chamber: 3:00PM - 5:00PM (Saturday to Thursday) Report Viewing: After 1st visit within 7 days Free\n (Take appointment for the reports too), Every Follow up visit needs appointment.',4,12,NULL,'report_footer_consultation_time',1,0),(94,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'clinical_history_1','Clinical History','0',1,11,NULL,'Clinical History 1',1,0),(95,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'clinical_history_2','Clinical History','0',1,10,NULL,'Clinical History 2',1,0),(96,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'chief_complain','Chief Complain','1',1,2,NULL,'Chief Complaint\'s',1,1),(97,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'physical_exam','Physical Examination','1',1,8,NULL,'Physical Examination',1,1),(98,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'investigation','Investigation','1',1,5,NULL,'Investigation',1,1),(99,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'medication','Medication','1',1,6,NULL,'Medication',1,1),(100,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'diagnosis','Diagnosis','1',1,4,NULL,'Diagnosis',1,1),(101,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'advice','Advice','1',1,7,NULL,'Advice',1,1),(102,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'finalization_1','Finalization 1','1',1,9,NULL,'Finalization',1,1),(103,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'finalization_2','Finalization','0',1,13,NULL,'Finalization 2',1,0),(104,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'history','History','1',1,1,NULL,'History',1,1),(105,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'report_footer_consultation_time','report_footer_consultation_time','Chamber Evening : 3 PM - 8 PM (Saturday, Monday & Wednesday.)<br\\>Chamber Evening : 5 PM - 10 PM (Sunday, Tuesday & Thursday.)',4,12,NULL,'report_footer_consultation_time',1,0),(106,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'clinical_history_1','Comobidity','1',1,2,NULL,'Comorbidity',1,1),(107,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'clinical_history_2','Known  Case of','1',1,3,NULL,'Known  Case of',1,1),(108,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'chief_complain','Chief Complaints','1',1,4,NULL,'Chief Complaints',1,1),(109,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'physical_exam','Physical Examination','1',1,5,NULL,'Physical Examination',1,1),(110,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'investigation','Investigations','1',1,6,NULL,'Investigations',1,1),(111,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'medication','Medication','1',1,7,NULL,'Medication',1,1),(112,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'diagnosis','Impression','1',1,8,NULL,'Diagnosis',1,1),(113,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'advice','Advice','1',1,9,NULL,'Advice',1,1),(114,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'finalization_1','Finalization','1',1,10,NULL,'Finalization',1,1),(115,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'finalization_2','Finalization','0',1,1,NULL,'Comorbidity',1,0),(116,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'history','History','1',1,11,NULL,'History',1,1),(117,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'report_footer_consultation_time','report_footer_consultation_time',NULL,4,13,NULL,'report_footer_consultation_time',1,0),(118,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'clinical_history_1','Note','1',1,12,NULL,'Note',1,1),(119,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'clinical_history_2','Referral','0',1,13,NULL,'Referral',0,0),(120,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'chief_complain','Chief Complaints','1',1,1,NULL,'Chief Complaints',1,1),(121,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,1),(122,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'investigation','Investigation(s) Advised','1',1,5,NULL,'Investigation(s) Advised',1,1),(123,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'medication','Medication','1',1,6,NULL,'Medication',1,1),(124,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(125,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'advice','Advice','1',1,8,NULL,'Advice',1,1),(126,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'finalization_1','Finalization','0',1,14,NULL,'Finalization 1',0,0),(127,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'finalization_2','Follow Up','1',1,9,NULL,'Follow Up',0,1),(128,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'history','History','1',1,2,NULL,'History',1,1),(129,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'report_footer_consultation_time','report_footer_consultation_time','Chamber: By appointment          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size:9px\">Hot Line: 10633</span>',4,15,NULL,'report_footer_consultation_time',1,0),(130,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'vital','Vital','1',1,3,NULL,'Vital',1,1),(131,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'vital','Vital signs','1',1,3,NULL,'Vital Signs',1,1),(132,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'vital','Vital','0',1,13,NULL,'Vital',1,0),(133,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'vital','Vital','0',1,13,NULL,'Vital',0,0),(134,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'clinical_history_1','Clinical History 1','1',1,1,NULL,'Clinical History',1,1),(135,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'clinical_history_2','Clinical History','0',1,12,NULL,'Clinical History 2',0,0),(136,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complain',1,1),(137,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,1),(138,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'investigation','Investigation','1',1,5,NULL,'Investigation Advised',1,1),(139,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'medication','Medication','1',1,6,NULL,'Medication',1,1),(140,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(141,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'advice','Advice','1',1,8,NULL,'Advice',1,1),(142,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'finalization_1','Finalization','0',1,13,NULL,'Finalization 1',0,0),(143,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'finalization_2','Finalization 2','1',1,9,NULL,'Finalization',0,1),(144,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'history','History','1',1,2,NULL,'History',0,1),(145,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'report_footer_consultation_time','report_footer_consultation_time','Chamber: 4:00PM - 8:00PM (Saturday to Wednesday), 10:00AM- 4:00PM (Thursday), Report Viewing: After 1st visit within 7 days Free\n (Take appointment for the reports too), Every Follow up visit needs appointment.',4,14,NULL,'report_footer_consultation_time',0,0),(146,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'vital','Vital','0',1,15,NULL,'Vital',1,0),(147,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'clinical_history_1','Clinical History','0',1,0,NULL,'Clinical History 1',1,1),(148,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,1),(149,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(150,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,1),(151,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'investigation','Investigation','1',1,5,NULL,'Investigation',1,1),(152,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'medication','Medication','1',1,6,NULL,'Medication',1,1),(153,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(154,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'advice','Advice','1',1,8,NULL,'Advice',1,1),(155,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'finalization_1','Finalization','1',1,3,NULL,'Finalization',1,1),(156,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,1),(157,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'history','History','1',1,2,NULL,'History',1,1),(158,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'report_footer_consultation_time','report_footer_consultation_time','Consultancy Hours: Morning: 12:30 PM - 1:30 PM,\nEvening: 5:00 PM - 8:00 PM',4,12,NULL,'report_footer_consultation_time',1,1),(159,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'vital','Vital','0',1,13,NULL,'Vital',1,1),(160,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'vital','Vital','0',1,12,NULL,'Vital',1,0),(161,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'clinical_history_1','Clinical History','0',1,1,NULL,'Clinical History 1',1,0),(162,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,0),(163,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(164,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(165,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'investigation','Investigation','1',1,5,NULL,'Investigation',1,0),(166,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'medication','Medication','1',1,6,NULL,'Medication',1,0),(167,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(168,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'advice','Advice','1',1,8,NULL,'Advice',1,0),(169,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'finalization_1','Finalization','1',1,9,NULL,'Finalization',1,0),(170,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(171,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'history','History','1',1,2,NULL,'History',1,0),(172,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(173,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'vital','Vital','0',1,13,NULL,'Vital',1,0),(174,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'clinical_history_1','Clinical History','0',1,1,NULL,'Clinical History 1',1,0),(175,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,0),(176,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complain',1,0),(177,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(178,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'investigation','Investigation','1',1,5,NULL,'Investigation',1,0),(179,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'medication','Medication','1',1,6,NULL,'Medication',1,0),(180,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(181,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'advice','Advice','1',1,8,NULL,'Advice',1,0),(182,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'finalization_1','Finalization','1',1,9,NULL,'Finalization 1',1,0),(183,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(184,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'history','History','1',1,11,NULL,'History',1,0),(185,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(186,1,NULL,'2019-01-10 11:31:35',NULL,NULL,251,'vital','Vital','0',1,13,NULL,'Vital',1,0),(187,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'clinical_history_1','General History','0',1,11,NULL,'Clinical History 1',0,0),(188,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'clinical_history_2','Clinical History','0',1,13,NULL,'Clinical History 2',0,0),(189,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'chief_complain','Chief Complaint\'s','1',1,1,NULL,'Chief Complaint\'s',1,0),(190,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(191,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'investigation','Investigation','1',1,4,NULL,'Investigations',1,0),(192,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'medication','Medication','1',1,6,NULL,'Medication',1,0),(193,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,0),(194,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'advice','Advice','0',1,7,NULL,'Advice',1,0),(195,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'finalization_1','Finalization','0',1,12,NULL,'Finalization 1',0,0),(196,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'finalization_2','Finalization','0',1,8,NULL,'Finalization 2',0,0),(197,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'history','History','1',1,2,NULL,'History',1,0),(198,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'report_footer_consultation_time','report_footer_consultation_time','Consultancy Hours: 6:00 PM - 9:00 PM (Saturday, Tuesday, Wednesday)',4,9,NULL,'report_footer_consultation_time',1,0),(199,1,NULL,'2019-01-03 15:22:58',NULL,NULL,113,'vital','Vital','0',1,10,NULL,'Vital',0,0),(200,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'clinical_history_1','Clinical History','1',1,10,NULL,'Clinical History',0,1),(201,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'clinical_history_2','Clinical History','0',1,11,NULL,'Clinical History 2',0,0),(202,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'chief_complain','Chief Complaint\'s','1',1,1,NULL,'Chief Complaint\'s',1,1),(203,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(204,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'investigation','Investigation','1',1,4,NULL,'Investigation',1,1),(205,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'medication','Medication','1',1,5,NULL,'Medication',1,1),(206,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,1),(207,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'advice','Advice','1',1,7,NULL,'Advice',1,1),(208,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'finalization_1','Finalization','0',1,8,NULL,'Finalization 1',0,0),(209,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'finalization_2','Finalization','1',1,9,NULL,'Finalization',1,1),(210,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'history','History','1',1,2,NULL,'History',1,1),(211,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'report_footer_consultation_time','report_footer_consultation_time','Consultancy Hours:\nEvening: 4:30 PM to 8:00 PM (Saturday to Thursday).',4,12,NULL,'report_footer_consultation_time',0,0),(212,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'vital','Vital','0',1,13,NULL,'Vital',1,0),(213,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'clinical_history_1','Clinical History','0',1,11,NULL,'Clinical History 1',1,0),(214,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'clinical_history_2','Clinical History2','1',1,7,NULL,'Laser and Dermatosurgery',1,1),(215,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(216,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,1),(217,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'investigation','Investigation','1',1,3,NULL,'Investigation',1,1),(218,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'medication','Medication','1',1,4,NULL,'Medication',1,1),(219,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,1),(220,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'advice','Advice','1',1,6,NULL,'Advice',1,1),(221,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'finalization_1','Finalization','0',1,9,NULL,'Laser and Dermatosurgery',1,0),(222,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(223,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'history','History','1',1,8,NULL,'History',1,1),(224,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'report_footer_consultation_time','report_footer_consultation_time','Consulting Hours: 3pm-9pm(SAT,SUN,MON,WED & THRUS),\n                               7pm-9pm(TUES)',4,12,NULL,'report_footer_consultation_time',1,0),(225,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'vital','Vital','0',1,13,NULL,'Vital',1,0),(226,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'vital','Vital','0',1,13,NULL,'Vital',1,0),(227,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'clinical_history_1','Clinical History','0',1,1,NULL,'Clinical History',1,0),(228,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,0),(229,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complaints',1,0),(230,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(231,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'investigation','Investigation','1',1,6,NULL,'Investigations',1,0),(232,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'medication','Medication','1',1,7,NULL,'Medication',1,0),(233,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'diagnosis','Diagnosis','1',1,8,NULL,'Diagnosis',1,0),(234,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'advice','Advice','1',1,9,NULL,'Advice',1,0),(235,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'finalization_1','Finalization','1',1,10,NULL,'Finalization',1,0),(236,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(237,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'history','History','1',1,5,NULL,'History',1,0),(238,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(239,1,NULL,'2019-01-03 11:11:36',NULL,NULL,205,'vital','Vital','0',1,13,NULL,'Vital',1,0),(240,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'clinical_history_1','Clinical History','0',1,1,NULL,'Clinical History 1',1,0),(241,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,0),(242,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complain',1,0),(243,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(244,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'investigation','Investigation','1',1,5,NULL,'Investigation',1,0),(245,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'medication','Medication','1',1,6,NULL,'Medication',1,0),(246,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(247,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'advice','Advice','1',1,8,NULL,'Advice',1,0),(248,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'finalization_1','Finalization','1',1,9,NULL,'Finalization',1,0),(249,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(250,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'history','History','1',1,11,NULL,'History',1,0),(251,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(252,1,NULL,'2019-01-02 13:21:18',NULL,NULL,128,'vital','Vital','0',1,13,NULL,'Vital',1,0),(253,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'clinical_history_1','Clinical History','1',1,3,NULL,'Clinical History',1,1),(254,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'clinical_history_2','Clinical History','0',1,11,NULL,'Clinical History',0,0),(255,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaints',1,1),(256,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,1),(257,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'investigation','Investigation','1',1,5,NULL,'Investigations Advised',1,1),(258,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'medication','Medication','1',1,7,NULL,'Medications',1,1),(259,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,1),(260,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'advice','Advice','1',1,8,NULL,'Advices',1,1),(261,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'finalization_1','Finalization','0',1,10,NULL,'Finalization',0,0),(262,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'finalization_2','Finalization','0',1,12,NULL,'Finalization 2',0,0),(263,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'history','History','1',1,2,NULL,'History',1,1),(264,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'report_footer_consultation_time','report_footer_consultation_time','Consultancy Hours: Evening 4:30PM - 8:00PM (Sunday - Wednesday).',4,13,NULL,'report_footer_consultation_time',1,0),(265,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'vital','Vital','0',1,14,NULL,'Vital',0,0),(266,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'clinical_history_1','Clinical History','1',1,1,NULL,'Clinical History',1,0),(267,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'clinical_history_2','Clinical History','0',1,2,NULL,'Clinical History 2',1,0),(268,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'chief_complain','Chief Complain','1',1,3,NULL,'Chief Complaints',1,0),(269,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(270,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'investigation','Investigation','1',1,5,NULL,'Investigations',1,0),(271,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'medication','Medication','1',1,6,NULL,'Medication',1,0),(272,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(273,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'advice','Advice','1',1,8,NULL,'Advice',1,0),(274,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'finalization_1','Finalization','1',1,9,NULL,'Finalization',1,0),(275,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(276,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'history','History','1',1,11,NULL,'History',1,0),(277,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(278,1,NULL,'2019-01-06 16:36:48',NULL,NULL,185,'vital','Vital','0',1,13,NULL,'Vital',1,0),(279,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'referral_key','Referral','1',1,10,NULL,'Referral',1,1),(280,1,NULL,'2019-01-01 13:32:22',NULL,NULL,146,'referral_key','Referral','0',1,14,NULL,'Referral',0,0),(281,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'referral_key','Referral','1',1,11,NULL,'Referral',1,1),(282,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(283,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'referral_key','Referral','1',1,14,NULL,'Referral',1,1),(284,1,NULL,'2019-01-01 11:29:31',NULL,NULL,113,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(285,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'referral_key','Referral','0',1,14,NULL,'Referral',1,1),(286,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'referral_key','Referral','1',1,14,NULL,'Referral',1,1),(287,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(288,1,NULL,'2019-01-01 12:13:03',NULL,NULL,240,'referral_key','Referral','0',1,14,NULL,'Referral',0,0),(289,1,NULL,'2019-01-01 12:14:17',NULL,NULL,205,'referral_key','Referral','0',1,14,NULL,'Referral',0,0),(290,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'referral_key','Referral','0',1,14,NULL,'Referral',0,0),(291,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaints',1,1),(292,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'history','History','1',1,2,NULL,'History',1,1),(293,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(294,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'investigation','Investigation','1',1,4,NULL,'Investigations',1,1),(295,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,1),(296,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'medication','Medication','1',1,6,NULL,'Medication',1,1),(297,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'advice','Advice','1',1,7,NULL,'Advice',1,1),(298,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',0,1),(299,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'clinical_history_2','Clinical History','0',1,9,NULL,'Clinical History 2',0,0),(300,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'clinical_history_1','Clinical History','0',1,10,NULL,'Clinical History 1',0,0),(301,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',0,0),(302,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'report_footer_consultation_time','report_footer_consultation_time','Visiting Days & Time: 6:00PM - 9:00PM (Everyday)\nExcept Friday and Tuesday',4,12,NULL,'report_footer_consultation_time',1,0),(303,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'vital','Vital','0',1,13,NULL,'Vital',1,0),(304,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'chief_complain','Chief Complaint\'s','1',1,1,NULL,'Chief Complaint\'s',1,0),(305,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'clinical_history_1','History','0',1,9,NULL,'History',0,0),(306,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,0),(307,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'medication','Medication','1',1,5,NULL,'Medication',1,0),(308,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'investigation','Investigation','1',1,4,NULL,'Investigations',1,0),(309,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'advice','Advice','1',1,7,NULL,'Advice',1,0),(310,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'clinical_history_2','Clinical History','0',1,10,NULL,'Clinical History 2',1,0),(311,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(312,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',0,0),(313,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(314,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'history','History','1',1,2,NULL,'History',1,0),(315,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'report_footer_consultation_time','report_footer_consultation_time','Consultancy Hours : Evening:  6:00 PM - 9:00 PM  Saturday, Sunday, Monday, Wednesday, Thursday',4,12,NULL,'report_footer_consultation_time',1,0),(316,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'vital','Vital','0',1,13,NULL,'Vital',1,0),(317,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'clinical_history_1','Clinical History','0',1,2,NULL,'Clinical History 1',1,0),(318,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'clinical_history_2','Clinical History','0',1,3,NULL,'Clinical History 2',1,0),(319,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaints',1,1),(320,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,1),(321,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'investigation','Investigation','1',1,5,NULL,'Investigations',1,1),(322,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'medication','Medication','1',1,6,NULL,'Medication',1,1),(323,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(324,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'advice','Advice','1',1,8,NULL,'Advice',1,1),(325,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'finalization_1','Finalization','1',1,9,NULL,'Finalization',1,1),(326,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(327,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'history','History','1',1,11,NULL,'History',1,1),(328,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(329,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'vital','Vital','0',1,13,NULL,'Vital',1,0),(330,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'vital','Vital','0',1,13,NULL,'Vital',0,1),(331,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'clinical_history_1','Clinical History','0',1,9,NULL,'Laser and Dermatosurgery',1,0),(332,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'clinical_history_2','Clinical History','1',1,10,NULL,'Laser and Dermatosurgery',1,1),(333,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaints',1,1),(334,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,1),(335,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'investigation','Investigation','1',1,3,NULL,'Investigations',1,1),(336,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'medication','Medication','1',1,4,NULL,'Medication',1,1),(337,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,1),(338,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'advice','Advice','1',1,6,NULL,'Advice',1,1),(339,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'finalization_1','Finalization','0',1,7,NULL,'Finalization',1,0),(340,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'finalization_2','Finalization','0',1,8,NULL,'Finalization 2',1,0),(341,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'history','History','1',1,11,NULL,'History',1,1),(342,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(343,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'vital','Vital','0',1,13,NULL,'Vital',1,0),(344,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'chief_complain','Chief Complain','0',1,5,NULL,'Chief Complain',0,0),(345,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'clinical_history_1','Clinical History','1',1,1,NULL,'Prescription',0,1),(346,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'vital','Vital','0',1,13,NULL,'On Examination',0,0),(347,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'advice','Advice','0',1,8,NULL,'Advice',0,0),(348,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'diagnosis','Diagnosis','0',1,7,NULL,'Diagnosis',0,0),(349,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'finalization_1','Finalization','0',1,9,NULL,'Follow Up',0,0),(350,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'clinical_history_2','Clinical History','0',1,4,NULL,'Referral',0,0),(351,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'finalization_2','Finalization','0',1,10,NULL,'Special instructions',0,0),(352,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'investigation','Investigation','1',1,2,NULL,'Investigation',0,1),(353,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'medication','Medication','1',1,3,NULL,'Medication',0,1),(354,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'physical_exam','Physical Examination','0',1,6,NULL,'Comorbidities',0,0),(355,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'history','History','0',1,11,NULL,'History',0,0),(356,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'report_footer_consultation_time','report_footer_consultation_time','Chamber : (Saturday & Thursday) 10 am- 1 pm (Morning), 3 pm - 6 pm (Evening)<br\\>(Sunday to Wednesday) 11 am - 1 pm (Morning), 4 pm - 8 pm (Evening).',4,12,NULL,'report_footer_consultation_time',0,0),(357,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'clinical_history_1','Clinical History','0',1,2,NULL,'Clinical History 1',1,0),(358,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'clinical_history_2','Clinical History','1',1,3,NULL,'Clinical History',1,0),(359,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaints',1,0),(360,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(361,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'investigation','Investigation','1',1,5,NULL,'Investigations',1,0),(362,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'medication','Medication','1',1,6,NULL,'Medication',1,0),(363,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(364,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'advice','Advice','1',1,8,NULL,'Advice',1,0),(365,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'finalization_1','Finalization','0',1,9,NULL,'Finalization',1,0),(366,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(367,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'history','History','0',1,11,NULL,'History',1,0),(368,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(369,1,NULL,'2019-01-09 18:04:48',NULL,NULL,119,'vital','Vital','0',1,13,NULL,'Vital',1,0),(370,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(371,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,0),(372,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'investigation','Investigation','1',1,3,NULL,'Investigation',1,0),(373,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'medication','Medication','1',1,4,NULL,'Medication',1,0),(374,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,0),(375,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'advice','Advice','1',1,6,NULL,'Advice',1,0),(376,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'finalization_1','Finalization','1',1,7,NULL,'Follow Up',1,0),(377,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'clinical_history_1','Clinical History','0',1,8,NULL,'Clinical History 1',1,0),(378,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'clinical_history_2','Clinical History','0',1,9,NULL,'Clinical History 2',1,0),(379,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(380,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'history','History','0',1,11,NULL,'History',1,0),(381,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'report_footer_consultation_time','report_footer_consultation_time','Foote',4,12,NULL,'report_footer_consultation_time',1,0),(382,1,NULL,'2019-01-06 15:08:24',NULL,NULL,130,'vital','Vital','0',1,13,NULL,'Vital',1,0),(383,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(384,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,1),(385,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'investigation','Investigation','1',1,3,NULL,'Investigation',1,1),(386,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'medication','Medication','1',1,4,NULL,'Medication',1,1),(387,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,1),(388,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'advice','Advice','1',1,6,NULL,'Advice',1,1),(389,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'clinical_history_1','Clinical History','0',1,7,NULL,'Clinical History 1',1,0),(390,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'clinical_history_2','Clinical History','0',1,8,NULL,'Clinical History 2',1,0),(391,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'finalization_1','Finalization','1',1,9,NULL,'Follow Up',0,1),(392,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(393,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'history','History','0',1,11,NULL,'History',1,0),(394,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(395,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'vital','Vital','0',1,13,NULL,'Vital',1,0),(396,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(397,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,0),(398,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'investigation','Investigation','1',1,3,NULL,'Investigation',1,0),(399,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'medication','Medication','1',1,4,NULL,'Medication',1,0),(400,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,0),(401,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'clinical_history_1','Clinical History','1',1,10,NULL,'Template',1,0),(402,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'advice','Advice','1',1,7,NULL,'Advice',1,0),(403,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'history','History','1',1,8,NULL,'History',1,0),(404,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'finalization_1','Finalization','1',1,9,NULL,'Follow Up',0,0),(405,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'clinical_history_2','Clinical History','1',1,6,NULL,'Laser and Dermatosurgery',1,0),(406,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',0,0),(407,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(408,1,NULL,'2019-01-06 21:38:22',NULL,NULL,145,'vital','Vital','0',1,13,NULL,'Vital',1,0),(409,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(410,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,0),(411,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'medication','Medication','1',1,3,NULL,'Medication',1,0),(412,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'investigation','Investigation','1',1,4,NULL,'Investigation',1,0),(413,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,0),(414,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'advice','Advice','1',1,6,NULL,'Advice',1,0),(415,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'history','History','1',1,7,NULL,'History',1,0),(416,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',1,0),(417,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'clinical_history_1','Clinical History','0',1,9,NULL,'Clinical History 1',1,0),(418,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'clinical_history_2','Clinical History','0',1,10,NULL,'Clinical History 2',1,0),(419,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(420,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(421,1,NULL,'2019-01-08 20:45:27',NULL,NULL,227,'vital','Vital','0',1,13,NULL,'Vital',1,0),(422,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(423,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(424,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'investigation','Investigation','1',1,4,NULL,'Investigation',1,1),(425,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'medication','Medication','1',1,5,NULL,'Medication',1,1),(426,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,1),(427,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'advice','Advice','1',1,7,NULL,'Advice',1,1),(428,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'history','History','1',1,2,NULL,'History',1,1),(429,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',0,1),(430,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'clinical_history_1','Clinical History','0',1,14,NULL,'Clinical History 1',1,0),(431,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'clinical_history_2','Clinical History','0',1,15,NULL,'Clinical History 2',1,0),(432,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'finalization_2','Finalization','0',1,9,NULL,'Finalization 2',0,0),(433,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'report_footer_consultation_time','report_footer_consultation_time','',4,10,NULL,'report_footer_consultation_time',1,0),(434,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'vital','Vital','0',1,11,NULL,'Vital',1,0),(435,1,NULL,'2019-02-13 18:11:40',NULL,NULL,153,'general_note','General Note','1',5,10,NULL,'Note',1,0),(436,1,NULL,'2019-02-14 11:03:36',NULL,NULL,101,'general_note','General Note','1',5,11,NULL,'General Note',1,0),(437,1,NULL,'2019-02-13 14:27:03',NULL,NULL,126,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(438,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(439,1,NULL,'2019-02-14 17:05:48',NULL,NULL,132,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(440,1,NULL,'2019-02-13 14:27:25',NULL,NULL,125,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(441,1,NULL,'2019-02-16 12:34:09',NULL,NULL,116,'general_note','General Note','0',5,15,NULL,'General Note',1,1),(442,1,NULL,'2019-02-16 15:38:49',NULL,NULL,179,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(443,1,NULL,'2019-02-13 13:06:37',NULL,NULL,245,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(444,1,NULL,'2019-02-13 14:14:55',NULL,NULL,246,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(445,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(446,1,NULL,'2019-01-28 18:13:12',NULL,NULL,127,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(447,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(448,1,NULL,'2019-02-14 19:15:32',NULL,NULL,111,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(449,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(450,1,NULL,'2019-02-16 16:29:35',NULL,NULL,151,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(451,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'referral_key','Referral','0',1,12,NULL,'Referral',1,0),(452,1,NULL,'2019-02-16 12:41:35',NULL,NULL,154,'general_note','General Note','0',5,13,NULL,'General Note',1,0),(453,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaint\'s',1,0),(454,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'history','History','1',1,2,NULL,'History',1,0),(455,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(456,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'investigation','Investigation','1',1,4,NULL,'Investigation',1,0),(457,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'medication','Medication','1',1,5,NULL,'Medication',1,0),(458,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,0),(459,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'advice','Advice','1',1,7,NULL,'Advice',1,0),(460,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',1,0),(461,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'referral_key','Referral','1',1,9,NULL,'Referral',1,0),(462,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'clinical_history_1','Clinical History','0',1,10,NULL,'Clinical History 1',0,0),(463,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'report_footer_consultation_time','report_footer_consultation_time','Chamber time: Morning (11AM-1PM) (Saturday, Sunday, Tuesday & Thursday)<br\\>Evening (8PM-9.30PM) (Saturday, Sunday, Monday, Tuesday, Wednesday & Thursday)',4,11,NULL,'report_footer_consultation_time',1,0),(464,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'vital','Vital','0',1,12,NULL,'Vital',1,0),(465,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'general_note','General Note','0',5,13,NULL,'General Note',1,0),(466,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'clinical_history_2','Clinical History','0',1,14,NULL,'Clinical History 2',1,0),(467,1,NULL,'2019-01-14 18:44:43',NULL,NULL,139,'finalization_2','Finalization','0',1,15,NULL,'Finalization 2',1,0),(468,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'referral_key','Referral','1',1,9,NULL,'Plan/Referral',1,1),(469,1,NULL,'2019-02-13 17:00:55',NULL,NULL,165,'general_note','General Note','0',5,15,NULL,'General Note',0,0),(470,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaint\'s',1,0),(471,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'history','History','1',1,2,NULL,'History',1,0),(472,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(473,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'investigation','Investigation','1',1,4,NULL,'Investigation',1,0),(474,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'medication','Medication','1',1,5,NULL,'Medication',1,0),(475,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,0),(476,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'advice','Advice','1',1,7,NULL,'Advice',1,0),(477,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'finalization_1','Finalization','1',1,8,NULL,'Follow Up',1,0),(478,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'referral_key','Referral','1',1,9,NULL,'Referral',1,0),(479,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'clinical_history_1','Clinical History','0',1,10,NULL,'Clinical History 1',1,0),(480,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'clinical_history_2','Clinical History','0',1,11,NULL,'Clinical History 2',1,0),(481,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'finalization_2','Finalization','0',1,12,NULL,'Finalization 2',1,0),(482,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,13,NULL,'report_footer_consultation_time',1,0),(483,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'vital','Vital','0',1,14,NULL,'Vital',1,0),(484,1,NULL,'2019-01-17 16:32:15',NULL,NULL,104,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(485,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(486,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'clinical_history_1','Clinical History','1',1,8,NULL,'Clinical History',1,1),(487,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(488,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'investigation','Investigation','1',1,4,NULL,'Investigation',1,1),(489,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'medication','Medication','1',1,5,NULL,'Medication',1,1),(490,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,1),(491,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'advice','Advice','1',1,7,NULL,'Advice',1,1),(492,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'finalization_1','Finalization','1',1,10,NULL,'Finalization',1,1),(493,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'history','History','1',1,9,NULL,'History',1,1),(494,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,11,NULL,'report_footer_consultation_time',1,0),(495,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'referral_key','Referral','1',1,14,NULL,'Referral',1,1),(496,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'general_note','General Note','0',5,15,NULL,'General Note',0,0),(497,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'clinical_history_2','Clinical History','1',1,2,NULL,'Comorbidities',1,1),(498,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'finalization_2','Finalization','0',1,12,NULL,'Finalization2',1,0),(499,1,NULL,'2019-02-18 15:41:17',NULL,NULL,136,'vital','Vital','0',1,13,NULL,'Vital',1,0),(500,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'clinical_history_1','Clinical History','1',1,2,NULL,'Clinical History 1',1,0),(501,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(502,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(503,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'investigation','Investigation','1',1,4,NULL,'Investigation',1,0),(504,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'medication','Medication','1',1,5,NULL,'Medication',1,0),(505,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,0),(506,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'advice','Advice','1',1,7,NULL,'Advice',1,0),(507,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'history','History','1',1,8,NULL,'History',1,0),(508,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,9,NULL,'report_footer_consultation_time',1,0),(509,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'vital','Vital','0',1,15,NULL,'Vital',1,0),(510,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'referral_key','Referral','1',1,10,NULL,'Referral',1,0),(511,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'general_note','General Note','0',5,11,NULL,'General Note',1,0),(512,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'finalization_1','Finalization','0',1,13,NULL,'Finalization 1',1,0),(513,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'finalization_2','Finalization','0',1,12,NULL,'Finalization 2',1,0),(514,1,NULL,'2019-01-22 12:02:32',NULL,NULL,253,'clinical_history_2','Clinical History','0',1,14,NULL,'Clinical History 2',1,0),(515,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(516,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'physical_exam','Physical Examination','1',1,4,NULL,'Physical Examination',1,0),(517,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'investigation','Investigation','1',1,5,NULL,'Investigation Advice',1,0),(518,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'medication','Medication','1',1,6,NULL,'Medication',1,0),(519,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,0),(520,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'advice','Advice','1',1,8,NULL,'Advice',1,0),(521,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'clinical_history_1','Clinical History','1',1,3,NULL,'Clinical History',1,0),(522,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'clinical_history_2','Clinical History','0',1,13,NULL,'Clinical History 2',0,0),(523,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'finalization_1','Finalization','1',1,9,NULL,'Follow Up',0,0),(524,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(525,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'history','History','1',1,2,NULL,'History',1,0),(526,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(527,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'vital','Vital','0',1,14,NULL,'Vital',1,0),(528,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'referral_key','Referral','1',1,10,NULL,'Referral',1,0),(529,1,NULL,'2019-01-23 18:33:05',NULL,NULL,241,'general_note','General Note','0',5,15,NULL,'General Note',0,0),(530,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(531,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,0),(532,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'investigation','Investigation','1',1,3,NULL,'Investigation',1,0),(533,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'medication','Medication','1',1,4,NULL,'Medication',1,0),(534,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,0),(535,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'advice','Advice','1',1,6,NULL,'Advice',1,0),(536,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'finalization_1','Finalization','1',1,7,NULL,'Finalization 1',1,0),(537,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'finalization_2','Finalization','0',1,8,NULL,'Finalization 2',1,0),(538,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'history','History','1',1,9,NULL,'History',1,0),(539,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,10,NULL,'report_footer_consultation_time',1,0),(540,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'vital','Vital','0',1,11,NULL,'Vital',1,0),(541,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'referral_key','Referral','1',1,12,NULL,'Referral',1,0),(542,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'general_note','General Note','0',5,13,NULL,'General Note',1,0),(543,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'clinical_history_1','Clinical History','0',1,14,NULL,'Clinical History 1',1,0),(544,1,NULL,'2019-01-23 16:38:11',NULL,NULL,135,'clinical_history_2','Clinical History','0',1,15,NULL,'Clinical History 2',1,0),(545,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'clinical_history_1','Clinical History','1',1,1,NULL,'Clinical History 1',1,0),(546,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'physical_exam','Physical Examination','1',1,2,NULL,'Physical Examination',1,0),(547,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'investigation','Investigation','1',1,3,NULL,'Investigation',1,0),(548,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'diagnosis','Diagnosis','1',1,4,NULL,'Diagnosis',1,0),(549,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'medication','Medication','1',1,5,NULL,'Medication',1,0),(550,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'advice','Advice','1',1,6,NULL,'Advice',1,0),(551,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'finalization_1','Finalization','1',1,7,NULL,'Finalization 1',1,0),(552,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'clinical_history_2','Clinical History','0',1,8,NULL,'Clinical History 2',1,0),(553,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'chief_complain','Chief Complain','0',1,9,NULL,'Chief Complain',1,0),(554,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(555,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'history','History','0',1,11,NULL,'History',1,0),(556,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(557,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'vital','Vital','0',1,13,NULL,'Vital',1,0),(558,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(559,1,NULL,'2019-01-26 21:07:44',NULL,NULL,194,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(560,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(561,1,NULL,'2019-02-16 14:11:02',NULL,NULL,112,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(562,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'clinical_history_1','Clinical History','0',1,4,NULL,'Clinical History 1',1,0),(563,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'clinical_history_2','Clinical History','0',1,5,NULL,'Clinical History 2',1,0),(564,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,0),(565,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,0),(566,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'investigation','Investigation','1',1,6,NULL,'Investigation Advised',1,0),(567,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'medication','Medication','1',1,7,NULL,'Medication',1,0),(568,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'diagnosis','Diagnosis','1',1,8,NULL,'Diagnosis',1,0),(569,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'advice','Advice','1',1,9,NULL,'Advice',1,0),(570,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'finalization_1','Finalization','0',1,10,NULL,'Finalization',1,0),(571,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(572,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'history','History','1',1,2,NULL,'History',1,0),(573,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(574,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'vital','Vital','0',1,13,NULL,'Vital',1,0),(575,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(576,1,NULL,'2019-02-03 12:30:19',NULL,NULL,766,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(577,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'clinical_history_1','Clinical History','0',1,2,NULL,'Clinical History 1',1,0),(578,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'clinical_history_2','Clinical History','0',1,5,NULL,'Clinical History 2',1,0),(579,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complaint\'s',1,1),(580,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(581,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'investigation','Investigation','1',1,6,NULL,'Investigation Advised',1,1),(582,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'medication','Medication','1',1,7,NULL,'Medication',1,1),(583,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'diagnosis','Diagnosis','1',1,8,NULL,'Diagnosis',1,1),(584,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'advice','Advice','1',1,9,NULL,'Advice',1,1),(585,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'finalization_1','Finalization','0',1,10,NULL,'Finalization 1',1,0),(586,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(587,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'history','History','1',1,4,NULL,'History',1,1),(588,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'report_footer_consultation_time','report_footer_consultation_time','',4,12,NULL,'report_footer_consultation_time',1,0),(589,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'vital','Vital','0',1,13,NULL,'Vital',1,0),(590,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(591,1,NULL,'2019-02-14 10:02:17',NULL,NULL,100,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(592,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(593,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'history','History','1',1,2,NULL,'History',1,1),(594,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(595,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'investigation','Investigation','1',1,4,NULL,'Investigation',1,1),(596,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'diagnosis','Diagnosis','1',1,5,NULL,'Diagnosis',1,1),(597,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'medication','Medication','1',1,6,NULL,'Medication',1,1),(598,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'advice','Advice','1',1,7,NULL,'Advice',1,1),(599,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'clinical_history_1','Clinical History','0',1,8,NULL,'Clinical History 1',1,0),(600,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'clinical_history_2','Clinical History','0',1,9,NULL,'Clinical History 2',1,0),(601,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'finalization_1','Finalization','0',1,10,NULL,'Finalization 1',1,0),(602,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'finalization_2','Finalization','0',1,11,NULL,'Finalization 2',1,0),(603,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'report_footer_consultation_time','report_footer_consultation_time','Visiting Hours : 4Pm -7Pm\nSat-Thursday',4,12,NULL,'report_footer_consultation_time',1,0),(604,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'vital','Vital','0',1,13,NULL,'Vital',1,0),(605,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(606,1,NULL,'2019-02-17 18:17:34',NULL,NULL,131,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(607,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complains',1,1),(608,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(609,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'history','History','1',1,4,NULL,'History',1,1),(610,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'clinical_history_2','Clinical History','1',1,2,NULL,'Comorbidities',1,1),(611,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'investigation','Investigation','1',1,5,NULL,'Investigation',1,1),(612,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'medication','Medication','1',1,6,NULL,'Medication',1,1),(613,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'diagnosis','Diagnosis','1',1,7,NULL,'Diagnosis',1,1),(614,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'advice','Advice','1',1,8,NULL,'Advice',1,1),(615,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'finalization_1','Finalization','1',1,9,NULL,'Follow Up',0,1),(616,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'finalization_2','Finalization','0',1,10,NULL,'Finalization 2',1,0),(617,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'clinical_history_1','Clinical History','0',1,11,NULL,'Clinical History 1',1,0),(618,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(619,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'vital','Vital','0',1,13,NULL,'Vital',1,0),(620,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'referral_key','Referral','1',1,14,NULL,'Referral',1,1),(621,1,NULL,'2019-02-14 19:17:20',NULL,NULL,107,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(622,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'referral_key','Referral','0',1,14,NULL,'Referral',0,1),(623,1,NULL,'2019-06-04 10:08:21',NULL,NULL,137,'general_note','General Note','0',5,15,NULL,'General Note',0,1),(624,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(625,1,NULL,'2019-02-14 10:05:35',NULL,NULL,156,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(626,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'chief_complain','Chief Complain','1',1,1,NULL,'Chief Complain',1,1),(627,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'history','History','1',1,2,NULL,'History',0,1),(628,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'physical_exam','Physical Examination','1',1,3,NULL,'Physical Examination',1,1),(629,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'investigation','Investigation','1',1,4,NULL,'Investigation',1,1),(630,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'medication','Medication','1',1,5,NULL,'Medication',1,1),(631,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'diagnosis','Diagnosis','1',1,6,NULL,'Diagnosis',1,1),(632,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'advice','Advice','1',1,7,NULL,'Advice',1,1),(633,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'finalization_1','Finalization','0',1,8,NULL,'Finalization 1',1,0),(634,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'finalization_2','Finalization','0',1,9,NULL,'Finalization 2',1,0),(635,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'clinical_history_1','Clinical History','0',1,10,NULL,'Clinical History 1',1,0),(636,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'clinical_history_2','Clinical History','0',1,11,NULL,'Clinical History 2',1,0),(637,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'report_footer_consultation_time','report_footer_consultation_time','Footer Value',4,12,NULL,'report_footer_consultation_time',1,0),(638,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'vital','Vital','0',1,13,NULL,'Vital',1,0),(639,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(640,1,NULL,'2019-02-20 22:05:34',NULL,NULL,105,'general_note','General Note','0',5,15,NULL,'General Note',1,0),(641,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'referral_key','Referral','0',1,14,NULL,'Referral',1,0),(642,1,NULL,'2019-02-20 20:34:54',NULL,NULL,120,'general_note','General Note','0',5,15,NULL,'General Note',1,0);
/*!40000 ALTER TABLE `prescription_user_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_vital`
--

DROP TABLE IF EXISTS `prescription_vital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription_vital` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `in_report_serial` int(11) NOT NULL,
  `is_bold` int(11) NOT NULL,
  `vital_name` varchar(255) DEFAULT NULL,
  `vital_result` varchar(255) DEFAULT NULL,
  `vital_unit` varchar(255) DEFAULT NULL,
  `prescription_no` bigint(20) NOT NULL,
  `vital_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKholrd0yy8gvg2tnbgh8gukebw` (`prescription_no`),
  KEY `FK8yvrkn88bw20hpoutxqjqj9sj` (`vital_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_vital`
--

LOCK TABLES `prescription_vital` WRITE;
/*!40000 ALTER TABLE `prescription_vital` DISABLE KEYS */;
INSERT INTO `prescription_vital` VALUES (1,1,'MD IMRAN HOSSAIN','2019-06-03 12:41:51','MD IMRAN HOSSAIN','2019-06-04 10:06:26',0,0,'Height','12','cm',3,1),(2,1,'MD IMRAN HOSSAIN','2019-06-03 12:41:51','MD IMRAN HOSSAIN','2019-06-04 10:06:26',0,0,'Weight','212','kg',3,2),(3,1,'MD IMRAN HOSSAIN','2019-06-04 10:09:40','MD IMRAN HOSSAIN','2019-06-06 13:05:37',0,0,'Height','120','cm',3,1),(4,1,'MD IMRAN HOSSAIN','2019-06-04 10:09:40','MD IMRAN HOSSAIN','2019-06-06 13:05:37',0,0,'Weight','80','kg',3,2);
/*!40000 ALTER TABLE `prescription_vital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referal_doctor`
--

DROP TABLE IF EXISTS `referal_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referal_doctor` (
  `id` bigint(20) NOT NULL,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `doctor_signature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referal_doctor`
--

LOCK TABLES `referal_doctor` WRITE;
/*!40000 ALTER TABLE `referal_doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `referal_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setup_head`
--

DROP TABLE IF EXISTS `setup_head`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setup_head` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `data_type` int(11) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `head_name` varchar(255) NOT NULL,
  `head_name_print` varchar(255) NOT NULL,
  `is_printable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setup_head`
--

LOCK TABLES `setup_head` WRITE;
/*!40000 ALTER TABLE `setup_head` DISABLE KEYS */;
/*!40000 ALTER TABLE `setup_head` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `short_key`
--

DROP TABLE IF EXISTS `short_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `short_key` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `short_code` varchar(255) NOT NULL,
  `short_val_eng` varchar(255) NOT NULL,
  `short_val_local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `short_key`
--

LOCK TABLES `short_key` WRITE;
/*!40000 ALTER TABLE `short_key` DISABLE KEYS */;
/*!40000 ALTER TABLE `short_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signature_setup`
--

DROP TABLE IF EXISTS `signature_setup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signature_setup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `doctor_degree` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) NOT NULL,
  `doctor_no` bigint(20) DEFAULT NULL,
  `signature_title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signature_setup`
--

LOCK TABLES `signature_setup` WRITE;
/*!40000 ALTER TABLE `signature_setup` DISABLE KEYS */;
/*!40000 ALTER TABLE `signature_setup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_preferences_data`
--

DROP TABLE IF EXISTS `user_preferences_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_preferences_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `generic_name` varchar(255) DEFAULT NULL,
  `medicine_comment` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  `user_no` bigint(20) NOT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `dosage` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `form` varchar(255) DEFAULT NULL,
  `data_no` bigint(20) DEFAULT NULL,
  `relation_with_meal` varchar(255) DEFAULT NULL,
  `strength` varchar(255) DEFAULT NULL,
  `data_type` int(11) NOT NULL,
  `data_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_preferences_data`
--

LOCK TABLES `user_preferences_data` WRITE;
/*!40000 ALTER TABLE `user_preferences_data` DISABLE KEYS */;
INSERT INTO `user_preferences_data` VALUES (1,1,NULL,'2019-05-24 10:47:18',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Drank Mote water'),(2,1,NULL,'2019-05-24 10:51:12',NULL,NULL,'','','',137,'','','','',NULL,'','',6,'CBC'),(3,1,NULL,'2019-05-24 10:51:36',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'Urin test'),(4,1,NULL,'2019-05-24 11:54:27',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'Blood Test'),(20,1,NULL,'2019-06-06 12:28:27',NULL,NULL,'Paracetamol','Drank More Water','Oral',137,'Napa','1+1+1','30 Day','Beximco',NULL,'After Meal','500 Mg',4,''),(21,1,NULL,'2019-06-06 12:30:36',NULL,NULL,'','','Oral',137,'Fusid','1/2+0+0','OCCASINALY','',NULL,'After Meal','40 Mg',4,''),(7,1,NULL,'2019-06-04 10:06:07',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Back Pain'),(8,1,NULL,'2019-06-06 12:21:51',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Fever for 7 days'),(9,1,NULL,'2019-06-06 12:22:01',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Cough for 3 days'),(10,1,NULL,'2019-06-06 12:22:15',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Headache'),(11,1,NULL,'2019-06-06 12:22:28',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Blurring of vision'),(12,1,NULL,'2019-06-06 12:22:37',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Pain in left breast'),(13,1,NULL,'2019-06-06 12:22:43',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'H/O- Near Syncope'),(14,1,NULL,'2019-06-06 12:22:54',NULL,NULL,'','','',137,'','','','',NULL,'','',7,'Neck node on left side of neck'),(15,1,NULL,'2019-06-06 12:23:16',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'CBC'),(16,1,NULL,'2019-06-06 12:24:43',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'High blood sugar'),(17,1,NULL,'2019-06-06 12:24:59',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'Viral Syndrome'),(18,1,NULL,'2019-06-06 12:25:22',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'HTN'),(19,1,NULL,'2019-06-06 12:25:41',NULL,NULL,'','','',137,'','','','',NULL,'','',1,'Iron Deficiency Anemia'),(22,1,NULL,'2019-06-06 12:32:24',NULL,NULL,'','','Oral',137,'Neotack','1+0+1','CONT','',NULL,'Before Meal','150 Mg',4,''),(23,1,NULL,'2019-06-06 12:34:34',NULL,NULL,'Digoxin','','Oral',137,'Agoxin','1/2+0+0','Continual','DAR',NULL,'After Meal','0.25',4,''),(24,1,NULL,'2019-06-06 12:37:51',NULL,NULL,'Ramipril','','Oral',137,'Ramoril','0+0+1','Continual','',NULL,'After Meal','1.25',4,''),(25,1,NULL,'2019-06-06 12:39:21',NULL,NULL,'Nitroglycerin','','Oral',137,'Nitrocard','1+0+1','Continual','Usp',NULL,'After Meal','2.6 Mg',4,''),(26,1,NULL,'2019-06-06 12:40:46',NULL,NULL,'Bromzzepam','If less Sleep','Oral',137,'Bopam','0+0+1','Continual','',NULL,'After Meal','3 Mg',4,''),(27,1,NULL,'2019-06-06 12:41:55',NULL,NULL,'Glicliazide','','Oral',137,'Glucozid','0+0+1','Continual','',NULL,'After Meal','80 Mg',4,''),(28,1,NULL,'2019-06-06 12:48:57',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Please come in follow up after 7 days'),(29,1,NULL,'2019-06-06 12:49:04',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'At least 1 hour of outdoor games'),(30,1,NULL,'2019-06-06 12:49:10',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Follow up: after 10 days'),(31,1,NULL,'2019-06-06 12:49:17',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'To come with CT scan films'),(32,1,NULL,'2019-06-06 12:49:25',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Avoid dairy products,'),(33,1,NULL,'2019-06-06 12:49:30',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Use Hot Water'),(34,1,NULL,'2019-06-06 12:49:36',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'No smoking'),(35,1,NULL,'2019-06-06 13:04:49',NULL,NULL,'','','',137,'','','','',NULL,'','',8,'Follow up after 6 months');
/*!40000 ALTER TABLE `user_preferences_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vital`
--

DROP TABLE IF EXISTS `vital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vital` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_status` int(11) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `default_value` varchar(255) DEFAULT NULL,
  `doctor_no` bigint(20) NOT NULL,
  `input_type` int(11) NOT NULL DEFAULT '1',
  `is_enable` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `serial` bigint(20) NOT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKs77pagolu3bkibxya1tbie91w` (`doctor_no`,`name`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vital`
--

LOCK TABLES `vital` WRITE;
/*!40000 ALTER TABLE `vital` DISABLE KEYS */;
INSERT INTO `vital` VALUES (1,1,NULL,'2019-06-03 11:28:47',NULL,NULL,NULL,137,1,'','Height',1,'cm'),(2,1,NULL,'2019-06-03 11:29:03',NULL,NULL,NULL,137,1,'','Weight',2,'kg');
/*!40000 ALTER TABLE `vital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-06 21:15:10
