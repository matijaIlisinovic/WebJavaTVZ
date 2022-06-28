create table if not exists hardware (
    id char(6) unique,
    hardwarename varchar(20) ,
    price decimal(5,2) ,
    hardwaretype varchar(10) ,
    numberof smallint,
    primary key(id)
    );

create table if not exists review (
    id int generated always as identity,
    reviewtitle varchar(50) ,
    reviewtext varchar(1000),
    grade smallint,
    hardware char(6),
    primary key(id),
    constraint fk_hardware foreign key (hardware) references hardware(id)
    );
create table if not exists user (
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null
    );
create table if not exists authority (
    id identity,
    authority_name varchar(100) not null unique
    );
create table if not exists user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
    );