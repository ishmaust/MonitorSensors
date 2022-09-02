create table sensor_type
(
    type_name varchar(10) not null unique ,
    PRIMARY KEY (type_name)
);

create table sensor_unit
(
    unit_name varchar(10) not null unique ,
    PRIMARY KEY (unit_name)
);

create table sensor
(
    name        varchar(30) not null unique ,
    model       varchar(15) not null,
    range_from  int,
    range_to    int,
    type_name   varchar(10),
    unit_name   varchar(10),
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

select t from sensor_type as t where t.type_name='type1';

select * from sensor as s where s.name like '%n%';