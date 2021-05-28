INSERT INTO USERS (type, password, username, phone_number) VALUES ('ROLE_ADMIN',  '$2y$10$qHYGGSJnVTs3vVHITJuSwOQyki4XoMO5FgKa.psVze6VKaIJnYi9K','admin@nesto.com', '12345'); --sifra je 1
INSERT INTO USERS (type, password, username, godiste, name, surname, pol, tip_ljubimca, radni_status, vakcinacija) VALUES ('ROLE_USER',  '$2y$10$qHYGGSJnVTs3vVHITJuSwOQyki4XoMO5FgKa.psVze6VKaIJnYi9K','kor1@nesto.com', 1998, 'Pera', 'Peric', 'MUSKO', 'MALI', 'STUDENT', '2020.08.22'); --sifra je 1
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');
INSERT INTO authority (name) VALUES ('ROLE_USER');
insert into user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN
insert into user_authority (user_id, authority_id) values (2, 2); -- admin has ROLE_USER

insert into KARAKTERISTIKA (naziv) values ('Sunce');--1
insert into KARAKTERISTIKA (naziv) values ('Voda');--2
insert into KARAKTERISTIKA (naziv) values ('OdmorBezAktivnosti');--3
insert into KARAKTERISTIKA (naziv) values ('OdmorSaAktivnostima');--4
insert into KARAKTERISTIKA (naziv) values ('Urbano');--5
insert into KARAKTERISTIKA (naziv) values ('Mir');--6
insert into KARAKTERISTIKA (naziv) values ('Hlad');--7
insert into KARAKTERISTIKA (naziv) values ('DugPut');--8
insert into KARAKTERISTIKA (naziv) values ('KratakPut');--9
insert into KARAKTERISTIKA (naziv) values ('SvezVazduh');--10
insert into KARAKTERISTIKA (naziv) values ('IndividualniObilazak');--11
insert into KARAKTERISTIKA (naziv) values ('GrupniObilazak');--12
insert into KARAKTERISTIKA (naziv) values ('MedicinskiNadzor');--13
insert into KARAKTERISTIKA (naziv) values ('KulturniSadrzaj');--14

insert into DESTINACIJA (naziv) values ('More');
insert into DESTINACIJA (naziv) values ('Daleka destinacija');
insert into DESTINACIJA (naziv) values ('Planina');
insert into DESTINACIJA (naziv) values ('Banja');
insert into DESTINACIJA (naziv) values ('Metropola');

--More:sunce,voda, odmor bez aktivnosti, mir
insert into destinacija_preferences (destinacija_id, preference_id) values (1,1);
insert into destinacija_preferences (destinacija_id, preference_id) values (1,2);
insert into destinacija_preferences (destinacija_id, preference_id) values (1,3);
insert into destinacija_preferences (destinacija_id, preference_id) values (1,6);

--Daleka destinacija:sunce, voda, odmor bez aktivnosti, mir, dug put
insert into destinacija_preferences (destinacija_id, preference_id) values (2,1);
insert into destinacija_preferences (destinacija_id, preference_id) values (2,2);
insert into destinacija_preferences (destinacija_id, preference_id) values (2,3);
insert into destinacija_preferences (destinacija_id, preference_id) values (2,6);
insert into destinacija_preferences (destinacija_id, preference_id) values (2,8);

--Planina:hlad, mir, odmor sa aktivnostima, svez vazduh,individualni obilazak, kratak put
insert into destinacija_preferences (destinacija_id, preference_id) values (3,7);
insert into destinacija_preferences (destinacija_id, preference_id) values (3,6);
insert into destinacija_preferences (destinacija_id, preference_id) values (3,4);
insert into destinacija_preferences (destinacija_id, preference_id) values (3,10);
insert into destinacija_preferences (destinacija_id, preference_id) values (3,11);
insert into destinacija_preferences (destinacija_id, preference_id) values (3,9);

--Banja:hlad, mir, odmor bez aktivnosti, svez vazduh, medicinski nadzor, kratak put
insert into destinacija_preferences (destinacija_id, preference_id) values (4,7);
insert into destinacija_preferences (destinacija_id, preference_id) values (4,6);
insert into destinacija_preferences (destinacija_id, preference_id) values (4,3);
insert into destinacija_preferences (destinacija_id, preference_id) values (4,10);
insert into destinacija_preferences (destinacija_id, preference_id) values (4,13);
insert into destinacija_preferences (destinacija_id, preference_id) values (4,9);

--Metropola: odmor sa aktivnostima, urbano, kulturni sadrzaji, grupni obilazak, dug put
insert into destinacija_preferences (destinacija_id, preference_id) values (5,4);
insert into destinacija_preferences (destinacija_id, preference_id) values (5,5);
insert into destinacija_preferences (destinacija_id, preference_id) values (5,14);
insert into destinacija_preferences (destinacija_id, preference_id) values (5,12);
insert into destinacija_preferences (destinacija_id, preference_id) values (5,8);