create table if not exists players
(
    id                           bigint auto_increment primary key,
    name                         varchar(40)    not null,
    surname                      varchar(40)    not null
);

create table if not exists game_activity
(
    id                           bigint auto_increment primary key,
    player_id                    bigint,
    bet_amount                   decimal(10, 2) not null,
    win_amount                   decimal(10, 2) not null,
    currency                     enum ('USD', 'EUR', 'BGN') not null,
    constraint fk_game_activity_player foreign key (player_id) references players (id)
);