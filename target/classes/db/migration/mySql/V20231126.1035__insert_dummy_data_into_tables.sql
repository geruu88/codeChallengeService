INSERT INTO players(id, name, surname)
VALUES (1, 'Georgi', 'Petrov'),
       (2, 'Nikola', 'Ivanov'),
       (3, 'Maria', 'Hristova'),
       (4, 'Dimitar', 'Georgiev'),
       (5, 'Todor', 'Todorov');

INSERT INTO game_activity(id, player_id, bet_amount, win_amount, currency)
VALUES (1, 1, 100, 200, 'EUR'),
       (2, 1, 100, 0, 'EUR'),
       (3, 1, 100, 0, 'EUR'),
       (4, 2, 100, 0, 'EUR'),
       (5, 2, 100, 0, 'EUR'),
       (6, 3, 100, 500, 'EUR'),
       (7, 3, 100, 0, 'EUR'),
       (8, 4, 100, 100, 'EUR'),
       (9, 4, 50, 300, 'EUR'),
       (10, 1, 100, 200, 'EUR'),
       (11, 1, 50, 50, 'EUR'),
       (12, 5, 50, 0, 'EUR'),
       (13, 5, 50, 400, 'EUR');
