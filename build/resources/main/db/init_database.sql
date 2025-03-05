create database kiemtra;
use kiemtra;

create table LoaiMatBang (
    id int primary key auto_increment,
    tenLoaiMatBang varchar(50) not null
);

create table MatBang
(
    maMatBang     VARCHAR(50) primary key,
    tenMatBang    varchar(50) not null,
    diaChi        varchar(50) not null,
    dienTich      varchar(50) not null,
    loaiMatBangId int,
    giaThue       double       not null,
    ngayBatDau    date         not null,
    foreign key  (loaiMatBangId) references LoaiMatBang (id)
);

insert into LoaiMatBang (tenLoaiMatBang)
values ('Khách sạn'),
       ('Nhà hàng'),
       ('Trung tâm thuơng mại');

insert into MatBang (maMatBang, tenMatBang, diaChi, dienTich, loaiMatBangId, giaThue, ngayBatDau)
values ('MB001', 'Tên Mặt Bằng 1', 'Đường 605', '500m2', 1, 5000000, '2025-10-01'),
       ('MB002', 'Tên Mặt Bằng 2', 'Đường Ông Ích Khiêm', '600m2', 2, 6000000, '2025-09-15'),
       ('MB003', 'Tên Mặt Bằng 3', 'ĐƯờng Lê Lợi', '1200m2', 3, 7000000, '2025-11-01');