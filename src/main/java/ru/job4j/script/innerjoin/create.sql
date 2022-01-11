create table brand(
    id serial primary key,
    brand_name varchar(255)
);

create table car(
    id serial primary key,
    car_name varchar(255),
    brand_id int references brand(id)
);

insert into brand(brand_name) values ('Toyota');
insert into brand(brand_name) values ('Seat');
insert into brand(brand_name) values ('Kia');

insert into car(car_name, brand_id) values('Prado', 1);
insert into car(car_name, brand_id) values('Camry', 1);
insert into car(car_name, brand_id) values('Rav4', 1);
insert into car(car_name, brand_id) values('Altea Freetrack', 2);
insert into car(car_name, brand_id) values('Lion', 2);
insert into car(car_name, brand_id) values('Rio', 3);

insert into car(car_name) values ('Ziguli');

select * from car
join brand p
on car.brand_id = p.id;

select * from car As Car
inner join brand As Brand
on Car.brand_id = Brand.id;

select c.car_name as Марка, b.brand_name as Производитель
from car as c
inner join brand as b
on c.brand_id = b.id;
