create table if not exists Person (
    id identity primary key,
    shifer varchar(50) not null,
    inn bigint not null,
    type varchar(15) not null,
    date_registration varchar(15) not null
 );
create table if not exists TypeAgreement (
    id identity primary key,
    type varchar(50) not null
);
create table if not exists StatusAgreement (
    id identity primary key,
    status varchar(50) not null
);
create table if not exists Agreement (
    id identity primary key,
    person_id int not null,
    type_agreement_id int not null,
    status_agreement_id int not null,
    number_agreement int not null,
    date_open varchar(15) not null,
    date_close varchar(15) not null
);

alter table Agreement
 add foreign key (person_id) references Person(id);
alter table Agreement
 add foreign key (type_agreement_id) references TypeAgreement(id);
alter table Agreement
 add foreign key (status_agreement_id) references StatusAgreement(id);