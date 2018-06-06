-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2018 at 02:40 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `wh-comments`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--
/*
CREATE TABLE `comments` (
  `commentId` int(11) NOT NULL,
  `text` longtext NOT NULL,
  `userId` int(11) NOT NULL,
  `referedComment` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` enum('new','approved','rejected','suspended') NOT NULL,
  `page` varchar(512) NOT NULL,
  `product` varchar(256) NOT NULL,
  `version` varchar(128) NOT NULL,
  `visible` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`commentId`, `text`, `userId`, `referedComment`, `date`, `state`, `page`, `product`, `version`, `visible`) VALUES
(1, 'Test Comment<br>', 1, 0, '2018-06-05 11:26:16', 'approved', 'topics/webhelp-responsive-description.html', 'webhelp-responsive', '1.0', 'true');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`commentId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;*/
COMMIT;
