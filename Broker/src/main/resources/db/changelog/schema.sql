--liquibase formatted sql
--changeset CreateTables_sql:5

CREATE TABLE books
(
    id BIGINT primary key AUTO_INCREMENT,
    name VARCHAR NOT NULL,
    author_id BIGINT,
    genre_id BIGINT
);

CREATE TABLE authors
(
    id BIGINT primary key AUTO_INCREMENT,
    name VARCHAR NOT NULL
);

CREATE TABLE genres
(
    id BIGINT primary key AUTO_INCREMENT,
    name VARCHAR NOT NULL
);

CREATE TABLE comments
(
    id BIGINT primary key AUTO_INCREMENT,
    content VARCHAR NOT NULL,
    book_id BIGINT NOT NULL
);

CREATE TABLE users
(
    id BIGINT primary key AUTO_INCREMENT,
    login VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    role VARCHAR NOT NULL
);


