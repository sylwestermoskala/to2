DROP TABLE IF EXISTS `routes`;
CREATE TABLE IF NOT EXISTS `routes` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `distance` int DEFAULT NULL,
                                     `start_location` varchar(255) DEFAULT NULL,
                                     `end_location` varchar(255) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

INSERT INTO `routes` (`id`, `distance`, `start_location`, `end_location`) VALUES
(1, 292, 'Cracow', 'Warsaw'),
(2, 459, 'Cracow', 'Poznan'),
(3, 583, 'Cracow', 'Gdansk'),
(4, 81, 'Katowice', 'Cracow'),
(5, 168, 'Rzeszow', 'Cracow');
COMMIT;