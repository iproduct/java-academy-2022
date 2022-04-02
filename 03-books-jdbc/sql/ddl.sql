CREATE SCHEMA `java_academy_2022` DEFAULT CHARACTER SET utf8;

USE `java_academy_2022`;

CREATE TABLE `java_academy_2022`.`book`
(
    `id`          BIGINT(11)    NOT NULL AUTO_INCREMENT,
    `title`       VARCHAR(45)   NOT NULL,
    `authors`     VARCHAR(80)   NULL,
    `year`        INT           NULL,
    `publisher`   VARCHAR(45)   NULL,
    `price`       DECIMAL(8, 2) NULL,
    `description` VARCHAR(512)  NULL,
    PRIMARY KEY (`id`)
);

