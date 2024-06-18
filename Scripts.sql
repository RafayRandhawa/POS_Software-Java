CREATE DATABASE  IF NOT EXISTS `onlinedeliverysystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `onlinedeliverysystem`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: onlinedeliverysystem
-- ------------------------------------------------------
-- Server version	8.0.33
 
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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(25) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `emailAddress` varchar(25) NOT NULL,
  `paymentMethod` varchar(15) NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=1024 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1000,'John Smith','123 Main St, New York','555-1234','john.smith@example.com','credit card'),(1001,'Samantha Johnson','456 Market St, Los Angeles','555-5678','samantha.johnson@example.','cash'),(1002,'Michael Lee','789 Dairy Dr, San Francisco','555-9012','michael.lee@example.com','debit card'),(1003,'Amanda Wilson','321 Rice Ave, Houston','555-3456','amanda.wilson@example.com','cash'),(1004,'David Nguyen','555 Bakery Blvd, Miami','555-7890','david.nguyen@example.com','credit card'),(1005,'Jennifer Brown','777 Seafood St, Seattle','555-2345','jennifer.brown@example.co','cash'),(1006,'Brian Davis','999 Pasta Ave, Chicago','555-6789','brian.davis@example.com','debit card'),(1007,'Karen Taylor','111 Fishermen Dr, Boston','555-0123','karen.taylor@example.com','cash'),(1008,'Daniel Martinez','222 Meatpacking St, San Diego','555-4567','daniel.martinez@example.c','credit card'),(1009,'Jessica Robinson','888 Market St, San Francisco','555-8901','jessica.robinson@example.','debit card'),(1010,'James Brown','555 Baker St, Chicago','555-2345','james.brown@example.com','cash'),(1011,'Kimberly Lee','777 Sushi Way, Los Angeles','555-6789','kimberly.lee@example.com','credit card'),(1012,'Christopher Johnson','123 Main St, New York, NY','555-0123','christopher.johnson@examp','debit card'),(1013,'Ashley Davis','456 Elm St, Boston, MA','555-4567','ashley.davis@example.com','cash'),(1014,'Matthew Martinez','789 Pine St, San Francisco, CA','555-8901','matthew.martinez@example.','credit card'),(1015,'Megan Wilson','456 Oak St, Chicago, IL','555-2345','megan.wilson@example.com','debit card'),(1016,'Ryan Nguyen','246 Market St, Seattle, WA','555-6789','ryan.nguyen@example.com','cash'),(1017,'Lauren Taylor','369 Maple St, Los Angeles, CA','555-0123','lauren.taylor@example.com','credit card'),(1018,'Brandon Brown','135 Cherry St, Philadelphia, PA','555-4567','brandon.brown@example.com','debit card'),(1019,'Emily Lee','246 Elm St, Miami, FL','555-8901','emily.lee@example.com','cash'),(1020,'Sarah Johnson','987 Oak St, San Diego, CA','555-234-5678','sarah.johnson@example.com','PayPal'),(1021,'Michael Lee','753 Maple St, Denver, CO','555-345-6789','michael.lee@example.com','Cash on Deliver'),(1022,'Karen Davis','147 Main St, Austin, TX','555-456-7890','karen.davis@example.com','Credit Card'),(1023,'James Wilson','369 Oak St, San Francisco, CA','555-567-8901','james.wilson@example.com','PayPal');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onlineorders`
--

