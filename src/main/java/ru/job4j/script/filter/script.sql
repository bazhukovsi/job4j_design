create table type(
	id serial primary key,
	type_name varchar(255)
);

create table product(
	id serial primary key,
	product_name varchar(255),
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(type_name) values ('СЫР');
insert into type(type_name) values ('МОРОЖЕНОЕ');
insert into type(type_name) values ('МОЛОКО');
insert into type(type_name) values ('РЫБА');

insert into product(product_name, type_id, expired_date, price) values ('сыр1', 1, '2022-01-01', 500);
insert into product(product_name, type_id, expired_date, price) values ('сыр2', 1, '2022-01-01', 600);
insert into product(product_name, type_id, expired_date, price) values ('сыр3', 1, '2022-01-15', 200);
insert into product(product_name, type_id, expired_date, price) values ('мороженое хорошее', 2, '2022-01-15', 50);
insert into product(product_name, type_id, expired_date, price) values ('хорошше мороженое', 2, '2022-01-21', 70);
insert into product(product_name, type_id, expired_date, price) values ('мороженое', 2, '2022-01-20', 200);
insert into product(product_name, type_id, expired_date, price) values ('мороженое холодное', 2, '2022-01-15', 180);
insert into product(product_name, type_id, expired_date, price) values ('молоко1', 3, '2022-01-15', 49);
insert into product(product_name, type_id, expired_date, price) values ('молоко2', 3, '2022-01-15', 57);
insert into product(product_name, type_id, expired_date, price) values ('молоко3', 3, '2022-01-20', 85);
insert into product(product_name, type_id, expired_date, price) values ('молоко4', 3, '2022-01-15', 60);
insert into product(product_name, type_id, expired_date, price) values ('рыба красная', 4, '2022-01-15', 180);
insert into product(product_name, type_id, expired_date, price) values ('рыба не красная', 4, '2022-01-15', 120);
insert into product(product_name, type_id, expired_date, price) values ('рыба речная', 4, '2022-01-15', 100);
insert into product(product_name, type_id, expired_date, price) values ('рыба морская', 4, '2022-01-15', 250);
insert into product(product_name, type_id, expired_date, price) values ('рыба озерная', 4, '2022-01-15', 150);


select p.product_name as Продукт, t.type_name as Категория from product as p
join type as t
on p.type_id = t.id
group by p.product_name, t.type_name
having t.type_name = 'СЫР';


select product_name from product where product_name like '%мороженое'
or product_name like 'мороженое%'
or product_name like '%мороженое%';

select product_name, expired_date from product
where expired_date < current_date;

select product_name, expired_date from product
where expired_date < current_date;

select product_name, price from product
where price = (select max(price) from product);

select t.type_name, count(p.product_name) from product as p
join type as t
on p.type_id = t.id
group by t.type_name;

select p.product_name from product as p
join type as t
on p.type_id = t.id
group by p.product_name, t.type_name
having t.type_name = 'СЫР'
or t.type_name = 'МОЛОКО';

select t.type_name, count(p.product_name) from product as p
join type as t
on p.type_id = t.id
group by t.type_name
having count(p.product_name) < 10;

select * from product as p
join type as t
on p.type_id = t.id;