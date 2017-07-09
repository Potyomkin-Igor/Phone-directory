INSERT INTO types (id, name) VALUES
  (1, 'HOME'),
  (2, 'MOBILE');

INSERT INTO contacts(id, phone, type_id, comment) VALUES
  (1, '+380687321547',2,'It is my contact number'),
  (2, '+380688965214',2,'It is my contact number'),
  (3, '+380680002578',2,'It is my contact number'),
  (4, '4042536',1,'It is my contact home number'),
  (5, '+380683210000',2,'It is my contact number'),
  (6, '4045874',1,'It is my contact home number');

INSERT INTO users (id, first_name, last_name, patronymic, contact_id) VALUES
  (1, 'Ivan', 'Ivanov', 'Ivanovich', 1),
  (2, 'Mark', 'Markov', 'Markovich', 2),
  (3, 'Stas', 'Stasov', 'Stanislavovich', 3),
  (4, 'Ana', 'Karenina', 'Ivanovna', 4),
  (5, 'Michail', 'Mashkov', 'Olegovich', 5),
  (6, 'Michail', 'Mashkov', 'Olegovich', 5),
  (7, 'Michail', 'Mashkov', 'Olegovich', 5),
  (8, 'Michail', 'Mashkov', 'Olegovich', 5),
  (9, 'Michail', 'Mashkov', 'Olegovich', 5),
  (10, 'Alex', 'Nets', 'Konstantinovich', 6);
