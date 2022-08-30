--liquibase formatted sql
--changeset InsertRow_sql:3

INSERT INTO bond_holder (id, user_id)
VALUES (1, 1);

INSERT INTO bond_holder (id, user_id)
VALUES (2, 2);

INSERT INTO bond_holder (id, user_id)
VALUES (3, 3);


INSERT INTO bond_type (id,  bond_code, bond_name)
VALUES (1, 'MGNT', 'МАГНИТ');

INSERT INTO bond_type (id,  bond_code, bond_name)
VALUES (2, 'AKRN', 'АКРОН');

INSERT INTO bond_type (id,  bond_code, bond_name)
VALUES (3, 'ROSB', 'РОСБАНК');

INSERT INTO bond_type (id,  bond_code, bond_name)
VALUES (4, 'KMAZ', 'КАМАЗ');

INSERT INTO bond_type (id,  bond_code, bond_name)
VALUES (5, 'LKOH', 'ЛУКОЙЛ');


INSERT INTO course (id, bond_type_id,  bond_current_course)
VALUES (1, 1, 545900);

INSERT INTO course (id, bond_type_id,  bond_current_course)
VALUES (2, 2, 17470);

INSERT INTO course (id, bond_type_id,  bond_current_course)
VALUES (3, 3, 11200);

INSERT INTO course (id, bond_type_id,  bond_current_course)
VALUES (4, 4, 9000);

INSERT INTO course (id, bond_type_id,  bond_current_course)
VALUES (5, 5, 41150);


INSERT INTO bond_balance (bond_holder_id,  balance, bond_type_id)
VALUES (1, 100, 5);

INSERT INTO bond_balance (bond_holder_id,  balance, bond_type_id)
VALUES (2, 200, 4);

INSERT INTO bond_balance (bond_holder_id,  balance, bond_type_id)
VALUES (3, 130, 3);

INSERT INTO bond_balance (bond_holder_id,  balance, bond_type_id)
VALUES (4, 400, 1);
