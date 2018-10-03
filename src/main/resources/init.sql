create database springboot_test IF NOT EXISTS;

create table IF NOT EXISTS t_user (
  id VARCHAR(32) NOT NULL ,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;