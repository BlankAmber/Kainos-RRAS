CREATE DATABASE IF NOT EXISTS KainosJobs_AdamM;

USE KainosJobs_AdamM;

DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS token;
DROP TABLE IF EXISTS job_role;

CREATE TABLE role (
    role_id int PRIMARY KEY AUTO_INCREMENT,
    role_name varchar(30) NOT NULL
);

CREATE TABLE user (
    -- COLLATE utf8mb4_bin ensures case sensitivity
    email varchar(30) PRIMARY KEY COLLATE utf8mb4_bin,
    role_id varchar(30) NOT NULL REFERENCES role (role_id),
    salt char(8) NOT NULL,
    secured_password varchar(100) NOT NULL
);

CREATE TABLE token (
    email varchar(30) REFERENCES user (email),
    token varchar(64) NOT NULL,
    expiry_date DATETIME NOT NULL
);

CREATE TABLE job_role (
	job_role_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    job_role_name varchar(64) NOT NULL
);
