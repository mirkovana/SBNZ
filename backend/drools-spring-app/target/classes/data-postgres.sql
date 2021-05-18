INSERT INTO USERS (type, password, username, broj_telefona) VALUES ('ROLE_ADMIN',  '$2y$10$qHYGGSJnVTs3vVHITJuSwOQyki4XoMO5FgKa.psVze6VKaIJnYi9K','admin@nesto.com', '12345'); --sifra je 1
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_USER');
insert into user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN

--create type karakteristike as enum (
--  'Sunce',
--	'Voda',
--	'OdmorBezAktivnosti',
--	'OdmorSaAktivnostima',
--	'PescanaPlaza',
--	'Mir'
--);