DROP TABLE IF EXISTS `onlineorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `onlineorders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `orderDate` date NOT NULL,
  `itemsOrdered` varchar(20) NOT NULL,
  `numberOfItems` int NOT NULL,
  `deliveryDate` date NOT NULL,
  `address` varchar(45) NOT NULL,
  `orderStatus` varchar(10) NOT NULL,
  `orderTotal` double NOT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onlineorders`
--

LOCK TABLES `onlineorders` WRITE;
/*!40000 ALTER TABLE `onlineorders` DISABLE KEYS */;
INSERT INTO `onlineorders` VALUES (1,1000,'2023-04-01','pizza, pasta, salad',3,'2023-04-03','123 Main St, New York','delivered',25.99),(2,1001,'2023-04-02','burger, fries, soda',3,'2023-04-03','456 Market St, Los Angeles','delivered',12.5),(3,1002,'2023-04-03','sandwich, chips, dri',3,'2023-04-04','789 Dairy Dr, San Francisco','delivered',8.75),(4,1003,'2023-04-04','sushi, miso soup, ed',3,'2023-04-05','321 Rice Ave, Houston','delivered',32.99),(5,1004,'2023-04-05','tacos, burrito',2,'2023-04-07','555 Bakery Blvd, Miami','cancelled',18.5),(6,1005,'2023-04-06','pad thai, spring rol',3,'2023-04-08','777 Seafood St, Seattle','delivered',22.75),(7,1006,'2023-04-07','pizza, wings',2,'2023-04-09','999 Pasta Ave, Chicago','delivered',29.99),(8,1007,'2023-04-08','ramen, gyoza, seawee',3,'2023-04-11','111 Fishermen Dr, Boston','pending',24.5),(9,1008,'2023-04-09','fried chicken, coles',3,'2023-04-12','222 Meatpacking St, San Diego','delivered',17.99),(10,1009,'2023-04-10','steak, baked potato,',3,'2023-04-13','888 Market St, San Francisco','delivered',48.75),(11,1010,'2023-04-11','pizza, garlic bread,',3,'2023-04-14','555 Baker St, Chicago','delivered',18.99),(12,1011,'2023-04-12','sushi, seaweed salad',3,'2023-04-15','777 Sushi Way, Los Angeles','delivered',26.5),(13,1012,'2023-04-01','Pizza, Burger, Fries',3,'2023-04-03','123 Main St, New York, NY','Delivered',24.99),(14,1013,'2023-04-01','Steak, Salad',2,'2023-04-04','456 Elm St, Boston, MA','Pending',32.5),(15,1014,'2023-04-02','Sushi, Edamame',2,'2023-04-06','789 Pine St, San Francisco, CA','Delivered',18.75),(16,1015,'2023-04-02','Fried Chicken',1,'2023-04-03','456 Oak St, Chicago, IL','Delivered',8.99),(17,1016,'2023-04-03','Pad Thai, Spring Rol',2,'2023-04-07','246 Market St, Seattle, WA','Cancelled',21.5),(18,1017,'2023-04-03','Fish Tacos, Guacamol',2,'2023-04-05','369 Maple St, Los Angeles, CA','Delivered',19.99),(19,1018,'2023-04-04','Chicken Parmesan',1,'2023-04-06','135 Cherry St, Philadelphia, PA','Delivered',14.5),(20,1019,'2023-04-04','Margherita Pizza',1,'2023-04-05','246 Elm St, Miami, FL','Pending',10.99),(21,1020,'2023-04-05','Lobster Roll',1,'2023-04-07','987 Oak St, San Diego, CA','Delivered',22.99),(22,1021,'2023-04-05','BBQ Ribs, Coleslaw',2,'2023-04-08','753 Maple St, Denver, CO','Delivered',28.5),(23,1022,'2023-04-06','Chicken Caesar Salad',1,'2023-04-07','147 Main St, Austin, TX','Cancelled',9.75),(24,1023,'2023-04-06','California Roll',1,'2023-04-08','369 Oak St, San Francisco, CA','Delivered',12.5);
/*!40000 ALTER TABLE `onlineorders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 18:46:43
CREATE DATABASE  IF NOT EXISTS `employees` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `employees`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employees
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `cashierdetails`
--

