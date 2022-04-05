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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- 테이블 데이터 jb.jbmember:~9 rows (대략적) 내보내기
DELETE FROM `jbmember`;
/*!40000 ALTER TABLE `jbmember` DISABLE KEYS */;
INSERT INTO `jbmember` (`idx`, `name`, `birth`, `gender`, `phone`) VALUES
	(17, '김자바', '900302', '여자', '010-3154-8547'),
	(18, '이기자', '800728', '남자', '010-1535-4485'),
	(19, '이순신', '700605', '남자', '010-9584-5584'),
	(20, '지상렬', '800508', '남자', '010-1111-2222'),
	(21, '미친개', '870623', '남자', '010-5468-7712'),
	(22, '일지매', '630805', '여자', '010-2368-7271'),
	(23, '박그린', '500821', '여자', '010-5411-5580'),
	(24, '윤루트', '871201', '남자', '010-4583-5841'),
	(25, '김각정', '990820', '여자', '010-5684-7721');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- 테이블 데이터 jb.jborder:~9 rows (대략적) 내보내기
DELETE FROM `jborder`;
/*!40000 ALTER TABLE `jborder` DISABLE KEYS */;
INSERT INTO `jborder` (`idx`, `name`, `menu`, `menupri`, `menubill`, `menutake`) VALUES
	(21, '', '카라멜마끼야또 +\n더치커피 +\n--ICE로변경-- +\n', 8500, '현금결제', '포장주문'),
	(22, '김자바', '아메리카노 +\n에스프레소 +\n레몬에이드 +\n더치커피 +\n', 10000, '현금결제', '매장주문'),
	(23, '이기자', '더치커피 +\n레몬에이드 +\n', 6000, '카드결제', '배달주문'),
	(24, '윤루트', '아메리카노 +\n카라멜마끼야또 +\n--ICE로변경-- +\n--ICE로변경-- +\n', 7000, '현금결제', '매장주문'),
	(25, '일지매', '콜드브루 +\n레몬에이드 +\n--ICE로변경-- +\n', 6000, '현금결제', '배달주문'),
	(26, '', '에스프레소 +\n카푸치노 +\n', 5500, '현금결제', '배달주문'),
	(27, '김각정', '콜드브루 +\n카푸치노 +\n', 7000, '카드결제', '포장주문'),
	(28, '', '아메리카노 +\n카푸치노 +\n카라멜마끼야또 +\n', 9500, '현금결제', '포장주문'),
	(29, '', '콜드브루 +\n카푸치노 +\n--ICE로변경-- +\n', 7500, '카드결제', '포장주문');
/*!40000 ALTER TABLE `jborder` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
