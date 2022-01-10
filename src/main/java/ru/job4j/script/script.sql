
CREATE TABLE car(
      id serial primary key,
      name_car varchar(255),
	  engine real,
      description text)

insert into car (name, engine, description) values
('Seat Altea Freetrack', 2.0, 'Spanish auto');

update car set description = 'Spanish auto full drive';

delete from car;