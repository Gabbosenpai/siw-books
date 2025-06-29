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

INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1, 'Un inizio sorprendente', 'Storia avvincente che mi ha catturato fin dalle prime pagine.', 5, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1, 'Coinvolgente ma lento', 'Interessante, ma a tratti prolisso.', 3, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (51, 'Capolavoro moderno', 'Personaggi memorabili e colpi di scena ben costruiti.', 5, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (101, 'Piacevole lettura', 'Scorrevole e ben scritto, lo consiglio.', 4, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (101, 'Poteva osare di più', 'Bella idea ma esecuzione un po’ piatta.', 3, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (151, 'Thriller ben riuscito', 'Suspense fino all’ultima pagina.', 4, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (201, 'Un po’ deluso', 'Mi aspettavo di più vista la fama dell’autore.', 2, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (251, 'Bellissimo romanzo', 'Una storia intensa e commovente.', 5, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (251, 'Troppo drammatico', 'Non fa per me, troppo pesante.', 2, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (301, 'Piacevole sorpresa', 'Molto più bello di quanto pensassi.', 4, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (351, 'Emozionante', 'Finale spettacolare e inaspettato.', 5, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (401, 'Non è il mio genere', 'Non sono riuscito a finirlo.', 1, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (451, 'Molto ben scritto', 'Una scrittura elegante e coinvolgente.', 5, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (451, 'Senza infamia né lode', 'Bello ma nulla di memorabile.', 3, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (501, 'Perfetto per l’estate', 'Lettura leggera e piacevole.', 4, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (551, 'Storia intricata', 'Richiede attenzione ma ne vale la pena.', 4, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (601, 'Un viaggio emozionante', 'Toccante e intenso.', 5, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (651, 'Troppo complesso', 'Non sono riuscito a seguirlo fino alla fine.', 2, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (701, 'Stupendo', 'Uno dei migliori romanzi letti quest’anno.', 5, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (751, 'Mediocre', 'Trama scontata, non mi ha lasciato nulla.', 2, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (801, 'Originale', 'Storia diversa dal solito, molto interessante.', 4, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (851, 'Tanta azione', 'Ritmo serrato, mi è piaciuto.', 5, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (851, 'Sufficiente', 'Scritto bene, ma storia poco coinvolgente.', 3, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (901, 'Poco incisivo', 'Non riesce a lasciare il segno.', 2, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (951, 'Bellissimo stile', 'Autore bravissimo, prosa impeccabile.', 5, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1001, 'Prevedibile', 'La trama si capisce fin dall’inizio.', 2, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1051, 'Emozionante', 'Ho divorato ogni pagina.', 5, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1101, 'Non mi ha convinto', 'Troppo ripetitivo.', 2, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1151, 'Romanzo profondo', 'Mi ha fatto riflettere molto.', 5, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1201, 'Personaggi ben costruiti', 'Ognuno con la sua storia interessante.', 4, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1251, 'Viaggio interiore', 'Toccante e scritto con delicatezza.', 5, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1301, 'Troppo lungo', 'Avrei tagliato almeno cento pagine.', 2, 151);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1351, 'Coinvolgente', 'Non riuscivo a smettere di leggerlo.', 4, 1);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1401, 'Capolavoro', 'Il miglior libro letto negli ultimi anni.', 5, 51);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1401, 'Troppo cervellotico', 'Non fa per me.', 2, 101);
INSERT INTO recensione (libro_id, title, text, rating, autore_id) VALUES (1451, 'Senza emozioni', 'Non mi ha trasmesso nulla.', 1, 151);
