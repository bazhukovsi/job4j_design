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
