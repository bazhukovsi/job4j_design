
create table department(
	id serial primary key,
	dep_name varchar(255)
);

create table employees(
	id serial primary key,
	emp_name varchar(255),
	dep_id int references department(id)
);

insert into department(dep_name) values ('IT');
insert into department(dep_name) values ('Sale');
insert into department(dep_name) values ('Marketing');
insert into department(dep_name) values ('Department not empoyees');

insert into employees (emp_name, dep_id) values ('Serg', 1);
insert into employees (emp_name, dep_id) values ('Mariya', 1);
insert into employees (emp_name, dep_id) values ('Bob', 2);
insert into employees (emp_name, dep_id) values ('Jhon', 2);
insert into employees (emp_name, dep_id) values ('Vasya', 3);
insert into employees (emp_name, dep_id) values ('Petr', null);
insert into employees (emp_name, dep_id) values ('Eugene', null);
insert into employees (emp_name, dep_id) values ('Sasha', 1);
insert into employees (emp_name, dep_id) values ('Marten Furkad', 2);

select * from department;
select * from employees;

select *
from department d left outer join employees emp
on d.id = emp.dep_id;

select *
from department d right outer join employees emp
on d.id = emp.dep_id;

select *
from department d full outer join employees emp
on d.id = emp.dep_id;

select *
from department d cross join employees emp;

select *
from department d left outer join employees emp
on d.id = emp.dep_id
where emp.emp_name is null;

select emp.id, emp.emp_name, emp.dep_id, d.id, d.dep_name
from employees emp right outer join department d
on d.id = emp.dep_id;

select emp.id, emp.emp_name, emp.dep_id, d.id, d.dep_name
from department d left outer join employees emp
on d.id = emp.dep_id;