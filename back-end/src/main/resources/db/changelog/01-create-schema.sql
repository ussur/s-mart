create sequence id_sequence;

create table users (
    id bigint primary key default nextval('id_sequence'),
    email varchar(80) unique not null
);

create table filters (
    id bigint primary key default nextval('id_sequence'),
    category varchar(40) not null,
    hint varchar(150),
    min_price int,
    max_price int,
    rating smallint
);

create table preferences (
    id bigint primary key default nextval('id_sequence'),
    user_id bigint references users(id) unique not null,
    notifications_on boolean not null default false
);

create table notifications (
    id bigint primary key default nextval('id_sequence'),
    preferences_id bigint references preferences(id) unique not null,
    filters_id bigint references filters(id) not null,
    frequency interval not null default '1 day'
);

create table favourites (
    id bigint primary key default nextval('id_sequence'),
    store varchar(20) not null,
    product_id varchar(100) not null,
    product_name varchar(150) not null,
    min_price int not null,
    max_price int not null,
    image_url text
);