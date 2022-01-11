create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens (name, gender) values ('Ivan', 'м');
insert into teens (name, gender) values ('Petr', 'м');
insert into teens (name, gender) values ('Vasya', 'м');
insert into teens (name, gender) values ('Sasha', 'ж');
insert into teens (name, gender) values ('Masha', 'ж');
insert into teens (name, gender) values ('Anna', 'ж');
insert into teens (name, gender) values ('Olya', 'ж');

select * from teens;

select teens1.name, teens2.name, concat(teens1.name, ' : ', teens2.name)
from teens teens1 cross join teens teens2
where teens1.gender != teens2.gender;
