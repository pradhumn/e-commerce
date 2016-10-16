/*
Created: 10/16/2016
Modified: 10/16/2016
Model: Oracle 10g
Database: Oracle 10g
*/


-- Drop relationships section -------------------------------------------------

ALTER TABLE "basket" DROP CONSTRAINT "Relationship20"
/
ALTER TABLE "basketproducts" DROP CONSTRAINT "Relationship19"
/
ALTER TABLE "basketproducts" DROP CONSTRAINT "Relationship18"
/
ALTER TABLE "address" DROP CONSTRAINT "Relationship15"
/
ALTER TABLE "basket" DROP CONSTRAINT "Relationship6"
/




-- Drop keys for tables section -------------------------------------------------

ALTER TABLE "products" DROP CONSTRAINT "Key6"
/
ALTER TABLE "basketstatus" DROP CONSTRAINT "Key4"
/
ALTER TABLE "basket" DROP CONSTRAINT "Key3"
/
ALTER TABLE "address" DROP CONSTRAINT "Key2"
/
ALTER TABLE "customers" DROP CONSTRAINT "Key1"
/


-- Drop indexes section -------------------------------------------------

DROP INDEX "IX_Relationship18"
/
DROP INDEX "IX_Relationship19"
/
DROP INDEX "IX_Relationship6"
/
DROP INDEX "IX_Relationship20"
/
DROP INDEX "IX_Relationship15"
/


-- Drop tables section ---------------------------------------------------

DROP TABLE "products"
/
DROP TABLE "basketproducts"
/
DROP TABLE "basketstatus"
/
DROP TABLE "basket"
/
DROP TABLE "address"
/
DROP TABLE "customers"
/

-- Create tables section -------------------------------------------------

-- Table customers

CREATE TABLE "customers"(
  "customerid" Integer NOT NULL,
  "firstname" Char(20 ) NOT NULL,
  "lastname" Char(20 ) NOT NULL,
  "email" Char(20 ) NOT NULL,
  "password" Varchar2(30 ) NOT NULL
)
/

-- Add keys for table customers

ALTER TABLE "customers" ADD CONSTRAINT "Key1" PRIMARY KEY ("customerid")
/

-- Table address

CREATE TABLE "address"(
  "addressid" Integer NOT NULL,
  "description" Varchar2(100 ) NOT NULL,
  "zipcode" Integer NOT NULL,
  "country" Char(20 ) NOT NULL,
  "customerid" Integer
)
/

-- Create indexes for table address

CREATE INDEX "IX_Relationship15" ON "address" ("customerid")
/

-- Add keys for table address

ALTER TABLE "address" ADD CONSTRAINT "Key2" PRIMARY KEY ("addressid")
/

-- Table basket

CREATE TABLE "basket"(
  "basketid" Integer NOT NULL,
  "basketstatuscode" Integer NOT NULL,
  "customerid" Integer
)
/

-- Create indexes for table basket

CREATE INDEX "IX_Relationship6" ON "basket" ("customerid")
/

CREATE INDEX "IX_Relationship20" ON "basket" ("basketstatuscode")
/

-- Add keys for table basket

ALTER TABLE "basket" ADD CONSTRAINT "Key3" PRIMARY KEY ("basketid")
/

-- Table basketstatus

CREATE TABLE "basketstatus"(
  "basketstatuscode" Integer NOT NULL,
  "description" Char(20 ) NOT NULL
)
/

-- Add keys for table basketstatus

ALTER TABLE "basketstatus" ADD CONSTRAINT "Key4" PRIMARY KEY ("basketstatuscode")
/

-- Table basketproducts

CREATE TABLE "basketproducts"(
  "basketid" Integer NOT NULL,
  "productid" Integer NOT NULL,
  "quantity" Integer NOT NULL
)
/

-- Create indexes for table basketproducts

CREATE INDEX "IX_Relationship18" ON "basketproducts" ("basketid")
/

CREATE INDEX "IX_Relationship19" ON "basketproducts" ("productid")
/

-- Table products

CREATE TABLE "products"(
  "productid" Integer NOT NULL,
  "name" Char(20 ) NOT NULL,
  "description" Varchar2(30 ) NOT NULL,
  "price" Integer NOT NULL
)
/

-- Add keys for table products

ALTER TABLE "products" ADD CONSTRAINT "Key6" PRIMARY KEY ("productid")
/

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "basket" ADD CONSTRAINT "Relationship6" FOREIGN KEY ("customerid") REFERENCES "customers" ("customerid")
/

ALTER TABLE "address" ADD CONSTRAINT "Relationship15" FOREIGN KEY ("customerid") REFERENCES "customers" ("customerid")
/

ALTER TABLE "basketproducts" ADD CONSTRAINT "Relationship18" FOREIGN KEY ("basketid") REFERENCES "basket" ("basketid")
/

ALTER TABLE "basketproducts" ADD CONSTRAINT "Relationship19" FOREIGN KEY ("productid") REFERENCES "products" ("productid")
/

ALTER TABLE "basket" ADD CONSTRAINT "Relationship20" FOREIGN KEY ("basketstatuscode") REFERENCES "basketstatus" ("basketstatuscode")
/



