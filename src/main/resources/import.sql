drop table if exists candidate cascade;
drop table if exists election cascade;
drop table if exists politician cascade;

drop sequence if exists candidate_SEQ;
drop sequence if exists election_SEQ;
drop sequence if exists politician_SEQ;

create sequence candidate_SEQ start with 1 increment by 50;
create sequence election_SEQ start with 1 increment by 50;
create sequence politician_SEQ start with 1 increment by 50;

create table politician (
    id bigint not null,
    full_name varchar(255),
    name varchar(255),
    photo varchar(255),
    primary key (id)
);

create table election (
    id bigint not null,
    municipality varchar(255) check (municipality in ('SAO_PAULO')),
    position varchar(255) check (position in ('PREFEITO', 'VEREADOR')),
    uf varchar(255) check (uf in ('AC', 'AL', 'AM', 'AP', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MG', 'MS', 'MT',
                                 'PA', 'PB', 'PE', 'PI', 'PR', 'RJ', 'RN', 'RO', 'RR', 'RS', 'SC', 'SE', 'SP', 'TO')),
    election_date date,
    primary key (id)
);

create table candidate (
    id bigint not null,
    politician_id bigint not null,
    election_id bigint not null,
    votes integer not null,
    number integer not null,
    result varchar(255) check (result in ('SECOND_TURN', 'NOT_ELECTED', 'ELECTED')),
    primary key (id),
    constraint fk_candidate_politician foreign key (politician_id) references politician(id),
    constraint fk_candidate_election foreign key (election_id) references election(id),
    constraint unique_candidate_per_election unique (politician_id, election_id)
);

-- Inserir políticos
INSERT INTO politician (id, full_name, name, photo) VALUES
(1, 'RICARDO NUNES', 'RICARDO NUNES', 'https://example.com/photos/joao.jpg'),
(2, 'GUILHERME BOULOS', 'GUILHERME BOULOS', 'https://example.com/photos/maria.jpg');

-- Inserir eleições
INSERT INTO election (id, municipality, position, uf, election_date) VALUES
(1, 'SAO_PAULO', 'PREFEITO', 'SP', '2024-10-27'),
(2, 'SAO_PAULO', 'PREFEITO', 'SP', '2024-10-06'),
(3, 'SAO_PAULO', 'VEREADOR', 'SP', '2024-10-06');

-- Inserir candidatos
INSERT INTO candidate (id, politician_id, election_id, votes, number, result) VALUES
(1, 1, 1, 1500000, 3393110, 'ELECTED'),
(2, 2, 1, 50000, 2323901, 'NOT_ELECTED');