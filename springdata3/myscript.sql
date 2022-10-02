drop database if exists studentDB;
create database studentDB;
use studentDB;
create table student(
  roll integer PRIMARY key,
  name varchar(30),
  marks integer
 );

insert into student values(1,'Suresh',60);
commit;
select * from student;

