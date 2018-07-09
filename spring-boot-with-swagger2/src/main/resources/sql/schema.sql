-- create table `user`
DROP TABLE `user` IF EXISTS
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL UNIQUE ,
  `email` varchar(50) NOT NULL UNIQUE ,
  `password` varchar(50) NULL,
  `age` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;