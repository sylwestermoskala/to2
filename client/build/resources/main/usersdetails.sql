DROP TABLE IF EXISTS `usersdetails`;
CREATE TABLE usersdetails(
                           id SERIAL,
                           email varchar(20),
                           country varchar(20),
                           gender varchar(20),
                           primary key(email),
                           FOREIGN KEY (email) REFERENCES users (email)
);

INSERT INTO usersdetails(email,country,gender) VALUES ('admin','poland', 'female');
INSERT INTO usersdetails(email,country,gender) VALUES ('sylwek','poland', 'male');