--liquibase formatted sql
--changeset CreateTables_sql:304

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT primary key,
    login VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS balance
(
    user_id BIGINT primary key,
    balance BIGINT,
    currency VARCHAR(255)
);

