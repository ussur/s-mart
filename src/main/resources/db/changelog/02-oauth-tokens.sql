create table oauth_access_tokens (
    authentication_id varchar(256) primary key not null,
    token_id varchar(256),
    token bytea,
    username varchar(256),
    client_id varchar(256),
    authentication bytea,
    refresh_token varchar(256)
);

create table oauth_refresh_token (
    token_id varchar(256),
    token bytea,
    authentication bytea
);