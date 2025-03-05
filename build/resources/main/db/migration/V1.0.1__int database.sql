create table clazz
(
    id int auto_increment primary key,
    name varchar(10) not null
);


create table student
(
    id int auto_increment primary key,
    name varchar(10) not null,
    score double,
    clazz_id int,
    foreign key (clazz_id) references clazz(id)
);




