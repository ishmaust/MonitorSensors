create table sensor_type
(
    type_name varchar(15) not null unique ,
    PRIMARY KEY (type_name)
);

create table sensor_unit
(
    unit_name varchar(15) not null unique ,
    PRIMARY KEY (unit_name)
);

create table sensor
(
    name        varchar(30) not null unique ,
    model       varchar(15) not null,
    range_from  int,
    range_to    int,
    type_name   varchar(15),
    unit_name   varchar(15),
    location    varchar(40),
    description varchar(200),
    PRIMARY KEY (name),
    constraint fk_type
        foreign key (type_name)
            references sensor_type(type_name)
            ON DELETE SET NULL,
    constraint fk_unit
        foreign key (unit_name)
            references sensor_unit(unit_name)
            ON delete SET NULL
);

insert into sensor_type (type_name) VALUES ('pressure'), ('voltage'), ('temperature'), ('humidity');
insert into sensor_unit (unit_name) values ('bar'), ('voltage'), ('celsius'), ('percent');

insert into sensor values ('Barometer', 'ac-23', 22, 45, 'pressure', 'bar', 'kitchen', 'description');