insert into exercise(description, difficulty, name) values('leiras', 2, 'nev');
insert into exercise(description, difficulty, name) values('Könyöktámasz a kiinduló pozíció, feneket szorítjuk, és figyelünk arra, hogy ne mozduljunk meg,
a hátunk egy vonalban legyen a lábbal. 3x30 másodpercig csináljuk. ', 4, 'Plank');
insert into exercise(description, difficulty, name) values('Háton fekve, térdet behajlítva, lábakat összekulcsolva, kezeket a tarkón összekulcsolva, 
addig emeljük a fejünket, amíg nem emelkedik el a lapocka a talajtól. 3x10 db-ot csináljuk.', 1, 'Hasprés');
insert into exercise(description, difficulty, name) values('Adott pozícióba helyezzük magunkat, majd csináljunk 3x10-es sorozatot.', 5, 'Fekvőtámasz');

insert into plan (difficulty) values (4);
insert into plan (difficulty) values (2);

insert into plan_exercises (plans_id, exercises_id) values (1, 1);
insert into plan_exercises (plans_id, exercises_id) values (1, 2);
insert into plan_exercises (plans_id, exercises_id) values (1, 4);
insert into plan_exercises (plans_id, exercises_id) values (2, 1);
insert into plan_exercises (plans_id, exercises_id) values (2, 3);

insert into user (name, username, role, e_mail, weight, goal_weight, height, score, plan_id) values ('Dani', 'kdani02', 'ada@freemail.hu', 1, 80, 80, 179, 4, 1);
insert into user (name, username, role, e_mail, weight, goal_weight, height, score, plan_id) values ('Dani', 'kdani02', 'ada@freemail.hu', 1, 80, 80, 179, 4, 2);
insert into user (name, username, role, e_mail, weight, goal_weight, height, score, plan_id) values ('Kati', 'kata97', 'fesnklh@gmail.com', 0, 73, 70, 169, 0, 1);
insert into user (name, username, role, e_mail, weight, goal_weight, height, score, plan_id) values ('Misi', 'miska23', 'egas@gmail.hu', 0, 86, 82, 184, 0, 2);


insert into rating (creativity, efficiency, quality, user_id) values (5, 3, 2, 1);
insert into rating (creativity, efficiency, quality, user_id) values (3, 3, 1, 1);
insert into rating (creativity, efficiency, quality, user_id) values (5, 4, 3, 1);
