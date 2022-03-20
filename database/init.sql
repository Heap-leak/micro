CREATE TABLE IF NOT EXISTS NotificationRegistry (
  notificationId BIGSERIAL primary key not null,
  username VARCHAR(30) not null,
  notificationUrl VARCHAR(255) not null
);

CREATE TABLE IF NOT EXISTS UserProfiles(
  username varchar(30) primary key,
  password varchar(255) not null,
  user_role varchar(30) not null
);