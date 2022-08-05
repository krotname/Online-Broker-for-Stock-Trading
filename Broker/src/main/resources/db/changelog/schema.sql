--liquibase formatted sql
--changeset CreateTables_sql:11

CREATE TABLE IF NOT EXISTS books
(
    id BIGINT primary key,
    name VARCHAR NOT NULL,
    author_id BIGINT,
    genre_id BIGINT
);

CREATE TABLE IF NOT EXISTS authors
(
    id BIGINT primary key,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS genres
(
    id BIGINT,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS comments
(
    id BIGINT primary key,
    content VARCHAR NOT NULL,
    book_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT primary key,
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role VARCHAR NOT NULL
);
--
-- create sequence authors_id_seq;
--
-- alter table authors
--     alter column id set default nextval('public.authors_id_seq'::regclass);
--
-- alter sequence authors_id_seq owned by authors.id;



