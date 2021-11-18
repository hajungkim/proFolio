-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: k5b302.p.ssafy.io    Database: profolio
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `activity_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `end_date` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `organization` varchar(255) NOT NULL,
  `start_date` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FKr8wdbwcm475hs03x515cjlftv` (`user_id`),
  CONSTRAINT `FKr8wdbwcm475hs03x515cjlftv` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'서울에 위치한 XX복지관에서 어르신을 대상으로 스마트폰 교육 봉사 진행','2017-06','스마트폰 교육 봉사','서복지관','2017-03',1),(2,'삼성 청년 SW 아카데미 5기','2021-11','삼성 청년 SW 아카데미(SSAFY)','삼성','2021-01',1),(3,'뭔가뭔가를 해서 뭔가를 배웠고 뭔가를 했습니다.','2021-02','삼성청년SW아카데미','삼성전자','2021-01',2),(6,'삼성 청년 SW 아카데미 5기\n- Java, 알고리즘, 자료구조를 학습\n- 웹 프레임워크 학습\n- 웹 서비스 개발 프로젝트 진행 중','2021-11','삼성 청년 SW 아카데미(SSAFY)','삼성','2021-01',5),(8,'코딩 집중 교육과 다양한 프로젝트를 경험함','2021-12','삼성청년 소프트웨어','삼성전자','2021-01',3),(9,'삼성SDS SW 개발 인턴','2020-08','대학생 인턴','삼성SDS','2020-07',6),(10,'삼성전자 SW 개발 인턴','2021-02','대학생 인턴','삼성전자','2021-01',6),(11,'대전 시청 대학생 인턴','2020-08','공공기관 인턴','대전시청','2020-07',6);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `awards`
--

DROP TABLE IF EXISTS `awards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `awards` (
  `awards_id` bigint NOT NULL AUTO_INCREMENT,
  `awards_date` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `name` varchar(255) NOT NULL,
  `prize` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`awards_id`),
  KEY `FKf7ks22ld4q8fl356sgwatujc3` (`user_id`),
  CONSTRAINT `FKf7ks22ld4q8fl356sgwatujc3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `awards`
--

