--liquibase formatted sql
--changeset CreateTables_sql:1

CREATE TABLE IF NOT EXISTS bond_holder
(
    id BIGINT primary key,
    user_id BIGINT
);

CREATE TABLE IF NOT EXISTS bond_type
(
    id BIGINT primary key,
    bond_code VARCHAR NOT NULL,
    bond_name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS bond_balance
(
    bond_holder_id BIGINT primary key,
    balance BIGINT,
    bond_type_id BIGINT
);

CREATE TABLE IF NOT EXISTS course
(
    id BIGINT primary key,
    bond_type_id BIGINT,
    bond_current_course BIGINT NOT NULL
);

