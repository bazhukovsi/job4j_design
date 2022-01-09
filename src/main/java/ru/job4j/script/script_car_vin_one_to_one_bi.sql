
CREATE TABLE vin(
    id serial primary key,
    nomer varchar(255)
    );

CREATE TABLE car(
    id serial primary key,
    car_brand varchar(255)
);

CREATE TABLE car_vin(
    id serial primary key,
    car_id int references car(id) unique,
    vin_id int references vin(id) unique
);
