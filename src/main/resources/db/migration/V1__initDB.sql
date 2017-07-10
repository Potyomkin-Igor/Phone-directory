CREATE SCHEMA IF NOT EXISTS phone_directory;

-- -----------------------------------------------------
-- Table contacts
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS phone_directory.contacts (
  id      BIGINT      NOT NULL,
  phone   VARCHAR(24) NOT NULL,
  type    VARCHAR(15)     NULL,
  comment VARCHAR     NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS phone_directory.users (
id         BIGINT      NOT NULL,
first_name VARCHAR(20) NOT NULL,
last_name  VARCHAR     NOT NULL,
patronymic VARCHAR     NOT NULL,
contact_id BIGINT      NOT NULL,
PRIMARY KEY (id),
CONSTRAINT CONTACT
FOREIGN KEY (contact_id)
REFERENCES phone_directory.contacts (id)
ON UPDATE CASCADE
);