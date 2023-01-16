create table if not exists car (
id int auto_increment primary key,
name varchar(255),
color varchar(255),
year_of_production int
);

create table if not exists parking (
id int auto_increment primary key,
capacity int
);