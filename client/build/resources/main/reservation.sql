
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS reservation(
                           id int,
                           date varchar(20),
                           distance int,
                           start_location varchar(20) DEFAULT NULL,
                           end_location varchar(20) DEFAULT NULL,
                           primary key(id)
);

INSERT INTO `reservation` (`id`, `date`, `distance`, `start_location`, `end_location`) VALUES
(10, '07/24/2019', 292, 'Cracow', 'Warsaw'),
(12, '11/30/2019', 168, 'Rzeszow', 'Cracow');
COMMIT;
