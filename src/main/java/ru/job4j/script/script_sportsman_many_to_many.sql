create table sections(
    id serial primary key,
    section_name varchar(255)
);

create table sportsmans(
    id serial primary key,
    name_sportsmen varchar(255),
	surname varchar(255)
);

create table sportsmans_sections(
     id serial primary key,
     sportsmans_id int references sportsmans(id),
     sections_id int references sections(id)
);

insert into sections(section_name) values ('table_tennis');
insert into sections(section_name) values ('swimming');
insert into sections(section_name) values ('voleyball');

insert into sportsmans(name_sportsmen, surname) values ('Sergey','Bazhukov');
insert into sportsmans(name_sportsmen,  surname) values ('Anna','Ivanova');
insert into sportsmans(name_sportsmen,  surname) values ('Sasha','Bazhukova');

insert into sportsmans_sections(sportsmans_id, sections_id) values (1, 1);
insert into sportsmans_sections(sportsmans_id, sections_id) values (1, 2);
insert into sportsmans_sections(sportsmans_id, sections_id) values (1, 3);
insert into sportsmans_sections(sportsmans_id, sections_id) values (2, 1);
insert into sportsmans_sections(sportsmans_id, sections_id) values (2, 3);
insert into sportsmans_sections(sportsmans_id, sections_id) values (3, 2);

select * from sportsmans;

select * from sections;

select * from sportsmans_sections;
