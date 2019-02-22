CREATE DATABASE IF NOT EXISTS social;

ALTER DATABASE social
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON *.* TO test@localhost IDENTIFIED BY 'test';

USE social;

CREATE TABLE IF NOT EXISTS users (
       id bigint not null auto_increment,
        email varchar(255) not null,
        email_verified bit not null,
        image_url varchar(255),
        name varchar(255) not null,
        password varchar(255),
        provider varchar(255) not null,
        provider_id varchar(255),
        primary key (id)
    ) engine=InnoDB