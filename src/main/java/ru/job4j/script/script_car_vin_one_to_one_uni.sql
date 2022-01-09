create table vin(
    id serial primary key,
    nomer varchar(255)
);

create table car(
    id serial primary key,
    car_brand varchar(255),
    vin_id int references vin(id) unique
);