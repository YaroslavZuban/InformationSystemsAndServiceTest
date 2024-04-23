create table equipment_type
(
    id           serial PRIMARY KEY,
    technic_type varchar NOT NULL
);

CREATE SEQUENCE equipment_type_seq;

create table technic
(
    id                    serial PRIMARY KEY,
    equipment_type_id     integer REFERENCES equipment_type (id) NOT NULL,
    name                  varchar                                NOT NULL,
    producer_country      varchar                                NOT NULL,
    company_manufacturers varchar                                NOT NULL,
    online_option         boolean                                NOT NULL,
    installment_option    boolean                                NOT NULL
);

CREATE SEQUENCE technic_seq;

create table model
(
    id                   serial PRIMARY KEY,
    technic_id           integer REFERENCES technic (id) NOT NULL,
    serial_number        varchar UNIQUE                  NOT NULL,
    color                varchar                         NOT NULL,
    size                 integer                         NOT NULL,
    price                numeric                         NOT NULL,
    product_availability boolean                         NOT NULL
);

CREATE SEQUENCE model_seq;

create table televisions
(
    id         serial PRIMARY KEY,
    model_t_id integer REFERENCES model (id) NOT NULL,
    category   varchar                       NOT NULL,
    technology varchar                       NOT NULL
);

CREATE SEQUENCE televisions_seq;

create table vacuum_cleaners
(
    id                      serial PRIMARY KEY,
    model_v_id              integer REFERENCES model (id) NOT NULL,
    dust_collector_capacity integer                       NOT NULL,
    mode_count              integer                       NOT NULL
);

CREATE SEQUENCE vacuum_cleaners_seq;

create table refrigerators
(
    id              serial PRIMARY KEY,
    model_r_id      integer REFERENCES model (id) NOT NULL,
    doors_count     integer                       NOT NULL,
    compressor_type varchar                       NOT NULL
);

CREATE SEQUENCE refrigerators_seq;

create table smartphones
(
    id           serial PRIMARY KEY,
    model_s_id   integer REFERENCES model (id) NOT NULL,
    memory       varchar                       NOT NULL,
    camera_count integer                       NOT NULL
);

CREATE SEQUENCE smartphones_seq;

create table computers
(
    id             serial PRIMARY KEY,
    model_c_id     integer REFERENCES model (id) NOT NULL,
    category       varchar                       NOT NULL,
    processor_type varchar                       NOT NULL
);

CREATE SEQUENCE computers_seq;


INSERT INTO equipment_type (technic_type)
VALUES ('Телевизоры'),
       ('Пылесосы'),
       ('Холодильники'),
       ('Смартфоны'),
       ('Компьютеры');

INSERT INTO technic (equipment_type_id, name, producer_country, company_manufacturers, online_option,
                     installment_option)
VALUES (1, 'Samsung QLED 4K', 'Республика Корея', 'Samsung Electronics', true, true),
       (2, 'Philips Performer Compact', 'Нидерланды', 'Philips', true, false),
       (3, 'Bosch KGN39VW2A', 'Германия', 'Bosch', true, true),
       (4, 'iPhone 13 Pro', 'США', 'Apple', true, true),
       (5, 'Dell XPS 13', 'США', 'Dell Technologies', true, false);

INSERT INTO model (technic_id, serial_number, color, size, price, product_availability)
VALUES (1, 'SN123456', 'Чёрный', 55, 1299.99, true),
       (2, 'SN789012', 'Красный', 40, 199.99, true),
       (3, 'SN345678', 'Белый', 180, 599.99, true),
       (4, 'SN901234', 'Серебристый', 6.1, 999.99, true),
       (5, 'SN567890', 'Серый', 13.4, 1499.99, true);

INSERT INTO televisions (model_t_id, category, technology)
VALUES (1, 'QLED', '4K'),
       (1, 'QLED', '4K'),
       (1, 'QLED', '4K');

INSERT INTO vacuum_cleaners (model_v_id, dust_collector_capacity, mode_count)
VALUES (2, 2, 3),
       (2, 2, 3),
       (2, 2, 3);

INSERT INTO refrigerators (model_r_id, doors_count, compressor_type)
VALUES (3, 2, 'Инверторный'),
       (3, 2, 'Инверторный'),
       (3, 2, 'Инверторный');

INSERT INTO smartphones (model_s_id, memory, camera_count)
VALUES (4, '256GB', 3),
       (4, '512GB', 3),
       (4, '1TB', 3);

INSERT INTO computers (model_c_id, category, processor_type)
VALUES (5, 'Ноутбук', 'Intel Core i7'),
       (5, 'Ноутбук', 'Intel Core i9'),
       (5, 'Ноутбук', 'Intel Core i5');

