create sequence if not exists hibernate_sequence start 1 increment 1;
CREATE TABLE IF NOT EXISTS notificationregistry (
  id BIGSERIAL primary key,
  username VARCHAR(30) not null,
  notificationUrl VARCHAR(255) not null
);
    
CREATE TABLE users
(
	id BIGSERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(250) NOT NULL,
	user_role VARCHAR(50) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	avatar VARCHAR,
	secret VARCHAR,
	account_enabled BOOLEAN NOT NULL DEFAULT true,
	account_expired BOOLEAN NOT NULL DEFAULT false,
	account_locked BOOLEAN NOT NULL DEFAULT false,
	credentials_expired BOOLEAN NOT NULL DEFAULT false,
	use_2fa BOOLEAN NOT NULL DEFAULT false
);
    
--alter table if exists message
--    add constraint message_user_fk
--    foreign key (user_id) references usr;
    
--alter table if exists user_roles
--    add constraint user_role_user_fk
--    foreign key (user_id) references usr;

--create extension if not exists pgcrypto;
--update users set password = crypt(password, gen_salt('bf', 10));

INSERT INTO users (username, password, user_role, first_name, last_name, email)
VALUES ('admin', '$2a$10$R6VGI13c/aM4vZE1nkQ6j.ijPGspvK7a0af3nQZDW4HK3S/H2WJCK', 'ADMIN', 'Bob', 'Doe', 'bob@doe.com');

