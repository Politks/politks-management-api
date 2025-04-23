drop table if exists candidate cascade

drop table if exists election cascade

drop table if exists politician cascade

drop sequence if exists candidate_SEQ

drop sequence if exists election_SEQ

drop sequence if exists politician_SEQ

create sequence candidate_SEQ start with 1 increment by 50

create sequence election_SEQ start with 1 increment by 50

create sequence politician_SEQ start with 1 increment by 50

create table candidate
(
    electionId   integer not null,
    number       integer not null,
    politicianId integer not null,
    votes        integer not null,
    id           bigint  not null,
    result       varchar(255) check (result in ('SECOND_TURN', 'NOT_ELECTED', 'ELECTED')),
    primary key (id),
    unique (politicianId, electionId)
)

create table election
(
    id           bigint not null,
    municipality varchar(255) check (municipality in ('SAO_PAULO')),
    position     varchar(255) check (position in ('PREFEITO', 'VEREADOR')),
    uf           varchar(255) check (uf in
                                     ('AC', 'AL', 'AM', 'AP', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MG', 'MS', 'MT',
                                      'PA', 'PB', 'PE', 'PI', 'PR', 'RJ', 'RN', 'RO', 'RR', 'RS', 'SC', 'SE', 'SP',
                                      'TO')),
    primary key (id)
)

create table politician
(
    id        bigint not null,
    full_name varchar(255),
    name      varchar(255),
    photo     varchar(255),
    primary key (id)
)