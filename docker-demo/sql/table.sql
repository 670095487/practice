CREATE TABLE `USER`
(
    id      INT UNSIGNED auto_increment,
    name    VARCHAR(64),
    age     INT(3),
    address VARCHAR(128),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;