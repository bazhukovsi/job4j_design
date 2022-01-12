create table transmission (
    id serial primary key,
    transmission_name varchar(255)
);

create table car (
	id serial primary key,
	car_name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);


insert into body(body_name) values ('universal');
insert into body(body_name) values ('sedan');
insert into body(body_name) values ('cabriolet');
insert into body(body_name) values ('cupe');
insert into body(body_name) values ('limizin');

insert into engine(engine_name) values ('TFSI');
insert into engine(engine_name) values ('V6');
insert into engine(engine_name) values ('V8');

insert into transmission(transmission_name) values ('hand');
insert into transmission(transmission_name) values ('auto');
insert into transmission(transmission_name) values ('semiauto');

insert into car(car_name, body_id, engine_id, transmission_id) values ('SEAT',1,1,1);
insert into car(car_name, body_id, engine_id, transmission_id) values ('TOYOTA',2,1,2);
insert into car(car_name, body_id, engine_id, transmission_id) values ('SUBARU',3,2,2);
insert into car(car_name, body_id, engine_id, transmission_id) values ('MERS',4,2,1);
insert into car(car_name, body_id, engine_id, transmission_id) values ('BMW',2,2,1);
insert into car(car_name, body_id, engine_id, transmission_id) values ('AUDI',2,2,1);

select c.car_name as Марка, b.body_name as Кузов,
e.engine_name as Двигатель, t.transmission_name as Коробка
from car c
inner join body b
on c.body_id = b.id
inner join engine e
on c.engine_id = e.id
inner join transmission t
on c.transmission_id = t.id;

select e.engine_name
from engine e left outer join car c
on e.id = c.engine_id
where c.engine_id is null;

select b.body_name
from body b left outer join car c
on b.id = c.body_id
where c.body_id is null;

select t.transmission_name
from transmission t left outer join car c
on t.id = c.transmission_id
where c.transmission_id is null;