--   ----------------------------------------------------------------------------------------------
-- Fill contacts table
--   ----------------------------------------------------------------------------------------------
INSERT INTO phone_directory.contacts (id, phone, type, comment) VALUES(1, '+380687321547','MOBILE','Mobile contact number'), (2, '+380688965214','MOBILE','It is my contact number'),(3, '+380680002578','MOBILE','It is my contact number'),(4, '4042536','HOME','It is my contact home number'),(5, '+380683210000','','It is my contact number'),(6, '71-11-89','HOME','It is my contact number'),(7, '+380683210000','','It is my contact number'),(8, '+380683219999','MOBILE','It is my contact number'), (9, '(068)3210858','','It is my contact number'),(10, '+380685053114','SOME_TO CHANGE','It is my contact number');

--   ----------------------------------------------------------------------------------------------
-- Fill users table
--   ----------------------------------------------------------------------------------------------
INSERT INTO phone_directory.users (id, first_name, last_name, patronymic, contact_id) VALUES(1, 'Ivan', 'Ivanov', 'Ivanovich', 1),(2, 'Mark', 'Avreliy', 'Petrovich', 2),(3, 'Stanislav', 'Ezhov', 'Stanislavovich', 3), (4, 'Ana', 'Karenina', 'Ivanovna', 4),(5, 'Michail', 'Mashkov', 'Olegovich', 5),(6, 'Snezhana', 'Ishakova', 'Olegovna', 6), (7, 'Andru', 'Elchin', 'Jones', 7),(8, 'Vity', 'Nado', 'Vuity', 8), (9, 'Erik', 'Prize', 'Smith', 9),(10, 'Alex', 'Nets', 'Konstantinovich', 10);
