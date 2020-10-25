CREATE TABLE _config(
	key VARCHAR(50) PRIMARY KEY,
	value VARCHAR (50) UNIQUE NOT NULL
);

INSERT INTO _config (key,value) VALUES('env','DEV'),('db','localhost');

CREATE TABLE _languages(
	key VARCHAR(2) PRIMARY KEY,
	name VARCHAR (30) UNIQUE NOT NULL
);

INSERT INTO _languages (key,name) VALUES('br','BRASIL'),('en','ESTADOS UNIDOS'),('pt','PORTUGAL');

CREATE TABLE _translations(
	key VARCHAR(244) PRIMARY KEY,
	br VARCHAR (244) UNIQUE NOT null,
	en VARCHAR (244) UNIQUE NOT null
);

INSERT INTO _translations (key,br,en) VALUES('title','Jogo','Game'),('label','label','label');


CREATE TABLE account_status(
	id serial PRIMARY KEY,
	status VARCHAR (50) UNIQUE NOT NULL
);

INSERT INTO account_status (id,status) VALUES(0,'OFFLINE'),(1,'ONLINE');

CREATE TABLE account(
   id serial PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL,
   email VARCHAR (355) UNIQUE NOT NULL,
   token VARCHAR (355) UNIQUE NOT NULL,
   created_on TIMESTAMP NOT NULL,
   last_login TIMESTAMP,
   account_logged_id INT,
   CONSTRAINT fk_account_logged_id FOREIGN KEY (account_logged_id) REFERENCES account_status (id)
);

INSERT INTO account
	  (username, "password", email, "token", created_on, last_login, account_logged_id)
VALUES('set', '123', 'edson.fullstack@gmail.com', '123', '12/12/2012', '12/12/2012', 0);

CREATE TABLE chars(
   id serial PRIMARY KEY,
   account_id serial,
   charactername VARCHAR(50)UNIQUE NOT NULL,
   stats INT,
   skill INT, 
   CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE chars_classes(
   id serial PRIMARY KEY,
   account_id serial,
   charactername VARCHAR(50)UNIQUE NOT NULL,
   stats INT,
   skill INT, 
   CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account (id)
);