DROP TABLE IF EXISTS `user_roles`;
create table user_roles (
                          user_role_id SERIAL PRIMARY KEY,
                          email varchar(20) NOT NULL,
                          role varchar(20) NOT NULL,
                          UNIQUE (email,role),
                          FOREIGN KEY (email) REFERENCES users (email)
);

INSERT INTO user_roles (email, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (email, role) VALUES ('sylwek', 'ROLE_USER');
INSERT INTO user_roles (email, role) VALUES ('ola', 'ROLE_USER');