DROP TABLE IF EXISTS `cashierdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashierdetails` (
  `CashierCode` int NOT NULL AUTO_INCREMENT,
  `CashierName` varchar(45) NOT NULL,
  `JoiningDate` date NOT NULL,
  `ShiftStartTime` time NOT NULL,
  `ShiftEndTime` time NOT NULL,
  `TotNoOfHoursWorked` int NOT NULL,
  `EmploymentStatus` varchar(45) NOT NULL DEFAULT 'Current',
  PRIMARY KEY (`CashierCode`)
) ENGINE=InnoDB AUTO_INCREMENT=1015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashierdetails`
--

LOCK TABLES `cashierdetails` WRITE;
/*!40000 ALTER TABLE `cashierdetails` DISABLE KEYS */;
INSERT INTO `cashierdetails` VALUES (1001,'John','2021-05-10','08:00:00','16:00:00',1096,'Current'),(1002,'Sarah','2022-01-03','16:00:00','00:00:00',464,'Former'),(1003,'Michael','2023-06-15','08:00:00','16:00:00',56,'Current'),(1004,'Emily','2022-11-28','16:00:00','00:00:00',96,'Former'),(1005,'David','2021-09-05','08:00:00','16:00:00',596,'Former'),(1006,'Samantha','2023-03-20','16:00:00','00:00:00',24,'Current'),(1007,'Robert','2021-12-01','08:00:00','16:00:00',508,'Current'),(1008,'Nicole','2023-04-21','16:00:00','00:00:00',8,'Current'),(1009,'Adam','2022-10-12','08:00:00','16:00:00',312,'Current'),(1010,'Grace','2022-09-03','16:00:00','00:00:00',232,'Current'),(1011,'Tyler','2023-05-01','08:00:00','16:00:00',16,'Current'),(1012,'Olivia','2022-02-22','16:00:00','00:00:00',426,'Current'),(1014,'Aiman','2023-04-30','08:00:00','16:00:00',0,'Former');
/*!40000 ALTER TABLE `cashierdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashierlogininfo`
--

DROP TABLE IF EXISTS `cashierlogininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashierlogininfo` (
  `CashierID` int NOT NULL AUTO_INCREMENT,
  `CashierCode` int NOT NULL,
  `CashierName` varchar(45) NOT NULL,
  `CashierPassword` varchar(25) NOT NULL,
  PRIMARY KEY (`CashierID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashierlogininfo`
--

LOCK TABLES `cashierlogininfo` WRITE;
/*!40000 ALTER TABLE `cashierlogininfo` DISABLE KEYS */;
INSERT INTO `cashierlogininfo` VALUES (1,1001,'John','pass1234'),(3,1003,'Michael','secret'),(6,1006,'Samantha','p@ssword'),(7,1007,'Robert','1234pass'),(8,1008,'Nicole','abc123'),(9,1009,'Adam','mysecret'),(10,1010,'Grace','letmein'),(11,1011,'Tyler','sunshine'),(12,1012,'Olivia','iloveyou');
/*!40000 ALTER TABLE `cashierlogininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashiersales`
--

DROP TABLE IF EXISTS `cashiersales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cashiersales` (
  `SalesID` int NOT NULL AUTO_INCREMENT,
  `CashierCode` int NOT NULL,
  `SaleDate` date NOT NULL,
  `SaleTime` time NOT NULL,
  `Amount` double NOT NULL,
  `NoOfItems` int NOT NULL,
  `PaymentMethod` varchar(45) NOT NULL,
  PRIMARY KEY (`SalesID`),
  UNIQUE KEY `SalesID_UNIQUE` (`SalesID`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashiersales`
--

