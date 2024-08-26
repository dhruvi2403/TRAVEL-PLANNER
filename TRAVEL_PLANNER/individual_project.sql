-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2024 at 11:01 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `individual_project`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_cust` (IN `i_cname` VARCHAR(30), IN `i_pno` INT, IN `i_gender` VARCHAR(30), IN `i_aadharno` INT, IN `i_address` VARCHAR(30), IN `i_age` INT, IN `i_noofppl` INT)   BEGIN
insert into cust_info values(null,i_cname,i_pno,i_gender,i_aadharno,i_address,i_age,i_noofppl);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_signup` (IN `p_name` VARCHAR(50), IN `p_username` VARCHAR(50), IN `p_pass` VARCHAR(50))   BEGIN
insert into verification_info VALUES (p_name,p_username,p_pass);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `activity_log`
--

CREATE TABLE `activity_log` (
  `user_name` varchar(30) NOT NULL,
  `action` varchar(30) NOT NULL,
  `time_stamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `activity_log`
--

INSERT INTO `activity_log` (`user_name`, `action`, `time_stamp`) VALUES
('babulal', 'account created', '2024-08-23 23:13:01'),
('jeet', 'account created', '2024-08-23 21:37:56'),
('jetshree', 'account created', '2024-08-23 21:39:45'),
('kirt123', 'account created', '2024-08-24 07:53:17'),
('mihir', 'account created', '2024-08-24 05:21:50'),
('nikhil', 'account created', '2024-08-24 05:53:36'),
('shaily001', 'account created', '2024-08-24 11:52:52'),
('XYZABC', 'account created', '2024-08-23 18:10:30');

-- --------------------------------------------------------

--
-- Table structure for table `cust_info`
--

CREATE TABLE `cust_info` (
  `booking_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `pno` bigint(20) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `aadharno` bigint(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `noofppl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cust_info`
--

INSERT INTO `cust_info` (`booking_id`, `name`, `pno`, `gender`, `aadharno`, `address`, `age`, `noofppl`) VALUES
(1, 'xyz', 1, 'Male', 1, 'mumbai', 31, 2),
(2, 'rupal patel', 635, 'Female', 635, 'amd', 43, 2),
(3, 'carl patel', 1234, 'Male', 2345, 'varanasi', 28, 2),
(4, 'rupal', 6351, 'Female', 6351, 'ahmedabad', 43, 6),
(5, 'geeta', 78622, 'Female', 76823, 'rajkot', 72, 3),
(6, 'acbd', 5672198, 'Male', 541948, 'delhi', 34, 4),
(7, 'mahek', 9898987, 'Female', 898976, 'bharuch', 23, 4),
(9, 'astha', 7648, 'Female', 112233445, 'kolkata', 56, 1),
(10, 'aman', 1122334455, 'Male', 1122334455, 'vizag', 112, 2),
(11, 'geeeta', 6745364, 'Female', 8746254638, 'rajkot', 23, 1),
(12, 'kanjibhai B', 987656, 'Male', 9988776677, 'rajkot', 71, 2),
(16, 'babulal', 789, 'Male', 789, 'kadi', 78, 2),
(17, 'babulal', 90165, 'Male', 90165, 'kadi', 78, 2),
(18, 'balkrishnan', 910, 'Male', 910, 'ahmedabad', 78, 3),
(20, 'krishna', 67325, 'Female', 67325, 'mumbai', 33, 1),
(24, 'RUPAL', 6351345705, 'Female', 6351345705123, 'ahmedabad', 42, 3),
(25, 'Jetshree', 989876, 'Female', 989876212, 'jamnagar', 19, 3),
(26, 'MIHIR', 9824183, 'Male', 982481232, 'Banglore', 39, 4),
(27, 'Nikhil', 9824185, 'Male', 981237532, 'Ahmedabad', 46, 2),
(28, 'Shaily', 98213462, 'Female', 97452714, 'Surat', 44, 4);

-- --------------------------------------------------------

--
-- Table structure for table `verification_info`
--

CREATE TABLE `verification_info` (
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `verification_info`
--

INSERT INTO `verification_info` (`name`, `username`, `password`) VALUES
('abcd', 'abcd', '1234'),
('babulal', 'babulal', 'babulal'),
('carl magson', 'carl', 'carmag'),
('geeta', 'geeta', 'geeta'),
('nikhil', 'gudiya', 'rupal'),
('jeet', 'jeet', 'jeet'),
('jetshree', 'jetshree', 'jetshree'),
('kanjibhai', 'kanji', 'geeta'),
('Kirti', 'kirt123', 'kirt123'),
('mihir', 'mihir', '12213'),
('Nikhil', 'nikhil', '1977'),
('rupal patel', 'rupal', '0103'),
('Shaily', 'shaily001', 'shaily001'),
('XYZ', 'XYZ', 'XYZ'),
('XYZABC', 'XYZABC', 'XYZ');

--
-- Triggers `verification_info`
--
DELIMITER $$
CREATE TRIGGER `insert_log` AFTER INSERT ON `verification_info` FOR EACH ROW INSERT INTO activity_log VALUES (NEW.username,'account created',CURRENT_TIMESTAMP)
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity_log`
--
ALTER TABLE `activity_log`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `cust_info`
--
ALTER TABLE `cust_info`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `verification_info`
--
ALTER TABLE `verification_info`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cust_info`
--
ALTER TABLE `cust_info`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
