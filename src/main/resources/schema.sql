create table sensor
(
    id          int generated always as identity,
    name        varchar(30) not null,
    model       varchar(15) not null,
    range_from  int,
    range_to    int,
    type_id     int,
    unit_id     int,
    location    varchar(40),
    description varchar(200),
    PRIMARY KEY (id),
    constraint fk_type
        foreign key (type_id)
            references sensor_type(type_id)
            ON DELETE SET NULL,
    constraint fk_unit
        foreign key (unit_id)
            references sensor_unit(unit_id)
            ON delete SET NULL
);

create table sensor_type
(
    type_id   int generated always as identity,
    type_name varchar(10),
    PRIMARY KEY (type_id)
);

create table sensor_unit
(
    unit_id   int generated always as identity,
    unit_name varchar(10),
    PRIMARY KEY (unit_id)
);