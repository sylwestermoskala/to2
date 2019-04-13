CREATE TABLE users(
  id SERIAL,
  email varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  enabled boolean NOT NULL DEFAULT FALSE,
  primary key(email)
);

create table user_roles (
  user_role_id SERIAL PRIMARY KEY,
  email varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  UNIQUE (email,role),
  FOREIGN KEY (email) REFERENCES users (email)
);

INSERT INTO users(email,password,enabled) VALUES ('admin','admin', true);
INSERT INTO users(email,password,enabled) VALUES ('asia','asia', true);
INSERT INTO users(email,password,enabled) VALUES ('sylwek','sylwek', true);
INSERT INTO users(email,password,enabled) VALUES ('lidka','lidka', true);
INSERT INTO users(email,password,enabled) VALUES ('ola','ola', true);

INSERT INTO user_roles (email, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_roles (email, role) VALUES ('lidka', 'ROLE_ADMIN');
INSERT INTO user_roles (email, role) VALUES ('asia', 'ROLE_ADMIN');
INSERT INTO user_roles (email, role) VALUES ('ola', 'ROLE_USER');

CREATE TABLE usersdetails(
	id SERIAL,
	email varchar(20),
	country varchar(20),
	gender varchar(20),
	primary key(email),
	FOREIGN KEY (email) REFERENCES users (email)
);
INSERT INTO usersdetails(email,country,gender) VALUES ('asia','poland', 'female');
INSERT INTO usersdetails(email,country,gender) VALUES ('sylwek','poland', 'male');
