--liquibase formatted sql
--changeset InsertRow_sql:306

INSERT INTO users (id, login, password)
VALUES (1, 'petrov', 'petrov');

INSERT INTO users (id, login, password)
VALUES (2, 'ivanov', 'ivanov');

INSERT INTO users (id, login, password)
VALUES (3, 'sidorov', 'sidorov');

INSERT INTO balance (userId, balance, currency)
VALUES (1, 1500, 'USD');

INSERT INTO balance (userId, balance, currency)
VALUES (2, 35000, 'USD');

INSERT INTO balance (userId, balance, currency)
VALUES (3, 2500, 'USD');
