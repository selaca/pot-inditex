-- ------------------------------------------------------------------------------------
-- SQL Script in order to initilize default data on H2 database
-- ------------------------------------------------------------------------------------

-- Creates table PRICES
CREATE TABLE PRICES(
    ID BIGINT PRIMARY KEY NOT NULL,
    BRAND_ID INT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL ,
    PRICE_LIST INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE FLOAT NOT NULL,
    CURR VARCHAR(3) NOT NULL  );

-- Insert test data on PRICES table
INSERT INTO PRICES VALUES(
    1, 1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES VALUES(
    2, 1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES VALUES(
    3, 1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES VALUES(
    4, 1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');