LOCK TABLES `cashiersales` WRITE;
/*!40000 ALTER TABLE `cashiersales` DISABLE KEYS */;
INSERT INTO `cashiersales` VALUES (109,1011,'2021-08-05','14:55:20',9647.5,50,'Cash'),(121,1005,'2023-03-04','08:44:16',1737.47,138,'Card (Visa)'),(127,1001,'2020-03-14','11:15:20',19346.01,56,'Card (Master)'),(165,1009,'2021-11-18','13:02:52',15689.21,56,'Card (Credit)'),(167,1012,'2021-05-10','11:32:57',6479.28,60,'Card (Credit)'),(184,1004,'2021-07-09','15:50:05',31210.45,121,'Card (Master)'),(198,1009,'2023-02-02','13:11:19',5917.03,67,'Card (Visa)'),(222,1005,'2021-06-22','08:11:45',1716.13,104,'Card (Visa)'),(235,1005,'2020-10-29','12:40:47',18505.31,18,'Cash'),(257,1006,'2019-09-19','13:00:10',8547.32,45,'Cash'),(266,1006,'2022-08-01','17:55:00',14851,91,'Card (Visa)'),(272,1005,'2021-11-28','17:15:58',1425.18,77,'Card (Master)'),(276,1003,'2022-01-13','17:07:42',10229.83,68,'Card (Master)'),(322,1006,'2022-11-15','14:03:48',2896.67,49,'Cash'),(338,1002,'2022-02-04','16:36:05',26281.22,92,'Cash'),(364,1002,'2023-01-15','13:27:46',3419.78,95,'Card (Credit)'),(366,1002,'2019-06-09','08:20:45',13879.37,97,'Card (Credit)'),(371,1003,'2020-10-16','12:45:10',13056.3,61,'Cash'),(419,1009,'2022-06-22','18:10:20',2960,4,'Cash'),(431,1009,'2021-02-03','18:20:10',5465.79,38,'Cash'),(443,1004,'2021-12-03','12:22:51',13238.21,128,'Card (Credit)'),(453,1004,'2021-08-23','19:23:18',11676.89,69,'Cash'),(467,1010,'2019-12-28','08:08:24',8691.59,79,'Card (Visa)'),(484,1010,'2021-06-22','15:47:33',25863.63,28,'Cash'),(489,1004,'2022-11-18','10:25:15',11420.99,24,'Card (Visa)'),(503,1009,'2022-03-24','13:14:37',14350.37,50,'Card (Credit)'),(509,1001,'2021-03-17','10:57:24',23783.47,118,'Card (Master)'),(534,1007,'2022-08-19','16:04:37',26871.94,98,'Card (Visa)'),(543,1008,'2022-06-28','12:47:30',30917.25,112,'Card (Credit)'),(557,1002,'2021-11-08','18:16:10',20263.39,94,'Card (Master)'),(563,1001,'2023-02-25','11:25:15',13876.2,78,'Card (Visa)'),(602,1003,'2021-03-17','17:52:26',3516.64,139,'Card (Visa)'),(603,1008,'2021-08-06','10:57:35',24690.51,71,'Card (Credit)'),(620,1012,'2022-09-10','15:49:38',11755.23,54,'Card (Credit)'),(625,1006,'2023-03-11','09:38:50',13964.62,54,'Card (Master)'),(627,1007,'2022-03-05','14:10:45',11064.6,76,'Card (Master)'),(674,1007,'2023-02-14','09:33:55',13998.55,73,'Card (Master)'),(689,1008,'2020-10-06','12:56:34',6202.67,82,'Card (Master)'),(698,1005,'2019-11-23','10:30:35',5274.8,20,'Cash'),(747,1012,'2022-07-28','18:30:59',8992.92,32,'Cash'),(766,1012,'2021-11-23','16:33:00',11687.7,37,'Card (Credit)'),(776,1001,'2019-10-31','14:24:41',26854.24,57,'Cash'),(779,1003,'2021-09-10','16:18:37',9734.25,61,'Cash'),(782,1007,'2023-03-15','09:32:18',738.24,137,'Card (Visa)'),(788,1003,'2019-08-31','17:35:00',2553.2,7,'Cash'),(789,1010,'2021-02-28','15:48:20',13250.46,111,'Cash'),(794,1006,'2022-08-03','19:06:58',23208.81,141,'Cash'),(820,1002,'2022-04-28','09:10:30',23375.4,112,'Card (Credit)'),(845,1001,'2022-09-30','16:19:12',819.34,135,'Card (Visa)'),(870,1001,'2022-07-02','14:51:56',29932.48,120,'Cash'),(875,1007,'2023-04-24','10:20:15',1840.52,73,'Card (Master)'),(883,1005,'2020-05-30','15:12:40',23499.1,140,'Card (Credit)'),(901,1011,'2022-03-09','10:05:38',4829.19,143,'Cash'),(904,1010,'2022-01-07','10:40:50',17500.9,63,'Card (Visa)'),(973,1008,'2020-04-08','13:22:30',854.1,2,'Cash'),(991,1003,'2022-02-19','08:45:23',5808.41,142,'Cash'),(992,1001,'2023-04-29','01:02:22',0,1,'Card (Credit)'),(993,1001,'2023-04-29','01:03:26',9.870000000000001,1,'Card (Credit)'),(994,1001,'2023-04-29','01:05:16',2.9699999999999998,1,'Card (Master)'),(995,1001,'2023-04-30','18:17:03',2.9699999999999998,1,'Card (Credit)'),(996,1001,'2023-04-30','18:18:35',5.96,2,'Card (Credit)'),(997,1001,'2023-04-30','18:19:25',11.940000000000001,2,'Card (Debit)'),(998,1001,'2023-05-10','02:33:19',2.9699999999999998,1,'Card (Credit)'),(999,1001,'2023-05-10','02:35:47',1.98,1,'Cash'),(1000,1001,'2023-05-10','02:44:54',13.16,1,'Cash'),(1001,1001,'2023-05-10','02:48:25',6.58,1,'Cash');
/*!40000 ALTER TABLE `cashiersales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managerlogininfo`
--

DROP TABLE IF EXISTS `managerlogininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managerlogininfo` (
  `ManagerID` int NOT NULL AUTO_INCREMENT,
  `ManagerName` varchar(45) NOT NULL,
  `MUsername` varchar(45) NOT NULL,
  `MPassword` varchar(45) NOT NULL,
  PRIMARY KEY (`ManagerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managerlogininfo`
--

LOCK TABLES `managerlogininfo` WRITE;
/*!40000 ALTER TABLE `managerlogininfo` DISABLE KEYS */;
INSERT INTO `managerlogininfo` VALUES (1,'John Smith','jsmith','newpass123'),(2,'Sarah Lee','slee','newpassword'),(3,'Michael Kim','mkim','newsecret');
/*!40000 ALTER TABLE `managerlogininfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 18:46:43
CREATE DATABASE  IF NOT EXISTS `inventory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inventory`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `inventorylevels`
--

DROP TABLE IF EXISTS `inventorylevels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventorylevels` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(45) NOT NULL,
  `MaxStockLevel` int NOT NULL,
  `MinStockLevel` int NOT NULL,
  `CurrentstockLevel` int NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventorylevels`
--

LOCK TABLES `inventorylevels` WRITE;
/*!40000 ALTER TABLE `inventorylevels` DISABLE KEYS */;
INSERT INTO `inventorylevels` VALUES (1,'Bananas',100,20,59),(2,'Apples',150,30,97),(3,'Milk',200,50,144),(4,'Bread',100,20,60),(5,'Eggs',300,100,193),(6,'Cheese',200,50,100),(7,'Chicken',100,20,72),(8,'Beef',150,30,105),(9,'Fish',100,20,60),(10,'Rice',300,100,200),(11,'Pasta',200,50,137),(12,'Tomatoes',100,20,80),(13,'Potatoes',150,30,120),(14,'Onions',100,20,60),(15,'Carrots',200,50,150),(16,'Lettuce',100,20,70),(17,'Cucumbers',150,30,120),(18,'Oranges',100,20,60),(19,'Grapes',200,50,150),(20,'Strawberries',100,20,80),(21,'Canned Tomatoes',150,30,120),(22,'Ground Beef',100,20,60),(23,'Frozen Pizza',200,50,150),(24,'Orange Juice',100,20,80),(25,'Yogurt',150,30,120),(26,'Sour Cream',100,20,60),(27,'Salad Dressing',200,50,150),(28,'Chips',100,20,80),(29,'Soda',150,30,120),(30,'Ice Cream',100,20,60),(31,'Ketchup',200,50,150),(32,'Mustard',100,20,80),(33,'Brown Rice',100,10,50),(34,'Whole Wheat Bread',150,15,75),(35,'Salmon Fillet',80,8,40),(36,'Spinach',200,20,100),(37,'Avocado',120,12,60),(38,'Sausages',100,10,35),(39,'Honey',200,20,100),(40,'Almond Milk',150,15,75),(41,'Blueberries',90,9,45),(42,'Cottage Cheese',120,12,60),(43,'Tuna',80,8,40),(44,'Green Beans',200,20,100),(45,'Broccoli',150,15,75),(46,'Cauliflower',100,10,50),(47,'Sweet Potatoes',120,12,60),(48,'Pineapple',90,9,45),(49,'Peanut Butter',200,20,100),(50,'Jelly',150,15,75),(51,'Brussels Sprouts',100,30,70),(52,'Raspberries',700,150,82),(53,'Pita Bread',400,100,25),(54,'Chocolate Cookies',400,100,500),(55,'Almond Cookies',150,25,22),(56,'Almonds',200,100,150),(57,'Quinoa',300,150,256),(58,'Blue Cheese',250,100,300),(59,'Baby Carrots',200,100,129),(60,'Sourdough Bread',350,200,220);
/*!40000 ALTER TABLE `inventorylevels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventoryprods`
--

DROP TABLE IF EXISTS `inventoryprods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventoryprods` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(45) NOT NULL,
  `Price` varchar(45) NOT NULL,
  `Quantity` varchar(45) NOT NULL,
  `ExpiryDate` varchar(45) NOT NULL,
  `SupplierName` varchar(45) NOT NULL,
  `ExpirationStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventoryprods`
--

LOCK TABLES `inventoryprods` WRITE;
/*!40000 ALTER TABLE `inventoryprods` DISABLE KEYS */;
INSERT INTO `inventoryprods` VALUES (1,'Bananas','0.99','100','2023-05-01','Fresh Fruits','Expired'),(2,'Apples','1.49','80','2023-05-03','Fresh Fruits','Expired'),(3,'Milk','3.29','50','2023-05-02','Dairy Co.','Expired'),(4,'Bread','2.99','60','2023-05-04','Bakery Co.','Expired'),(5,'Eggs','2.49','120','2023-05-05','Egg Producers',NULL),(6,'Cheese','5.99','40','2023-05-10','Dairy Co.',NULL),(7,'Chicken','8.99','20','2023-05-15','Poultry Farms',NULL),(8,'Beef','12.99','30','2023-05-20','Meat Co.',NULL),(9,'Fish','10.99','25','2023-05-25','Fishermen Co.',NULL),(10,'Rice','3.99','90','2024-05-01','Rice Co.',NULL),(11,'Pasta','2.49','100','2024-05-01','Pasta Co.',NULL),(12,'Tomatoes','1.99','70','2023-05-03','Fresh Veggies','Expired'),(13,'Potatoes','0.99','110','2023-05-01','Fresh Veggies','Expired'),(14,'Onions','0.79','120','2023-05-03','Fresh Veggies','Expired'),(15,'Carrots','0.89','100','2023-05-04','Fresh Veggies','Expired'),(16,'Lettuce','1.29','60','2023-05-06','Fresh Veggies',NULL),(17,'Cucumbers','0.99','70','2023-05-07','Fresh Veggies',NULL),(18,'Oranges','1.69','50','2023-05-10','Fresh Fruits',NULL),(19,'Grapes','3.99','30','2023-05-12','Fresh Fruits',NULL),(20,'Strawberries','4.49','25','2023-05-15','Fresh Fruits',NULL),(21,'Canned Tomatoes','1.99','50','2024-05-01','Canned Foods',NULL),(22,'Ground Beef','7.99','35','2023-05-06','Meat Co.',NULL),(23,'Frozen Pizza','5.99','40','2023-05-07','Dairy Co.',NULL),(24,'Orange Juice','3.49','60','2023-05-09','Fresh Fruits',NULL),(25,'Yogurt','1.99','80','2023-05-11','Dairy Co.',NULL),(26,'Sour Cream','2.29','60','2023-05-13','Dairy Co.',NULL),(27,'Salad Dressing','1.79','50','2023-05-15','Pasta Co.',NULL),(28,'Chips','2.99','70','2023-05-16','Bakery Co.',NULL),(29,'Soda','1.99','100','2023-05-18','Fresh Fruits',NULL),(30,'Ice Cream','4.99','30','2023-05-22','Dairy Co.',NULL),(31,'Ketchup','1.49','80','2024-05-01','Pasta Co.',NULL),(32,'Mustard','8.9','90','2023-07-13','Pasta Co.',NULL),(33,'Brown Rice','2.99','50','2023-10-31','Rice Co.',NULL),(34,'Whole Wheat Bread','1.99','20','2023-05-31','Bakery Co.',NULL),(35,'Salmon Fillet','9.99','10','2023-04-30','Fresh Seafood','Expired'),(36,'Spinach','1.49','30','2023-05-15','Fresh Veggies',NULL),(37,'Avocado','1.79','15','2023-04-29','Fresh Fruits','Expired'),(38,'Sausages','4.99','25','2023-05-01','Dairy Co.','Expired'),(39,'Honey','3.49','10','2024-04-30','Fresh Fruits',NULL),(40,'Almond Milk','2.49','20','2023-06-30','Dairy Co.',NULL),(41,'Blueberries','3.99','15','2023-05-10','Fresh Fruits',NULL),(42,'Cottage Cheese','2.99','20','2023-06-15','Dairy Co.',NULL),(43,'Tuna','1.99','30','2023-05-31','Fresh Seafood',NULL),(44,'Green Beans','0.99','40','2023-05-02','Fresh Veggies','Expired'),(45,'Broccoli','1.29','25','2023-05-05','Fresh Veggies',NULL),(46,'Cauliflower','1.49','20','2023-05-03','Fresh Veggies','Expired'),(47,'Sweet Potatoes','0.99','35','2023-05-07','Fresh Veggies',NULL),(48,'Pineapple','2.99','10','2023-04-29','Fresh Fruits','Expired'),(49,'Peanut Butter','3.99','15','2023-07-31','Bakery Co.',NULL),(50,'Jelly','2.49','20','2024-01-31','Bakery Co.',NULL),(51,'Brussels Sprouts','1.49','30','2023-05-08','Fresh Veggies',NULL),(52,'Raspberries','3.99','15','2023-05-12','Fresh Fruits',NULL),(53,'Pita Bread','1.99','40','2023-05-15','Bakery Co.',NULL),(54,'Chocolate Cookies','8.99','10','2023-05-01','Peak Freans','Expired'),(55,'Almond Cookies','4.99','25','2023-05-19','Peak Freans',NULL),(56,'Almonds','2.99','20','2023-06-30','Fresh Fruits',NULL),(57,'Quinoa','3.49','15','2023-07-31','Rice Co.',NULL),(58,'Blue Cheese','2.49','10','2023-05-10','Dairy Co.',NULL),(59,'Baby Carrots','0.99','30','2023-05-15','Fresh Veggies',NULL),(60,'Sourdough Bread','5.55','20','2024-06-01','Dairy Co.',NULL);
/*!40000 ALTER TABLE `inventoryprods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplierinfo`
--

DROP TABLE IF EXISTS `supplierinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplierinfo` (
  `SupplierID` int NOT NULL AUTO_INCREMENT,
  `SupplierName` varchar(45) NOT NULL,
  `ContactName` varchar(45) NOT NULL,
  `ContactTitle` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Region` varchar(45) NOT NULL,
  `PostalCode` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Fax` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Website` varchar(45) NOT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierinfo`
--

LOCK TABLES `supplierinfo` WRITE;
/*!40000 ALTER TABLE `supplierinfo` DISABLE KEYS */;
INSERT INTO `supplierinfo` VALUES (1,'Fresh Veggies','John Smith','Sales Manager','123 Main St.','Los Angeles','California','90001','USA','+1-555-123-4567','+1-555-987-6543','sales@freshveggies.com','www.freshveggies.com'),(2,'Fresh Fruits','Jane Doe','Marketing Manager','456 Market St.','New York','New York','10001','USA','+1-555-234-5678','+1-555-876-5432','info@freshfruits.com','www.freshfruits.com'),(3,'Dairy Co.','Michael Brown','CEO','789 Dairy Dr.','San Francisco','California','94103','USA','+1-555-345-6789','+1-555-765-4321','info@dairyco.com','www.dairyco.com'),(4,'Rice Co.','Maria Gonzalez','Sales Director','321 Rice Ave.','Houston','Texas','77002','USA','+1-555-456-7890','+1-555-654-3210','sales@riceco.com','www.riceco.com'),(5,'Bakery Co.','Alex Torres','Production Manager','555 Bakery Blvd.','Miami','Florida','33101','USA','+1-555-567-8901','+1-555-098-7654','info@bakeryco.com','www.bakeryco.com'),(6,'Fresh Seafood','Sarah Lee','Purchasing Manager','777 Seafood St.','Seattle','Washington','98101','USA','+1-555-678-9012','+1-555-219-0876','sales@freshseafood.com','www.freshseafood.com'),(7,'Pasta Co.','Marco Rossi','Marketing Manager','999 Pasta Ave.','Chicago','Illinois','60601','USA','+1-555-789-0123','+1-555-210-9876','info@pastaco.com','www.pastaco.com'),(8,'Fishermen Co.','David Kim','Operations Manager','111 Fishermen Dr.','Boston','Massachusetts','02108','USA','+1-555-890-1234','+1-555-321-0987','sales@fishermenco.com','www.fishermenco.com'),(9,'Meat Co.','Emma Davis','Sales Manager','222 Meatpacking St.','San Diego','California','92101','USA','+1-555-901-2345','+1-555-456-7890','info@meatco.com','www.meatco.com'),(10,'Canned Foods','Mary Johnson','Sales Manager','1234 Canned Food St.','Dallas','Texas','75201','USA','+1-555-123-4567','+1-555-987-6543','sales@cannedfoods.com','www.cannedfoods.com'),(11,'Peak Freans','David Smith','Marketing Manager','456 Cookie St.','Toronto','Ontario','M5V 2T6','Canada','+1-555-234-5678','+1-555-876-5432','info@peakfreans.com','www.peakfreans.com'),(12,'Egg Producers','Jake Larry','CEO','789 Egg Farm Rd.','Des Moines','Iowa','50309','USA','+1-555-345-6789','+1-555-765-4321','info@eggproducers.com','www.eggproducers.com'),(13,'Poultry Farms','Karen Lee','Operations Manager','111 Poultry Ave.','Atlanta','Georgia','30303','USA','+1-555-456-7890','+1-555-654-3210','sales@poultryfarms.com','www.poultryfarms.com');
/*!40000 ALTER TABLE `supplierinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 18:46:43
CREATE DATABASE  IF NOT EXISTS `salesrecords` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `salesrecords`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: salesrecords
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `productperformance`
--

DROP TABLE IF EXISTS `productperformance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productperformance` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `ItemName` varchar(45) NOT NULL,
  `targetSaleQuantity` int NOT NULL,
  `actualSaleQuantity` int NOT NULL,
  `avgSaleQuantity` int NOT NULL,
  `profitMargin` double NOT NULL,
  `unitPrice` double NOT NULL,
  `costPrice` double NOT NULL,
  `salesRank` int NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productperformance`
--

LOCK TABLES `productperformance` WRITE;
/*!40000 ALTER TABLE `productperformance` DISABLE KEYS */;
INSERT INTO `productperformance` VALUES (1,'Bananas',1000,900,2,0.3,0.99,0.69,2),(2,'Apples',800,750,3,0.35,1.49,0.97,4),(3,'Milk',500,490,1,0.2,3.29,2.63,8),(4,'Bread',700,650,2,0.25,2.99,2.24,5),(5,'Eggs',1200,1100,2,0.4,2.49,1.49,1),(6,'Cheese',400,380,1,0.35,5.99,3.89,12),(7,'Chicken',200,180,1,0.15,8.99,7.64,19),(8,'Beef',150,140,1,0.3,12.99,9.09,10),(9,'Fish',250,220,2,0.25,10.99,8.24,14),(10,'Rice',400,370,2,0.2,3.99,3.19,6),(11,'Pasta',600,550,2,0.25,2.49,1.87,3),(12,'Tomatoes',900,850,1,0.3,1.99,1.39,7),(13,'Potatoes',1200,1150,2,0.15,0.99,0.84,13),(14,'Onions',1400,1300,2,0.25,0.79,0.59,9),(15,'Carrots',1000,950,2,0.2,0.89,0.71,11),(16,'Lettuce',500,450,2,0.25,1.29,0.97,9),(17,'Cucumbers',700,690,1,0.15,0.99,0.84,8),(18,'Oranges',900,850,1,0.2,1.69,1.35,6),(19,'Grapes',400,430,2,0.35,3.99,2.59,12),(20,'Strawberries',300,310,1,0.3,4.49,3.14,15),(21,'Canned Tomatoes',800,780,1,0.1,1.99,1.79,7),(22,'Ground Beef',200,190,2,0.15,7.99,6.79,18),(23,'Frozen Pizza',350,360,2,0.25,5.99,4.49,13),(24,'Orange Juice',600,590,1,0.3,3.49,2.44,10),(25,'Yogurt',900,920,1,0.25,1.99,1.49,20),(26,'Sour Cream',400,410,1,0.2,2.29,1.83,14),(27,'Salad Dressing',750,760,1,0.1,1.79,1.61,8),(28,'Chips',600,620,2,0.3,2.99,2.09,11),(29,'Soda',1000,980,1,0.2,1.99,1.59,5),(30,'Ice Cream',250,240,2,0.4,4.99,3.59,16),(31,'Ketchup',5000,4600,2,0.4,1.49,0.89,8),(32,'Mustard',1000,950,1,0.35,8.9,6.49,12),(33,'Brown Rice',2000,1950,1,0.25,2.99,2.29,9),(34,'Whole Wheat Bread',3000,2900,2,0.3,1.99,1.39,10),(35,'Salmon Fillet',500,480,1,0.45,9.99,7.99,15),(36,'Spinach',1500,1400,2,0.35,1.49,0.89,6),(37,'Avocado',2500,2400,1,0.5,1.79,1.09,11),(38,'Sausages',800,780,1,0.4,4.99,3.49,14),(39,'Honey',1200,1100,1,0.55,3.49,1.59,7),(40,'Almond Milk',1800,1750,1,0.3,2.49,1.49,13),(41,'Blueberries',1000,970,1,0.6,3.99,2.29,16),(42,'Cottage Cheese',900,890,1,0.45,2.99,1.29,17),(43,'Tuna',3000,2950,1,0.25,1.99,1.29,5),(44,'Green Beans',4000,3900,2,0.2,0.99,0.59,4),(45,'Broccoli',3500,3450,1,0.3,1.29,0.89,3),(46,'Cauliflower',500,450,2,0.25,1.49,1.09,9),(47,'Sweet Potatoes',700,690,1,0.15,0.99,0.79,8),(48,'Pineapple',900,850,1,0.2,2.99,2.35,6),(49,'Peanut Butter',400,430,2,0.35,3.99,2.59,12),(50,'Jelly',300,310,1,0.3,2.49,1.74,15),(51,'Brussels Sprouts',800,780,1,0.1,1.49,1.25,7),(52,'Raspberries',200,190,2,0.15,7.99,6.25,18),(53,'Pita Bread',350,360,2,0.25,5.49,4.35,13),(54,'Chocolate Cookies',600,590,1,0.3,4.99,3.35,10),(55,'Almond Cookies',900,920,1,0.25,3.99,2.75,20),(56,'Almonds',400,410,1,0.2,2.29,1.89,14),(57,'Quinoa',750,760,1,0.1,1.79,1.45,8),(58,'Blue Cheese',600,620,2,0.3,2.99,2.15,11),(59,'Baby Carrots',1000,980,1,0.2,1.49,1.09,5),(60,'Sourdough Bread',250,240,2,0.4,4.49,3.15,16);
/*!40000 ALTER TABLE `productperformance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-10 18:46:43
