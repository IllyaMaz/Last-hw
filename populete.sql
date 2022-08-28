insert into product(name,price)
values('apple',22.2),
('shoes',40.50),
('pullover',63.2);

insert into manufacturer(name,product_id)
values ('Global','572bed3e-f89e-4955-8540-00a4e945f9b4'),
('Epam','6f37b4fe-7d53-4af9-84e7-2adf41011591'),
('Atb','b4191c95-bff7-484d-9db5-2c0388e66db9');

insert into role(name)
values ('user'),
('admin');

insert into users(email,password,first_name,last_name,role_id)
values ('maznichenko@gmail.com','admin','Illya','Maznichenko','d1cec514-7f3b-4191-b81b-1574ad0cb7e4')