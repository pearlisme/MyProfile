

CREATE TABLE user (
--id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
id INT(10) PRIMARY KEY ,
active int(2),
user_name VARCHAR(30) NOT NULL,
name VARCHAR(30) NOT NULL,
email VARCHAR(50),
password varchar(50)
)

create table role (
id int (10) primary key ,
role_name varchar (20)
)

create table user_role(
user_id int(10) primary key ,
role_id int(10)
)
