select * from students;
select name, course, speciality from students;
select * from students where course = 2;
select * from students where course != 2;
select * from students where name is null;
select * from students where name is not null;
select * from students where enroll_date > '01.08.2020';
select * from students where course > 2 and course < 5;
select * from students where name like 'D%';
select * from students where name like '%E';
select * from students where name like 'D%' and course > 2;
select * from students where name like 'D%' or course > 2;
select current_date;
select current_date > '10.09.2020';
select current_date > '11.01.2022';
select current_date + interval '1 hour';
select current_date + interval '1 month';
select current_date + interval '1 year';
select * from students order by speciality asc;
select * from students order by speciality desc;
select * from students where course < 4 order by course asc;
select distinct course from students;
select distinct name from students;
select distinct course from students;
select * from students limit 5;
select * from students limit 10;