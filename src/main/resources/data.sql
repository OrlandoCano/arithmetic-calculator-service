insert into USERS (USERNAME, PASSWORD, ENABLED) values ('ocano@company.xyz', '$2a$12$uBrHpJB27j/aEgIPiIWleOTBMm/OWMLEgA8JYTgykybB7ZGOiYasu', 1);
insert into USERS (USERNAME, PASSWORD, ENABLED) values ('ocano2@company.xyz', '$2a$12$uBrHpJB27j/aEgIPiIWleOTBMm/OWMLEgA8JYTgykybB7ZGOiYasu', 1);
insert into USERS (USERNAME, PASSWORD, ENABLED) values ('ocano3@company.xyz', '$2a$12$uBrHpJB27j/aEgIPiIWleOTBMm/OWMLEgA8JYTgykybB7ZGOiYasu', 0);
INSERT INTO USER_ROLES (USERNAME, ROLENAME) VALUES ('ocano@company.xyz', 'ROLE_ADMIN');
INSERT INTO USER_ROLES (USERNAME, ROLENAME) VALUES ('ocano2@company.xyz', 'ROLE_USER');
INSERT INTO USER_ROLES (USERNAME, ROLENAME) VALUES ('ocano3@company.xyz', 'ROLE_USER');


insert into OPERATIONS(TYPE, COST) values ('ADDITION', 1.25);
insert into OPERATIONS(TYPE, COST) values ('SUBTRACTION', 1.25);
insert into OPERATIONS(TYPE, COST) values ('MULTIPLICATION', 1.25);
insert into OPERATIONS(TYPE, COST) values ('DIVISION', 1.25);
insert into OPERATIONS(TYPE, COST) values ('SQUARE_ROOT', 1.25);
insert into OPERATIONS(TYPE, COST) values ('RANDOM_STRING', 1.25);

insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('8c913748-5cb6-4021-8127-4c64e7ac1e87', 'ocano@company.xyz', 1.25, 50.99, 'Addition Applied Result=20.5', CURRENT_TIMESTAMP(), 1);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('8c913748-5cb6-4021-8127-4c64e7ac1e87', 'ocano@company.xyz', 1.25, 49.99, 'Subtraction Applied Result=10', CURRENT_TIMESTAMP(), 1);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('9664b782-7641-483b-afad-38d15919eb23', 'ocano2@company.xyz', 1.25, 50.99, 'Random String Generated Result=r9qupijbFwGA7g8oEPuW', CURRENT_TIMESTAMP(), 1);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('f60fd49a-d93b-434a-836d-88492168afa7', 'ocano3@company.xyz', 1.25, 50.99, 'The operation ADDITION cannot be applied due insufficient credits', CURRENT_TIMESTAMP(), 1);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('f60fd49a-d93b-434a-836d-88492168afa8', 'ocano3@company.xyz', 1.25, 50.99, 'The operation ADDITION cannot be applied due insufficient credits', CURRENT_TIMESTAMP(), 1);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('f60fd49a-d93b-434a-836d-88492168afa8', 'ocano3@company.xyz', 1.25, 50.99, 'The operation ADDITION cannot be applied due insufficient credits', CURRENT_TIMESTAMP(), 0);
insert into RECORDS(OPERATION_ID, USER_ID, AMOUNT, USER_BALANCE, OPERATION_RESPONSE, CREATED_DATE, ENABLED) values ('f60fd49a-d93b-434a-836d-88492168afa9', 'ocano3@company.xyz', 1.25, 50.99, 'The operation ADDITION cannot be applied due insufficient credits', CURRENT_TIMESTAMP(), 0);
