CREATE TABLE IF NOT EXISTS types (
  id   BIGINT      NOT NULL,
  name VARCHAR(25) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contacts (
  id      BIGINT      NOT NULL,
  phone   VARCHAR(24) NOT NULL,
  type_id BIGINT      NULL,
  comment VARCHAR     NULL,
  PRIMARY KEY (id),
  CONSTRAINT TYPE_PHONE
  FOREIGN KEY (type_id) REFERENCES types (id)
  ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS users (
id         BIGINT      NOT NULL,
first_name VARCHAR(20) NOT NULL,
last_name  VARCHAR     NOT NULL,
patronymic VARCHAR     NOT NULL,
contact_id BIGINT      NOT NULL,
PRIMARY KEY (id),
CONSTRAINT CONTACT
FOREIGN KEY (contact_id)
REFERENCES contacts (id)
ON UPDATE CASCADE
);