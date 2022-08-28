insert into role(id,name)
values ('8778ab7d-ad8c-4bca-a105-05d406f6b3c4','user'),
('d1cec514-7f3b-4191-b81b-1574ad0cb7e4','admin');

insert into product(id,name,price)
values('572bed3e-f89e-4955-8540-00a4e945f9b4','apple',22.2),
('6f37b4fe-7d53-4af9-84e7-2adf41011591','shoes',40.50),
('b4191c95-bff7-484d-9db5-2c0388e66db9','pullover',63.2);

insert into manufacturer(name,product_id)
values ('Global','572bed3e-f89e-4955-8540-00a4e945f9b4'),
('Epam','6f37b4fe-7d53-4af9-84e7-2adf41011591'),
('Atb','b4191c95-bff7-484d-9db5-2c0388e66db9');

insert into users(email,password,first_name,last_name,role_id)
values ('maznichenko@gmail.com','admin','Illya','Maznichenko','d1cec514-7f3b-4191-b81b-1574ad0cb7e4')