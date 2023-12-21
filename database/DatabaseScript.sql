CREATE DATABASE IF NOT EXISTS KainosJobs_AdamM;

USE KainosJobs_AdamM;

CREATE TABLE role (
    role_id int PRIMARY KEY AUTO_INCREMENT,
    role_name varchar(30) NOT NULL
);

CREATE TABLE user (
    -- COLLATE utf8mb4_bin ensures case sensitivity
    email varchar(30) PRIMARY KEY COLLATE utf8mb4_bin,
    role_id varchar(30) NOT NULL REFERENCES role (role_id),
    secured_password varchar(100) NOT NULL
);

ALTER TABLE user
    DROP COLUMN salt;

DROP TABLE IF EXISTS token;

-- Remove case sensitivity as emails should be case in-sensitive
ALTER TABLE user
    MODIFY COLUMN email varchar(30) COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE job_role (
	job_role_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    job_role_name varchar(64) NOT NULL
);

-- update job_roles table
ALTER TABLE job_roles
    ADD COLUMN specification_summary varchar(4000),
    ADD COLUMN sharepoint_link varchar(1000);
