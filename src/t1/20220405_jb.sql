-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.19-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- jb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jb`;

-- 테이블 jb.jbmember 구조 내보내기
CREATE TABLE IF NOT EXISTS `jbmember` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `birth` varchar(20) DEFAULT NULL,
  `gender` varchar(2) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 테이블 데이터 jb.jbmember:~1 rows (대략적) 내보내기
DELETE FROM `jbmember`;
/*!40000 ALTER TABLE `jbmember` DISABLE KEYS */;
INSERT INTO `jbmember` (`idx`, `name`, `birth`, `gender`, `phone`) VALUES
	(16, '박종헌', '9999999', '남자', '0108109');
/*!40000 ALTER TABLE `jbmember` ENABLE KEYS */;

-- 테이블 jb.jborder 구조 내보내기
CREATE TABLE IF NOT EXISTS `jborder` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  `menu` varchar(50) NOT NULL,
  `menupri` int(11) NOT NULL,
  `menubill` varchar(5) NOT NULL,
  `menutake` varchar(5) NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 테이블 데이터 jb.jborder:~0 rows (대략적) 내보내기
DELETE FROM `jborder`;
/*!40000 ALTER TABLE `jborder` DISABLE KEYS */;
/*!40000 ALTER TABLE `jborder` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
