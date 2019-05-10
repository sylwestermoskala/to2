
DROP TABLE IF EXISTS `routes`;
CREATE TABLE routes(
                           id int NOT NULL AUTO_INCREMENT,
                           date varchar(20),
                           distance int DEFAULT NULL,
                           start_location varchar(20),
                           end_location varchar(20),
                           PRIMARY KEY (id)
);



INSERT INTO `routes` (`id`, `date`, `distance`, `start_location`, `end_location`) VALUES
(1, '04/03/2019', 292, 'Cracow', 'Warsaw'),
(2, '02/23/2019',  459, 'Cracow', 'Poznan'),
(3, '12/30/2019', 583, 'Cracow', 'Gdansk'),
(4, '01/19/2019', 81, 'Katowice', 'Cracow'),
(6, '09/02/2019', 168, 'Rzeszow', 'Cracow');
COMMIT;