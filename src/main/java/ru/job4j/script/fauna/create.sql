create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('fish', 22000, date '950-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('whitefish', 19000, date '1000-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('fishblack', 22000, null);
insert into fauna(name, avg_age, discovery_date)
values ('lion', 20000, date '1980-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('tiger', 15000, date '1200-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('shark', 12000, date '1350-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('whale', 19000, date '1500-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('snake', 12000, null);
insert into fauna(name, avg_age, discovery_date)
values ('bear', 1100, date '1400-01-01');