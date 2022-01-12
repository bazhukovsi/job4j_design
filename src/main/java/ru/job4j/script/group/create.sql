create table devices(
    id serial primary key,
    device_name varchar(255),
    price numeric
);

create table people(
    id serial primary key,
    people_name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(people_name) values ('Sergey');
insert into people(people_name) values ('Elena');
insert into people(people_name) values ('Sasha');

insert into devices(device_name, price) values ('Keyboard', 4.4);
insert into devices(device_name, price) values ('Mouse', 3.5);
insert into devices(device_name, price) values ('Headphones Basic', 2.3);
insert into devices(device_name, price) values ('Headphones BT', 9.2);
insert into devices(device_name, price) values ('Microphone', 4.9);
insert into devices(device_name, price) values ('Microphone Prof', 10.1);

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 2);
insert into devices_people(people_id, device_id) values (1, 3);
insert into devices_people(people_id, device_id) values (1, 4);
insert into devices_people(people_id, device_id) values (1, 5);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (2, 4);
insert into devices_people(people_id, device_id) values (2, 5);
insert into devices_people(people_id, device_id) values (2, 6);
insert into devices_people(people_id, device_id) values (3, 2);
insert into devices_people(people_id, device_id) values (3, 3);
insert into devices_people(people_id, device_id) values (3, 5);

select avg(price) from devices;

select p.people_name, avg(dev.price) from devices_people as dev_p
join devices as dev on dev_p.device_id = dev.id
join people as p on dev_p.people_id = p.id
group by p.people_name;

select p.people_name, avg(dev.price) from devices_people as dev_p
join devices as dev on dev_p.device_id = dev.id
join people as p on dev_p.people_id = p.id
group by p.people_name
having avg(dev.price) > 4;

