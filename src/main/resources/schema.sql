create table if not exists Person (
    id identity primary key,
    shifer varchar(50) not null,
    inn int not null,
    type varchar(15) not null,
    date_registration date not null,
 );
create table if not exists TypeAgreement (
    id identity primary key,
    type varchar(50) not null,
);
create table if not exists StatusAgreement (
    id identity primary key,
    status varchar(50) not null,
);
create table if not exists Agreement (
    id identity primary key,
    person_id bigint not null,
    type_agreement_id bigint not null,
    status_agreement_id bigint not null,
    number_agreement bigint not null,
    date_open date not null,
    date_close date not null,
);

alter table Agreement
 add foreign key (person_id) references Person(id);
 add foreign key (type_agreement_id) references TypeAgreement(id);
 add foreign key (status_agreement_id) references Agreement(id);