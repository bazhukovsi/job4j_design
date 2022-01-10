select * from car
join brand p
on car.brand_id = p.id;

select * from car As Car
inner join brand As Brand
on Car.brand_id = Brand.id;