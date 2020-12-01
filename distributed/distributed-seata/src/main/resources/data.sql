DROP DATABASE IF EXISTS `datasource1`;
CREATE DATABASE `datasource1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use datasource1;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `orders_2`;
CREATE TABLE `orders_2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into orders (code,quantity) values (1,1);
insert  into orders_2 (code,quantity) values (1,1);

DROP DATABASE IF EXISTS `datasource2`;
CREATE DATABASE `datasource2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use datasource2;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into customer (name,age) values (1,1);