create table producer
(
    id varchar(255) not null
        primary key,
    name varchar(255) null
);

create table product
(
    id varchar(255)   not null
        primary key,
    name        varchar(255)   null,
    price       decimal(19, 2) null,
    producer_id varchar(255)   null,
    foreign key (producer_id) references producer (id)
);

create table role
(
    id varchar(255) not null
        primary key,
    name varchar(255) null
);

create table user
(
    id varchar(255) not null
        primary key,
    email      varchar(255) null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    password   varchar(255) null
);

create table role_users
(
    roles_id varchar(255) not null,
    users_id varchar(255) not null,
    foreign key (users_id) references user (id),
    foreign key (roles_id) references role (id)
);

