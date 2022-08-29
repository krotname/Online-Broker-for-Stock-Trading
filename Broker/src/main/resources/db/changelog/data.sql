--liquibase formatted sql
--changeset InsertRow_sql:2

INSERT INTO users (id, login, password, role)
VALUES (1, 'petrov', 'petrov', 'USER');

INSERT INTO users (id, login, password, role)
VALUES (2, 'ivanov', 'ivanov', 'USER');

INSERT INTO users (id, login, password, role)
VALUES (3, 'sidorov', 'sidorov', 'USER');

INSERT INTO balance (user_id, balance, currency)
VALUES (1, 1500, 'USD');

INSERT INTO balance (user_id, balance, currency)
VALUES (2, 35000, 'USD');

INSERT INTO balance (user_id, balance, currency)
VALUES (3, 2500, 'USD');
