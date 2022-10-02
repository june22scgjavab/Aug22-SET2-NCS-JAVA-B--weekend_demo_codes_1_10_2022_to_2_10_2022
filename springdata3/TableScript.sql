drop database if exists customer_db;
create database customer_db;
use  customer_db;

create table customer (
	customer_id BIGINT not null,
	city varchar(10),
	date_of_birth date,
	email_id varchar(20),
	name varchar(20),
	primary key (customer_id)
);


insert into customer (customer_id, city, date_of_birth, email_id,name) values (1001,'Vancouver','1992-01-10','monica@infy.com','Monica');
insert into customer (customer_id, city, date_of_birth, email_id,name) values (1002,'Seattle','1996-04-23','scott@infy.com','Scott');

select * from customer;
commit;
