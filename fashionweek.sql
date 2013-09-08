-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2013 at 10:34 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `fashionweek`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE IF NOT EXISTS `angazovanje` (
  `id` int(11) NOT NULL,
  `vidplacanja` text NOT NULL,
  `iznos` int(11) NOT NULL,
  `model` int(11) NOT NULL,
  `kreirao` int(13) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `model` (`model`),
  KEY `kreirao` (`kreirao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dizajner`
--

CREATE TABLE IF NOT EXISTS `dizajner` (
  `jmbg` int(13) NOT NULL,
  `ime` text NOT NULL,
  `prezime` text NOT NULL,
  `sponzor` int(11) NOT NULL,
  PRIMARY KEY (`jmbg`),
  UNIQUE KEY `jmbg` (`jmbg`),
  UNIQUE KEY `sponzor_4` (`sponzor`),
  KEY `sponzor` (`sponzor`),
  KEY `sponzor_2` (`sponzor`),
  KEY `sponzor_3` (`sponzor`),
  KEY `sponzor_5` (`sponzor`),
  KEY `sponzor_6` (`sponzor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dizajner`
--

INSERT INTO `dizajner` (`jmbg`, `ime`, `prezime`, `sponzor`) VALUES
(2147483647, 'lala', 'lala', 1);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `id` int(11) NOT NULL,
  `korisnickoime` varchar(20) NOT NULL,
  `korisnickasifra` varchar(20) NOT NULL,
  `ime` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `korisnickoime`, `korisnickasifra`, `ime`, `email`) VALUES
(1, 'bojana', 'bojana', 'Bojana L', 'bojanalcc@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `mestoodrzavanja`
--

CREATE TABLE IF NOT EXISTS `mestoodrzavanja` (
  `id` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `adresa` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mestoodrzavanja`
--

INSERT INTO `mestoodrzavanja` (`id`, `naziv`, `adresa`) VALUES
(111, 'm', 'm');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

CREATE TABLE IF NOT EXISTS `model` (
  `jmbg` int(13) NOT NULL,
  `ime` text NOT NULL,
  `prezime` text NOT NULL,
  `modnaagencija` int(11) NOT NULL,
  PRIMARY KEY (`jmbg`),
  UNIQUE KEY `jmbg` (`jmbg`),
  KEY `modnaagencija` (`modnaagencija`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `modnaagencija`
--

CREATE TABLE IF NOT EXISTS `modnaagencija` (
  `id` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `adresa` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `revija`
--

CREATE TABLE IF NOT EXISTS `revija` (
  `id` int(11) NOT NULL,
  `datum` datetime NOT NULL,
  `mesto` int(11) NOT NULL,
  `dizajner` int(11) NOT NULL,
  `kreirao` int(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `mesto` (`mesto`),
  KEY `dizajner` (`dizajner`),
  KEY `kreirao` (`kreirao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sponzor`
--

CREATE TABLE IF NOT EXISTS `sponzor` (
  `id` int(11) NOT NULL,
  `naziv` text NOT NULL,
  `pib` text NOT NULL,
  `adresa` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sponzor`
--

INSERT INTO `sponzor` (`id`, `naziv`, `pib`, `adresa`) VALUES
(1, 's', 's', 's');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `angazovanje_ibfk_1` FOREIGN KEY (`model`) REFERENCES `model` (`jmbg`) ON UPDATE CASCADE,
  ADD CONSTRAINT `angazovanje_ibfk_2` FOREIGN KEY (`kreirao`) REFERENCES `korisnik` (`id`);

--
-- Constraints for table `dizajner`
--
ALTER TABLE `dizajner`
  ADD CONSTRAINT `dizajner_ibfk_2` FOREIGN KEY (`sponzor`) REFERENCES `sponzor` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `model`
--
ALTER TABLE `model`
  ADD CONSTRAINT `model_ibfk_2` FOREIGN KEY (`modnaagencija`) REFERENCES `modnaagencija` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `revija`
--
ALTER TABLE `revija`
  ADD CONSTRAINT `revija_ibfk_1` FOREIGN KEY (`mesto`) REFERENCES `mestoodrzavanja` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `revija_ibfk_2` FOREIGN KEY (`dizajner`) REFERENCES `dizajner` (`jmbg`) ON UPDATE CASCADE,
  ADD CONSTRAINT `revija_ibfk_3` FOREIGN KEY (`kreirao`) REFERENCES `korisnik` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
