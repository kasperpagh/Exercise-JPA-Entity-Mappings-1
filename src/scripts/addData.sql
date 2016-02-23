INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-ged');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-llama');
SET @book2 = LAST_INSERT_ID();


insert into CUSTOMER (id, firstName, lastName, CustomerType) values (null, 'bob', 'bobsen', 'GOLD');
set @customer1 = LAST_INSERT_ID();
insert into CUSTOMER (id, firstName, lastName, CustomerType) values (null, 'jan', 'jansen', 'SILVER');
set @customer2 = LAST_INSERT_ID();
insert into CUSTOMER (id, firstName, lastName, CustomerType) values (null, 'ole', 'olesen', 'IRON');
set @customer3 = LAST_INSERT_ID();



