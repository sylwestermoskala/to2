DROP TABLE IF EXISTS `users`;
CREATE TABLE users(
                    id SERIAL,
                    email varchar(20) NOT NULL,
                    password varchar(20) NOT NULL,
                    enabled boolean NOT NULL DEFAULT FALSE,
                    primary key(email)
);

INSERT INTO users(email,password,enabled) VALUES ('admin','admin', true);
INSERT INTO users(email,password,enabled) VALUES ('sylwek','sylwek', true);
INSERT INTO users(email,password,enabled) VALUES ('ola','ola', true);