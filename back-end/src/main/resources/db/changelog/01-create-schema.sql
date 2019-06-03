create sequence id_sequence start 1 increment by 1;

create table users (
    id bigint primary key default nextval('id_sequence'),
    username varchar(256) unique not null,
    password varchar(20) not null
);

create table filters (
    id bigint primary key default nextval('id_sequence'),
    user_id bigint references users(id) not null,
    category varchar(40) not null,
    hint varchar(150),
    min_price int,
    max_price int,
    rating smallint
);

create table favourites (
    id bigint primary key default nextval('id_sequence'),
    user_id bigint references users(id) not null,
    store varchar(20) not null,
    product_url text not null,
    product_name varchar(150) not null,
    category varchar(40),
    price int,
    rating smallint,
    image_url text
);
