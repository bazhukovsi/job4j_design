
CREATE table section(
    id serial primary key,
    section_name varchar(255)
);

create table sportsmans(
    id serial primary key,
    name_sportsman varchar(255),
	surname varchar(255),
    section_id int references section(id)
);
insert into section(section_name) values ('table_tennis');
insert into section(section_name) values ('swimming');
insert into sportsmans(name_sportsman, surname, section_id) VALUES ('Sergey','Bazhukov', 1);
insert into sportsmans(name_sportsman,  surname, section_id) VALUES ('Anna','Ivanova', 2);

select * from sportsmans;

select * from section where id in (select id from sportsmans);