LOCK TABLES `awards` WRITE;
/*!40000 ALTER TABLE `awards` DISABLE KEYS */;
INSERT INTO `awards` VALUES (1,'2020-09-13','2020년 삼성전자와 카카오에서 주최한 블록체인 해커톤 참가','2020 제주 블록체인 해커톤','은상',1),(2,'2021-09-10','2021년 한국 소프트웨어 협회에서 주최한 공모전 참가','2021 00해커톤','동상',1),(4,'2021-11-05','삼성에서 주최한 알고리즘 대회 은상 수상','알고리즘 대회','은상',5),(5,'2021-11-05','해커톤에서 사용자를 위한 SW 개발\n- 기획과 프론트엔드 개발 담당','해커톤','동상',5),(6,'2021-10-14','정보올림피아드에서 금상을 수상함','정보올림피아드','금상',3),(7,'2019-02-01','참가상을 수상하였습니다','창업 아이템 발표 대회','참가상',6);
/*!40000 ALTER TABLE `awards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `career`
--

DROP TABLE IF EXISTS `career`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `career` (
  `carrer_id` bigint NOT NULL AUTO_INCREMENT,
  `company` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `duty` varchar(255) NOT NULL,
  `end_date` varchar(255) NOT NULL,
  `start_date` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`carrer_id`),
  KEY `FKp68p71rciqjtwly9h9auk0vyi` (`user_id`),
  CONSTRAINT `FKp68p71rciqjtwly9h9auk0vyi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `career`
--

LOCK TABLES `career` WRITE;
/*!40000 ALTER TABLE `career` DISABLE KEYS */;
INSERT INTO `career` VALUES (1,'삼성전자','삼성전자 XX 사업부에서 인턴 활동','인턴','2020-08','2020-07',1),(2,'삼성전자','랄랄라를 하면서 열심히 일해서 돈마니마니 벌어서 퇴사했습니다.','대리','2021-02','2021-01',2),(4,'삼성전자','삼성전자 XX 사업부에서 인턴으로 근무\n- 데이터 분석 및 처리 담당','인턴','2021-03','2021-02',5),(5,'멀티캠퍼스','멀티캠퍼스에서 1년간 근무','사원','2020-12','2020-01',5),(6,'삼성전자','SW 개발','SW','2021-11','2020-03',6);
/*!40000 ALTER TABLE `career` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate` (
  `certificate_id` bigint NOT NULL AUTO_INCREMENT,
  `certified_date` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`certificate_id`),
  KEY `FKp2ure8wwndmepxyj2ey8r3lb2` (`user_id`),
  CONSTRAINT `FKp2ure8wwndmepxyj2ey8r3lb2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (1,'2021-11-23','정보처리기사',1),(2,'2021-11-11','컴퓨터활용',1),(3,'2021-10-01','SQLD',1),(4,'2021-11-01','정보처리',2),(6,'2021-11-05','정보처리기사',5),(7,'2021-11-05','SQLD',5),(8,'2021-04-14','정보처리기사',3),(9,'2021-08-20','정보처리기사',6),(10,'2020-08-21','전기기사',6);
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `education_id` bigint NOT NULL AUTO_INCREMENT,
  `admission_date` varchar(255) NOT NULL,
  `graduation` bit(1) NOT NULL,
  `graduation_date` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `minor` varchar(255) NOT NULL,
  `university` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`education_id`),
  KEY `FKaw3ebf3585a1ndgqnk6k6hosc` (`user_id`),
  CONSTRAINT `FKaw3ebf3585a1ndgqnk6k6hosc` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,'2017-03',_binary '','2021-02','소프트웨어학과','경영학과','싸피대학교',1),(2,'2021-01',_binary '','2021-11','컴퓨터공학과','-','싸피대학교',2),(4,'2021-02',_binary '','2021-09','sfdsf','sdfds','fdsfsd',8),(5,'2017-03',_binary '','2021-02','소프트웨어학과','경영학과','싸피대학교',5),(6,'2015-03',_binary '','2021-02','컴퓨터공학과','소프트웨어학과','싸피대학교',3),(7,'2014-03',_binary '','2020-02','컴퓨터공학','없음','싸피대학교',6);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foreign_lang`
--

DROP TABLE IF EXISTS `foreign_lang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foreign_lang` (
  `foreign_lang_id` bigint NOT NULL AUTO_INCREMENT,
  `certified_date` varchar(255) NOT NULL,
  `language` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `score` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`foreign_lang_id`),
  KEY `FKtmj547w4i87pv70avi0xjmj2u` (`user_id`),
  CONSTRAINT `FKtmj547w4i87pv70avi0xjmj2u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foreign_lang`
--

LOCK TABLES `foreign_lang` WRITE;
/*!40000 ALTER TABLE `foreign_lang` DISABLE KEYS */;
INSERT INTO `foreign_lang` VALUES (1,'2021-11-05','영어','TOEIC','900',1),(2,'2021-11-12','영어','OPIC','IH',1),(3,'2021-11-02','영어','toeic','900',2),(5,'2021-11-05','영어','TOEIC','900',5),(6,'2021-11-17','영어','OPIc','AL',3),(7,'2021-08-07','영어','TOEIC','900',6),(8,'2021-09-15','영어','OPIc','AL',6);
/*!40000 ALTER TABLE `foreign_lang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portfolio`
--

DROP TABLE IF EXISTS `portfolio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `portfolio` (
  `portfolio_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`),
  KEY `FKclxr2fqkko1a1kjw4pvijvej3` (`user_id`),
  CONSTRAINT `FKclxr2fqkko1a1kjw4pvijvej3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portfolio`
--

LOCK TABLES `portfolio` WRITE;
/*!40000 ALTER TABLE `portfolio` DISABLE KEYS */;
INSERT INTO `portfolio` VALUES (1,'포트폴리오 1','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/2a9a2b8e-eac3-4902-8afa-906e9942f2bc%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4%201',1),(11,'dwqe','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/9000b608-2600-4953-91e5-90f777eae6dddwqe',9),(14,'123','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/73a9f90b-f391-407c-997f-38b8d5e96be2123',1),(17,'23132','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/6b83a40d-8848-4c4e-aadd-64eedb16235c23132',1),(32,'내 포폴','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/9f5b7f3b-3422-49b3-ae13-b5f3895fd400%EB%82%B4%20%ED%8F%AC%ED%8F%B4',1),(43,'33','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/37827e88-066f-4312-a5d6-6fb59a04b33033',7),(44,'3','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/c85b1cec-9abd-458d-a3a4-66ef9bc308c43',7),(49,'333','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/66b2a838-a4ed-4f0a-ab81-83d512c6350a333',9),(50,'ㅈㄷㅈ','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/9e4e7367-f174-4010-b173-dc592a24b2d6%E3%85%88%E3%84%B7%E3%85%88',9),(61,'포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/c09d1041-7a59-4469-997f-6386366fd31c%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',5),(62,'포트폴리오 2','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/2aece898-6fd2-45ec-a888-ef9e969a9abd%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4%202',5),(64,'1116포폴','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/d4d3b2c0-d0ef-4c26-93d8-9f1b36cef08a1116%ED%8F%AC%ED%8F%B4',2),(65,'첫번째 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/8cfe8a19-af78-4bee-8a7e-17e158fb94b4%EC%B2%AB%EB%B2%88%EC%A7%B8%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',6),(66,'포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/9d1617ee-a3e4-4786-8e3b-4c784182e84a%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',5),(67,'제출용','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/edad7fc4-d123-4367-9c90-92c9edd66f5f%EC%A0%9C%EC%B6%9C%EC%9A%A9',5),(69,'제출용 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/426828f7-608c-4cdb-a6fc-e469f7a0fefd%EC%A0%9C%EC%B6%9C%EC%9A%A9%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',5),(70,'두번째 포트폴리오(모든 이력 포함)','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/fd720339-48e4-4cec-ab39-8c5c73581b97%EB%91%90%EB%B2%88%EC%A7%B8%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4%28%EB%AA%A8%EB%93%A0%20%EC%9D%B4%EB%A0%A5%20%ED%8F%AC%ED%95%A8%29',6),(71,'FE 개발 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/8f0147b4-9a20-4443-8f44-6b044221ce96FE%20%EA%B0%9C%EB%B0%9C%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',6),(72,'1','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/eb8c8082-8434-40ba-a6b3-be87bc61d3671',7),(73,'20211117_포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/d59939ec-de56-4720-b52c-cf3e777ca21720211117_%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',6),(74,'rer3','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/60879908-fcd1-4a1d-816a-375c8b1ca354rer3',5),(76,'나의 소중한 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/f86ff174-3da8-448e-82fb-1aa6090e5b65%EB%82%98%EC%9D%98%20%EC%86%8C%EC%A4%91%ED%95%9C%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',3),(77,'삼성전자 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/0d94e966-0d82-48b2-9d74-c3030a86514f%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',3),(78,'211118_오전 포트폴리오','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/2ad106d8-0585-4e43-b615-9bafdf6d1c58211118_%EC%98%A4%EC%A0%84%20%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4',6);
/*!40000 ALTER TABLE `portfolio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `end_date` varchar(255) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `member_cnt` int NOT NULL,
  `role` varchar(255) NOT NULL,
  `start_date` varchar(255) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `technology_stack` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKo06v2e9kuapcugnyhttqa1vpt` (`user_id`),
  CONSTRAINT `FKo06v2e9kuapcugnyhttqa1vpt` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'1. 사용자가 이력서를 작성하면 포트폴리오 템플릿에 맞춰 변환해주는 기능\n2. 변환된 포트폴리오 편집 기능 제공\n3. 취업용 사진 합성 기능 제공\n\n- 삼성 청년 SW 아카데미 자율 프로젝트\n- 기획부터 설계, 백엔드 개발 담당','2021-11','https://github.com/proFolio',6,'팀원','2021-10','IT 개발자를 위한 포트폴리오 생성 사이트','Springboot, Vue, MySQL','proFolio',1),(2,'1. 공공데이터를 활용해 부동산 실거래가 정보를 시각화하여 제공\n2. 매물 근처에 사용가능한 시설 및 병원 정보를 제공\n\n- 삼성 청년 SW 아카데미 교육 기간 동안 배운 웹 개발 지식을 적용해 구현한 웹 사이트\n- UI 디자인, 게시판 기능 구현, REST API 개발\n- 카카오 API를 활용해 매물 이미지와 360도 뷰를 제공','2021-05','https://github.com/happyhouse',2,'팀원','2021-05','부동산 실거래가 정보 제공 웹 사이트','Springboot, Vue, MySQL','HaHa - HappyHouse',1),(3,'포트폴리오를 생성해주는 사이트를 만들었다. 포트폴리오를 생성해주는 사이트를 만들었다. 포트폴리오를 생성해주는 사이트를 만들었다.','2021-02','github.com/profolio',5,'백엔드','2021-01','포트폴리오를 생성해주는 사이트를 만들었다.','Spring, Vue.js','프로폴리오',2),(5,'1. 공공데이터를 활용해 부동산 실거래가 정보를 시각화하여 제공\n2. 매물 근처에 사용가능한 시설 및 병원 정보를 제공\n\n- 삼성 청년 SW 아카데미 교육 기간 동안 배운 웹 개발 지식을 적용해 구현한 웹 사이트\n- UI 디자인, 게시판 기능 구현, REST API 개발\n- 카카오 API를 활용해 매물 이미지와 360도 뷰를 제공','2021-06','https://github.com/happyhouse',2,'팀원','2021-05','부동산 실거래가 정보 제공 웹 사이트','Springboot, Vue, MySQL','HaHa - HappyHouse',5),(6,'1. 사용자가 이력서를 작성하면 포트폴리오 템플릿에 맞춰 변환해주는 기능\n2. 변환된 포트폴리오 편집 기능 제공\n3. 취업용 사진 합성 기능 제공\n\n- 삼성 청년 SW 아카데미 자율 프로젝트\n- 기획부터 설계, 백엔드 개발 담당','2021-11','https://github.com/proFolio',6,'팀원','2021-10','IT 개발자를 위한 포트폴리오 생성 사이트','Springboot, Vue, MySQL','proFolio',5),(7,'AI의 이미지캡셔닝과 빅데이터를 활용한 프로젝트','2021-09','lab.ssafy#?!@.com',5,'BE','2021-08','AI와 빅데이터를 활용한 프로젝트','Python, React.js, Spring boot, Docker, etc','특화프로젝트',3),(8,'개발자를 위한 포트폴리오 사이트!!','2021-11','https://k5b302.p.ssafy.io',5,'FE','2021-10','개발자를 위한 포트폴리오 사이트!!','Vue.js, Spring boot, MySql, Django, etc','ProFolio',3),(9,'반응형 UI  중심 Single Page  Application 설계 및 구현\n음성인식(Web Speech API)을 적용하여 레시피 제어 구현\n','2021-08','https://github.com/..../licipe',4,'FE','2021-07','음성인식 레시피 서비스','HTML,CSS,JavaScript, React, Redux','Licipe',6),(10,'- 자율주행 기능 개발: 특정 지점까지 최단 거리 탐색 및 주행 알고리즘 구현\n- 로봇과 가전 간 통신을 위한 UDP 통신 기능 구현\n- Single Page Application 설계 및 구현 \n- 웹소켓을 사용하여 웹과 시뮬레이터 간 통신 구현\n- 웹 서비스 배포(Docker Container사용, Nginx)','2021-10','https://github.com/.../banji',6,'FE, 자율주행','2021-09','반려견을 기르는 가구를 위한 스마트 홈 서비스','ROS2, Python, HTML, CSS, JavaScript, VueJS, NodeJS, Nginx, Docker','반지(반려견지켜줘)',6),(11,'- Single Page  Application 설계 및 구현\n- 인공지능 이미지 합성을 사용한 취업 사진 합성 서비스 구현','2021-11','https://github.com/.../proFolio',5,'FE','2021-10','IT 입문자들을 위한 포트폴리오 작성 및 변환 서비스','HTML, CSS, JavaScript, VueJS, Vuex, Python, PyTorch','proFolio',6);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology_stack`
--

DROP TABLE IF EXISTS `technology_stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technology_stack` (
  `technology_stack_id` bigint NOT NULL AUTO_INCREMENT,
  `kind` int NOT NULL,
  `level` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`technology_stack_id`),
  KEY `FKcjlh4k4sbhef9ldsh0g7r7r09` (`user_id`),
  CONSTRAINT `FKcjlh4k4sbhef9ldsh0g7r7r09` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology_stack`
--

LOCK TABLES `technology_stack` WRITE;
/*!40000 ALTER TABLE `technology_stack` DISABLE KEYS */;
INSERT INTO `technology_stack` VALUES (1,2,'4','Git',1),(2,1,'4','JAVA',1),(3,1,'1','Python',1),(4,3,'3','Springboot',1),(5,3,'2','Spring',2),(6,1,'4','JAVA',2),(9,1,'1','Python',5),(10,1,'4','JAVA',5),(11,2,'4','Git',5),(12,2,'4','JIRA',5),(13,3,'3','Springboot',5),(14,3,'5','Spring',3),(15,1,'4','Python',3),(16,1,'4','JAVA',3),(17,2,'3','Docker',3),(18,1,'4','JavaScript',6),(19,1,'4','Python',6),(20,3,'3','React',6),(21,1,'2','Jira',6),(22,3,'3','Vue',6),(23,1,'3','Git',6);
/*!40000 ALTER TABLE `technology_stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `github_id` varchar(255) DEFAULT NULL,
  `join_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profile_path` varchar(500) DEFAULT NULL,
  `social_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'안녕하세요!\n현재 삼성 청년 SW 아카데미(SSAFY) 5기로 프로젝트를 진행하고 있습니다.\n새로운 기술에 거부감 없이 적극적으로 공부하며 프로젝트를 수행하며 성장하고 있습니다.🙂','profolio.ssafy@gmail.com','kimssafy','2021-11-14 06:36:23','김싸피','010-1234-5678','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/fba71f33-91ab-44cb-95d4-101893992fdeoutput.jpg','GOOGLE'),(2,'안녕하세요!\n백엔드 개발자를 목표로 하는 김하정입니다.\n항상 성장성장 열심열심 하려구요~~','haha@gmail.com','hajungkim','2021-11-14 06:53:42','하정','010-1212-3434','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/e64707db-746c-49ed-a7e5-86b08cf1dc95mimoticon.jpg','GOOGLE'),(3,'안녕하세요. 프론트엔드 개발자를 꿈꾸는\r\n김싸피 지원자입니다.\r\n매사에 긍정적이고 적극적으로 임하겠습니다.\r\n잘 부탁드립니다. *^^*\r\n','ssafy0011@ssafy.com','ssafylove@github.com','2021-11-14 10:07:37','김싸피','010-0000-0000','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/ff5b4d7a-c194-4e99-ae66-c3405fcc7f6b%ED%99%94%EB%A9%B4%EC%A6%9D%EB%AA%85%EC%82%AC%EC%A7%84.jpg','GOOGLE'),(4,'11','lee@gmail.com','11','2021-11-14 23:52:36','이수정','111','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/8e680fc4-b419-459c-9074-3312567486627167faa8b9e6327df4df130c8b8cc7d850cc1484f8eba0b62f51482dfe7103f8.jfif','GOOGLE'),(5,'안녕하세요!\n현재 삼성 청년 SW 아카데미 (SSAFY) 5기로 프로젝트를 진행하고 있습니다.\n새로운 기술에 거부감 없이 적극적으로 공부하며 프로젝트를 수행하며 성장하고 있습니다.😀','010-1234-5678','ssafykim','2021-11-14 23:58:28','김싸피','010-1234-5678','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/29fa8bb0-8313-459e-89d7-f1fb215f6454programmer.png','GITHUB'),(6,'더 열심히 일하겠습니다','ssafyhwang@ssafy.com','github.com/ssafyhwang','2021-11-15 00:50:31','황싸피','010-0000-0000','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/4167781d-bef7-4cef-ad9a-e3a57dedf1da%E1%84%92%E1%85%AA%E1%86%BC%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%86%E1%85%B5%E1%86%AB.jpg','GOOGLE'),(7,'안녕안녕','wls@gmail.com','aaa.github','2021-11-15 01:07:10','hye','010-1111-1111','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/85ebb185-4542-4ef8-8d1e-6f52576aaf96%EB%9D%BC%EC%9D%B4%EC%96%B8.PNG','GOOGLE'),(8,'1111','sj@naver.com','111','2021-11-15 08:19:35','이수정','010-0000-0000','https://ssl.pstatic.net/static/pwe/address/img_profile.png','NAVER'),(9,'ㅈㄷㅈ','sj@gmail.com','ㄷㅈㄱ','2021-11-15 08:32:51','su jeong lee','ㄱㄷㅈ','https://profolio-s3.s3.ap-northeast-2.amazonaws.com/5cb2b36c-f1ca-46ab-aa33-b85e9bdb9e2f917ed6f38cc0beeda22294ecb7b48d9b.jpg','GOOGLE');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'profolio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 14:53:45
