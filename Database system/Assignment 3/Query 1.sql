/*DROP TABLE IF EXISTS sales;
CREATE TABLE IF NOT EXISTS sales
(
	purchase_number INT AUTO_INCREMENT,
    date_of_purchase DATE,
    customer_id INT,
    item_code VARCHAR(10),
PRIMARY KEY (purchase_number),
CONSTRAINT customer_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE,
CONSTRAINT check_customer_id CHECK (56>=customer_id>=18)
);
alter table sales
DROP CHECK check_customer_id;

DROP TABLE IF EXISTS items;
CREATE TABLE IF NOT EXISTS items
(
	item_id VARCHAR(255),
    item VARCHAR(255),
    unit_price NUMERIC(10,2),
    company_id VARCHAR(255),
PRIMARY KEY (item_id)
);

DROP TABLE IF EXISTS companies;
CREATE TABLE IF NOT EXISTS companies
(
	company_id VARCHAR(255),
    company_name VARCHAR(255),
    headquaters_phone_number int,
PRIMARY KEY (company_id)
);
DROP TABLE IF exists customers;
CREATE TABLE customers (
 customer_id INT AUTO_INCREMENT,
 first_name VARCHAR(255),
 last_name VARCHAR(255),
 email_address VARCHAR(255),
 number_of_complaints INT default 0,
PRIMARY KEY (customer_id)
);
ALTER TABLE customers
ADD COLUMN gender ENUM('M', 'F') AFTER last_name;
INSERT INTO customers (first_name, last_name, gender, email_address,
number_of_complaints) VALUES ('John', 'Mackinley', 'M', 'john.mckinley@365careers.com', 0);

INSERT INTO customers (first_name, gender, last_name)
value ('Nguyen', 'M', 'Phong');

SELECT * FROM customers;

alter table customers
alter column number_of_complaints drop default;
*/

DROP TABLES companies;
CREATE TABLE companies (
    companies_id 				INT AUTO_INCREMENT,
    companies_name 				VARCHAR(255) DEFAULT 'X',
    headquaters_phone_number 	VARCHAR(255),
PRIMARY KEY (companies_id),
UNIQUE KEY (headquaters_phone_number)
);
ALTER TABLE companies
MODIFY headquaters_phone_number VARCHAR(255) NOT NULL;

ALTER TABLE companies
MODIFY headquaters_phone_number VARCHAR(255) NOT NULL,
ALTER COLUMN companies_name DROP DEFAULT;

ALTER TABLE companies
MODIFY companies_name VARCHAR(255) NULL;

INSERT INTO companies (headquaters_phone_number)
VALUE ('(0243) 661 2258');

