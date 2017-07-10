-- INSERT INTO types (id, name) VALUES
--   (1, 'HOME'),
--   (2, 'MOBILE'),
--   (3, '');

INSERT INTO contacts(id, phone, type, comment) VALUES
  (1, '+380687321547','MOBILE','It is my contact number'),
  (2, '+380688965214','MOBILE','It is my contact number'),
  (3, '+380680002578','MOBILE','It is my contact number'),
  (4, '4042536','HOME','It is my contact home number'),
  (5, '+380683210000','','It is my contact number'),
  (6, '71-11-89','HOME','It is my contact number'),
  (7, '+380683210000','','It is my contact number'),
  (8, '+380683219999','MOBILE','It is my contact number'),
  (9, '+380683210858','','It is my contact number'),
  (10, '+380685053114','SOME_TO CHANGE','It is my contact number');


INSERT INTO users (id, first_name, last_name, patronymic, contact_id) VALUES
  (1, 'Ivan', 'Ivanov', 'Ivanovich', 1),
  (2, 'Mark', 'Markov', 'Markovich', 2),
  (3, 'Stas', 'Stasov', 'Stanislavovich', 3),
  (4, 'Ana', 'Karenina', 'Ivanovna', 4),
  (5, 'Michail', 'Mashkov', 'Olegovich', 5),
  (6, 'Snezhana', 'Ishakova', 'Olegovich', 6),
  (7, 'Andrey', 'Elchin', 'Jones', 7),
  (8, 'Vity', 'Nado', 'Vuity', 8),
  (9, 'Privet', 'Davno', 'Nevidel', 9),
  (10, 'Alex', 'Nets', 'Konstantinovich', 10);
