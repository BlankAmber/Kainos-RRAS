-- Create the database
CREATE DATABASE IF NOT EXISTS KainosJobs_AdamM;

-- Use the database
USE KainosJobs_AdamM;

DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS token;

CREATE TABLE role (
    role_id int PRIMARY KEY AUTO_INCREMENT,
    role_name varchar(30) NOT NULL
);

CREATE TABLE user (
    username varchar(30) PRIMARY KEY COLLATE utf8mb4_bin,
    role_id varchar(30) NOT NULL REFERENCES role (role_id),
    salt char(8) NOT NULL,
    secured_password varchar(100) NOT NULL
);

CREATE TABLE token (
    username varchar(30) REFERENCES user (username),
    token varchar(64) NOT NULL,
    expiry_date DATETIME NOT NULL
);

CREATE TABLE job_role(
	job_role_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    job_role_name varchar(64) NOT NULL
);

-- update job_role table
ALTER TABLE job_role
ADD COLUMN specification_summary VARCHAR(4000),
ADD COLUMN sharepoint_link VARCHAR(1000);



ALTER TABLE job_role
ADD COLUMN job_family_id int,
ADD CONSTRAINT fk_job_role_job_family
FOREIGN KEY (job_family_id) REFERENCES job_family(job_family_id);



-- creation of job_family_group table
CREATE TABLE job_family_group (
    job_family_group_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    job_family_group_name varchar(64) NOT NULL
);

-- creation of job_family table
CREATE TABLE job_family (
    job_family_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    job_family_name varchar(64) NOT NULL,
    job_family_group_id int,
    FOREIGN KEY (job_family_group_id) REFERENCES job_family_group(job_family_group_id)
);

 CREATE TABLE management_level (
    management_level_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    management_level_name varchar(64) NOT NULL
);

ALTER TABLE job_role
ADD COLUMN management_level_id int,
ADD CONSTRAINT fk_job_role_management_level
FOREIGN KEY (management_level_id) REFERENCES management_level(management_level_id);

ALTER TABLE job_role
ADD COLUMN responsibilities VARCHAR(4000);
