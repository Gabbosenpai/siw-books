INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('George', 'Orwell', '1903-06-25', '1950-01-21', 'GBR', 1);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Haruki', 'Murakami', '1949-01-12', NULL, 'JPN', 2);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Jane', 'Austen', '1775-12-16', '1817-07-18', 'GBR', 3);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Fyodor', 'Dostoevsky', '1821-11-11', '1881-02-09', 'RUS', 4);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Joanne Kathleen', 'Rowling', '1965-07-31', NULL, 'GBR', 5);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Gabriel', 'García Márquez', '1927-03-06', '2014-04-17', 'COL', 6);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Stephen', 'King', '1947-09-21', NULL, 'USA', 7);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Margaret', 'Atwood', '1939-11-18', NULL, 'CAN', 8);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Umberto', 'Eco', '1932-01-05', '2016-02-19', 'ITA', 9);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Chimamanda Ngozi', 'Adichie', '1977-09-15', NULL, 'NGA', 10);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Lev', 'Tolstoy', '1828-09-09', '1910-11-20', 'RUS', 11);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Franz', 'Kafka', '1883-07-03', '1924-06-03', 'CZE', 12);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Italo', 'Calvino', '1923-10-15', '1985-09-19', 'ITA', 13);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Isabel', 'Allende', '1942-08-02', NULL, 'CHL', 14);
INSERT INTO autore(first_name, last_name, date_of_birth, date_of_death, nationality, immagine_id) VALUES ('Albert', 'Camus', '1913-11-07', '1960-01-04', 'FRA', 15);

INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (1, 1);    -- 1984 - Orwell
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (1, 51);   -- Animal Farm - Orwell
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (51, 101);  -- Norwegian Wood - Murakami
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (51, 151);  -- Kafka on the Shore - Murakami
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (101, 201);  -- Pride and Prejudice - Austen
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (101, 251);  -- Emma - Austen
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (151, 301);  -- Crime and Punishment - Dostoevsky
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (151, 351);  -- The Brothers Karamazov - Dostoevsky
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (201, 401);  -- Harry Potter and the Philosopher's Stone - Rowling
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (201, 451);  -- Harry Potter and the Chamber of Secrets - Rowling
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (251, 501);  -- One Hundred Years of Solitude - García Márquez
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (251, 551);  -- Love in the Time of Cholera - García Márquez
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (301, 601);  -- The Shining - King
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (301, 651);  -- It - King
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (351, 701);  -- The Handmaid's Tale - Atwood
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (351, 751);  -- Oryx and Crake - Atwood
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (401, 801);  -- The Name of the Rose - Eco
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (401, 851);  -- Foucault's Pendulum - Eco
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (451, 901); -- Americanah - Adichie
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (501, 951); -- War and Peace - Tolstoy
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (501, 1001); -- Anna Karenina - Tolstoy
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (551, 1051); -- The Trial - Kafka
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (551, 1101); -- The Metamorphosis - Kafka
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (601, 1151); -- Invisible Cities - Calvino
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (601, 1201); -- If on a winter's night a traveler - Calvino
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (651, 1251); -- The House of the Spirits - Allende
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (701, 1301); -- The Stranger - Camus
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (701, 1351); -- The Plague - Camus
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (701, 1401); -- The Fall - Camus
INSERT INTO libro_lista_autori (lista_autori_id, lista_libri_id) VALUES (701, 1451); -- The Myth of Sisyphus - Camus