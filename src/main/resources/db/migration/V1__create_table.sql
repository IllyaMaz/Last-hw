create table product(
	id uuid default gen_random_uuid() primary key,
	name varchar(50),
	price decimal
);

create table manufacturer(
	id uuid default gen_random_uuid() primary key,
	name varchar(50),
	product_id uuid,
	foreign key (product_id) references product(id)
);

create table role(
	id uuid default gen_random_uuid() primary key,
	name varchar(50)
);

create table users(
	id uuid default gen_random_uuid() primary key,
	email varchar(250),
	password varchar(250),
	first_name varchar(100),
	last_name varchar(100),
	role_id uuid,
	foreign key (role_id) references role(id)
);