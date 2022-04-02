INSERT INTO `java_academy_2022`.`book` (`title`, `authors`, `year`, `publisher`, `price`, `description`)
VALUES ('Thinikng in Java', 'Bruce Eckel', '2015', 'Prentice Hall', '35.7', 'Extensive introduction to Java');
INSERT INTO `java_academy_2022`.`book` (`title`, `authors`, `year`, `publisher`, `price`, `description`)
VALUES ('Effective Java', 'Joshua Bloch', '2018', 'Springer', '42.3', 'In depth java book');
INSERT INTO `java_academy_2022`.`book` (`title`, `authors`, `year`, `publisher`, `price`, `description`)
VALUES ('UML Distilled', 'Marttin Fowler', '2008', 'SoftPress', '19.9', 'Brief and concise introduction to UML');

SELECT id, title, price FROM java_academy_2022.book WHERE price < 40;
