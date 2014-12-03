CREATE DATABASE `leavemgr`
CHARACTER SET 'utf8'
COLLATE 'utf8_general_ci';
USE leavemgr;
CREATE TABLE dept (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dept_id VARCHAR(20) NOT NULL,
	dept_name VARCHAR(30),
	manager_id VARCHAR(20),
	tel VARCHAR(20),
	email VARCHAR(25))DEFAULT CHARSET=utf8;

INSERT INTO dept(dept_id,dept_name,manager_id,tel,email) VALUES('20001','开发融资部','200010301001','010-888001','dept1@163.com');
INSERT INTO dept(dept_id,dept_name,manager_id,tel,email) VALUES('20002','财务部','200010301003','010-888002','dept2@163.com');
INSERT INTO dept(dept_id,dept_name,manager_id,tel,email) VALUES('20003','养护科','200010301004','010-888003','dept3@163.com');


CREATE TABLE duty (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	duty_id VARCHAR(20) NOT NULL,
	duty_name VARCHAR(30),
	dept_name VARCHAR(20))DEFAULT CHARSET=utf8;

INSERT INTO duty(duty_id,duty_name,dept_name) VALUES('10001','部长','开发融资部');
INSERT INTO duty(duty_id,duty_name,dept_name) VALUES('10002','科员','开发融资部');
INSERT INTO duty(duty_id,duty_name,dept_name) VALUES('10003','部长','财务部');
INSERT INTO duty(duty_id,duty_name,dept_name) VALUES('10004','科员','财务部');
INSERT INTO duty(duty_id,duty_name,dept_name) VALUES('10005','科长','养护科');

CREATE TABLE staff_info (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	staff_id VARCHAR(20) NOT NULL,
	staff_name VARCHAR(30),
	identity_card VARCHAR(20),
	gender VARCHAR(2),
	entry_date DATE,
	education VARCHAR(20),
	address VARCHAR(40),
	tel VARCHAR(20),
	email VARCHAR(25))DEFAULT CHARSET=utf8;

INSERT INTO staff_info(staff_id,staff_name,identity_card,gender,entry_date,education,address,tel,email)
	VALUES('200010301001','张三','100100200002020011','男','2000-9-1','本科','沈阳和平区文化路11号1号巷','13011111111','jfweiofa1@163.com');
INSERT INTO staff_info(staff_id,staff_name,identity_card,gender,entry_date,education,address,tel,email)
	VALUES('200010301002','张辉','200100200002020011','男','2000-9-2','本科','沈阳和平区文化路11号2号巷','13011111112','jfweiofa2@163.com');
INSERT INTO staff_info(staff_id,staff_name,identity_card,gender,entry_date,education,address,tel,email)
	VALUES('200010301003','陈诚','300100200002020011','男','2000-9-3','硕士','沈阳和平区文化路11号3号巷','13011111113','jfweiofa3@163.com');
INSERT INTO staff_info(staff_id,staff_name,identity_card,gender,entry_date,education,address,tel,email)
	VALUES('200010301004','刘玫','400100200002020011','女','2000-9-4','硕士','沈阳和平区文化路11号4号巷','13011111114','jfweiofa4@163.com');

CREATE TABLE staff_job (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	staff_id VARCHAR(20) NOT NULL,
	staff_name VARCHAR(30),
	password VARCHAR(25) NOT NULL,
	dept_name VARCHAR(30),
	duty_name VARCHAR(30))DEFAULT CHARSET=utf8;

INSERT INTO staff_job(staff_id,staff_name,password,dept_name,duty_name) VALUES('200010301001','张三','123','开发融资部','部长');
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,duty_name) VALUES('200010301002','张辉','456','开发融资部','科员');
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,duty_name) VALUES('200010301003','陈诚','789','财务部','部长');
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,duty_name) VALUES('200010301004','刘玫','124','养护科','科长');

CREATE TABLE message (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,	
	sender_name VARCHAR(30),
	receiver_id INT(20) NOT NULL,
	generate_time DATETIME,
	message_name VARCHAR(30),
	type INT(3),
	content TEXT,
	flag INT(1) DEFAULT 1)DEFAULT CHARSET=utf8;


INSERT INTO message(sender_name,receiver_id,generate_time,message_name,type,content,flag) 
	VALUES('张辉','1','2008-01-29 04:04:36','leave',1,'ask for a leave',1);
INSERT INTO message(sender_name,receiver_id,generate_time,message_name,type,content,flag) 
	VALUES('张辉','1','2008-02-29 04:04:36','leave',2,'ask for a leave again',1);
INSERT INTO message(sender_name,receiver_id,generate_time,message_name,type,content,flag) 
	VALUES('张辉','1','2008-03-29 04:04:36','leave',2,'ask for a leave again',1);

CREATE TABLE leave_info (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,		
	begin_time DATE,
	days INT(10),
	apply_time DATE,
	reason TEXT,
	proposer_id INT(20) NOT NULL,
	proposer_name VARCHAR(30) NOT NULL,
	auditor_id INT(20) NOT NULL,
	auditor_name VARCHAR(30) NOT NULL,
	result INT(1) DEFAULT 0,
	handle_time DATE,
	valid INT(1) DEFAULT 0)DEFAULT CHARSET=utf8;