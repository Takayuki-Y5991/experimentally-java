-- --------------------------------------------------------
-- ホスト:                          127.0.0.1
-- サーバーのバージョン:                   10.3.34-MariaDB-0ubuntu0.20.04.1 - Ubuntu 20.04
-- サーバー OS:                      debian-linux-gnu
-- HeidiSQL バージョン:               12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--  テーブル local_mariadb.book の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` binary(36) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT 0,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.book: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.tag の構造をダンプしています
CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.tag: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.member の構造をダンプしています
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `contact` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` int(11) NOT NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `UK_748s09y2s96c6p1vwpv30wpbw` (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.member: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.book_rental の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book_rental` (
  `book_rental_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `checkout_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `return_date` datetime(6) NOT NULL,
  `book_id` binary(36) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`book_rental_id`),
  KEY `FK8mbgvc4eb0i0cvkg2sea83f76` (`book_id`),
  KEY `FKa007yl0k0ocn0t14awjtwsvrr` (`member_id`),
  CONSTRAINT `FK8mbgvc4eb0i0cvkg2sea83f76` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `FKa007yl0k0ocn0t14awjtwsvrr` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.book_rental: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.book_return の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book_return` (
  `book_return_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `return_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `book_rental_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`book_return_id`),
  KEY `FKrrvlcrr7p0a168buph02ogkbm` (`book_rental_id`),
  CONSTRAINT `FKrrvlcrr7p0a168buph02ogkbm` FOREIGN KEY (`book_rental_id`) REFERENCES `book_rental` (`book_rental_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.book_return: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.book_tag の構造をダンプしています
CREATE TABLE IF NOT EXISTS `book_tag` (
  `tag_id` bigint(20) NOT NULL,
  `book_id` binary(36) NOT NULL,
  PRIMARY KEY (`tag_id`,`book_id`),
  UNIQUE KEY `UK_f045npn9q5w2ob1bfumk39a6i` (`tag_id`),
  UNIQUE KEY `UK_seghejmqft5qpx8wdjog49m2r` (`book_id`),
  CONSTRAINT `FKdrc33u5ufw8rdvajeveowgx7g` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `FKrxw4xl05l6ns1763bq284e7m2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.book_tag: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.member_rental_book の構造をダンプしています
CREATE TABLE IF NOT EXISTS `member_rental_book` (
  `member_id` bigint(20) NOT NULL,
  `book_id` binary(36) NOT NULL,
  PRIMARY KEY (`member_id`,`book_id`),
  UNIQUE KEY `UK_dvjtcnbew49bs9keyi9hgdo7r` (`member_id`),
  UNIQUE KEY `UK_hncxperuu74cgxpkivvatfwmj` (`book_id`),
  CONSTRAINT `FKbta714tuqq8u7q5qiiiu4d4hy` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `FKdb17jytqntxe75wri362mig9r` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- テーブル local_mariadb.member_rental_book: ~0 rows (約) のデータをダンプしています

--  テーブル local_mariadb.hibernate_sequence の構造をダンプしています
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- テーブル local_mariadb.hibernate_sequence: ~1 rows (約) のデータをダンプしています
INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;