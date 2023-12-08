/* Возможно, мое решение сильно отличается от задания, но мне оно видится правильным 
с точки зрения не плодить кучу таблиц, 
а использовать одну и по ней делать выборки с целью получения необходимой информации*/

DROP DATABASE IF EXISTS humans_friends;
CREATE DATABASE humans_friends;
USE humans_friends;

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id SERIAL PRIMARY KEY,
    nickname VARCHAR(50),
    animal_type varchar(50),
    command VARCHAR(50),
    birthday DATE
);

INSERT INTO animals (id, nickname, animal_type, command, birthday) VALUES 
(1, 'Reuben', 'Dog', 'Sit', '2022-01-10'),
(2, 'Frederik', 'Dog', 'Stay', '2021-04-08'),
(3, 'Unique', 'Dog', 'Fetch', '2020-01-12'),
(4, 'Click', 'Cat', 'Sit', '2023-03-05'),
(5, 'Ping', 'Cat', 'Pounce', '2018-02-11'),
(6, 'Pack', 'Cat', 'Sit', '2022-07-10'),
(7, 'Chip', 'Hamster', 'Roll', '2022-01-10'),
(8, 'Dale', 'Hamster', 'Hide', '2021-03-12'),
(9, 'Rockfor', 'Hamster', 'Roll, Hide', '2021-05-05'),
(10, 'Faster', 'Horse', 'Trot, Canter, Gallop', '2015-02-02'),
(11, 'Harder', 'Horse', 'Canter, Gallop', '2020-03-04'),
(12, 'Scooter', 'Horse', 'Gallop', '2022-01-01'),
(13, 'Knight', 'Camal', 'Walk, Carry Load', '2023-01-10'),
(14, 'Rider', 'Camal', 'Walk', '2020-02-03'),
(15, 'Spiner', 'Camal', 'Walk, Sit', '2015-03-02'),
(16, 'Fat', 'Donkey', 'Walk, Carry Load, Bray', '2021-06-05'),
(17, 'Boy', 'Donkey', 'Walk, Carry Load', '2022-03-02'),
(18, 'Slim', 'Donkey', 'Carry Load, Bray', '2019-01-02');

-- Выборка всех домашних животных

select * from animals
where animal_type = 'Cat' or animal_type = 'Dog' or animal_type = 'Hamster';

-- Выборка всех вьючных животных

select * from animals
where animal_type = 'Donkey' or animal_type = 'Horse' or animal_type = 'Camal';

-- Удаление верблюдов

delete from animals
where animal_type = 'Camal';
select * from animals;

-- Выборка всех лошадей и ослов

select * from animals
where animal_type = 'Donkey' or animal_type = 'Horse';

-- Выборка всех животных старше 1 года, но младше 3 лет

select * from animals
where timestampdiff(year, birthday, curdate()) between 1 and 3;






