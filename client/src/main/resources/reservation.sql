# DROP TABLE IF EXISTS `reservation`;
# CREATE TABLE IF NOT EXISTS `reservation` (
#                                       `id` int(11) NOT NULL AUTO_INCREMENT,
#                                       `route_number` int DEFAULT NULL,
#                                       `distance` int DEFAULT NULL,
#                                       `start_location` varchar(255) DEFAULT NULL,
#                                       `end_location` varchar(255) DEFAULT NULL,
#                                       PRIMARY KEY (`id`)
# ) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS reservation(
                           id SERIAL,
                           route_number int,
                           distance int,
                           start_location varchar(255) DEFAULT NULL,
                           end_location varchar(255) DEFAULT NULL,
                           primary key(route_number)
);