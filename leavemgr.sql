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
	dept_name VARCHAR(20),
	rank INT(3))DEFAULT CHARSET=utf8;

INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10000','总经理','总经理',1);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10000','副总经理','副总经理',2);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10001','部长','开发融资部',3);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10002','部员','开发融资部',4);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10003','部长','财务部',3);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10004','部员','财务部',4);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10005','科长','养护科',3);
INSERT INTO duty(duty_id,duty_name,dept_name,rank) VALUES('10006','科员','养护科',4);

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
	VALUES('200010301000','杨森','100100200002020010','男','2000-9-10','博士','沈阳和平区文化路11号0号巷','13011111110','jfweiofa0@163.com');
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
	rank INT(3))DEFAULT CHARSET=utf8;

INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301000','杨森','123','总经理',1);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301001','张三','123','开发融资部',3);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301002','张辉','123','开发融资部',4);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301003','陈诚','123','财务部',3);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301004','陈达','123','财务部',4);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301005','刘玫','123','养护科',3);
INSERT INTO staff_job(staff_id,staff_name,password,dept_name,rank) VALUES('200010301006','刘美','123','养护科',4);

CREATE TABLE message (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,	
	sender_name VARCHAR(30),
	receiver_id INT(20) NOT NULL,
	generate_time DATETIME,
	message_name VARCHAR(30),
	type INT(3),
	content TEXT,
	flag INT(1) DEFAULT 1)DEFAULT CHARSET=utf8;


CREATE TABLE leave_info (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,		
	begin_time DATE,
	days INT(10),
	apply_time DATETIME,
	reason TEXT,
	proposer_id INT(20) NOT NULL,
	proposer_name VARCHAR(30) NOT NULL,
	auditor_id INT(20) NOT NULL,
	auditor_name VARCHAR(30) NOT NULL,
	result INT(1) DEFAULT 0,
	handle_time DATETIME,
	valid INT(1) DEFAULT 0)DEFAULT CHARSET=utf8;