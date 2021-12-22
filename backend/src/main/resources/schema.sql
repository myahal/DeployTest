create table if not exists players (id serial primary key, first_name text, last_name text);
delete from players;
insert into players (first_name, last_name) values ('taro', 'yamada');
insert into players (first_name, last_name) values ('jiro', 'sato');