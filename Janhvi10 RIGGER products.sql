CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR2(10),
    price DECIMAL(10, 2)
);

CREATE SEQUENCE products_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER products_before_insert
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
    IF :NEW.product_id IS NULL THEN
        SELECT products_seq.NEXTVAL INTO :NEW.product_id FROM dual;
    END IF;
END;
/
INSERT INTO products (product_name, price) VALUES ('Item1', 99.99);

SELECT * FROM products;
