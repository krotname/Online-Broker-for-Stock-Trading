--liquibase formatted sql
--changeset CreateTables_sql:304

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT primary key,
    login VARCHAR,
    password VARCHAR
);

CREATE TABLE IF NOT EXISTS balance
(
    userId BIGINT primary key,
    balance BIGINT,
    currency VARCHAR(255)
);

