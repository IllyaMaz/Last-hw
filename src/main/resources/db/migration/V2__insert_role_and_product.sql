insert into role(id,name)
values ('8778ab7d-ad8c-4bca-a105-05d406f6b3c4','user'),
('d1cec514-7f3b-4191-b81b-1574ad0cb7e4','admin');

insert into manufacturer(id,name)
values ('572bed3e-f89e-4955-8540-00a4e945f9b4','Global'),
('6f37b4fe-7d53-4af9-84e7-2adf41011591','Epam'),
('b4191c95-bff7-484d-9db5-2c0388e66db9','Atb');

insert into product(name,price,id_manufacturer)
values('apple',22.2,'572bed3e-f89e-4955-8540-00a4e945f9b4'),
('shoes',40.50,'6f37b4fe-7d53-4af9-84e7-2adf41011591'),
('pullover',63.2,'b4191c95-bff7-484d-9db5-2c0388e66db9');

insert into users(email,password,first_name,last_name,role_id)
values ('maznichenko@gmail.com','admin','Illya','Maznichenko','d1cec514-7f3b-4191-b81b-1574ad0cb7e4')