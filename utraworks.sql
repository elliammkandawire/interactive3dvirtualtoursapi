-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 18, 2021 at 11:43 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ultrawerks`
--

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `INVOICE-ID` int NOT NULL,
  `DATE` date NOT NULL,
  `PROJECT-ID` int NOT NULL,
  `SERVICE-COMBO` int NOT NULL,
  `TOTAL` int NOT NULL,
  PRIMARY KEY (`INVOICE-ID`),
  KEY `invoice` (`PROJECT-ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `PRJ-ID` int NOT NULL,
  `INVOICE#` int NOT NULL,
  `PAYMENT-MODE` varchar(30) NOT NULL,
  `PROOF OF PAYMENT` varchar(30) NOT NULL,
  KEY `payment` (`INVOICE#`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PROJECT OWNER` int NOT NULL,
  `PROJECT NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `project` (`PROJECT OWNER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project-details`
--

DROP TABLE IF EXISTS `project-details`;
CREATE TABLE IF NOT EXISTS `project-details` (
  `PRJ-ID` int NOT NULL,
  `PURPOSE` varchar(30) NOT NULL,
  `LOCATION` varchar(30) NOT NULL,
  `TERRAINS` varchar(30) NOT NULL,
  `AREA` varchar(5) NOT NULL,
  KEY `project details` (`PRJ-ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
CREATE TABLE IF NOT EXISTS `register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(15) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `firstname`, `surname`, `email`) VALUES
(1, 'Grace', 'Chirwa', 'gchirwa.icorp.com'),
(2, 'Makhali', 'Mang\'anya', 'makhali.manganya.ultrawerks@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE IF NOT EXISTS `services` (
  `ID` int NOT NULL,
  `TYPE` varchar(30) NOT NULL,
  `PRESENTATION` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice` FOREIGN KEY (`PROJECT-ID`) REFERENCES `project` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment` FOREIGN KEY (`INVOICE#`) REFERENCES `invoice` (`INVOICE-ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project` FOREIGN KEY (`PROJECT OWNER`) REFERENCES `register` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `project-details`
--
ALTER TABLE `project-details`
  ADD CONSTRAINT `project details` FOREIGN KEY (`PRJ-ID`) REFERENCES `project` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
