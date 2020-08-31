create database District;

create table MinistryDetails
(
id int identity(1,1),
name varchar(40),
email varchar(40),
username varchar(40),
dob varchar(50),
time varchar(30),
password varchar(40),
conpassword varchar(40),
address varchar(60),
mobileno varchar(20)
)
select * from MinistryDetails;

	insert into MinistryDetails(name, email,username, dob, [time], password, conpassword, address, mobileno) values('jhgjhg','gjhghjghj','fjhfhjfjh','02/01/2018', '0405', 'hjvhjvh','hjvhjghghj','hghjgjhgh', '8789878767');
	drop table MinistryDetails;