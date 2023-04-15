insert into Person (id, shifer, inn, type, date_registration)
values ('P1', 'P1', 123456789012, 'PHYSICAL', '20.08.2012',);
insert into Person (id, shifer, inn, type, date_registration)
values ('P2', 'P2', 223456789012, 'PHYSICAL', '11.08.2012',);

insert into TypeAgreement (id, type)
values ('TAD', 'Дилерский');
insert into TypeAgreement (id, type)
values ('TAB', 'Брокерский');
insert into TypeAgreement (id, type)
values ('TAY', 'Управления');

insert into StatusAgreement (id, status)
values ('SAD', 'Действует');
insert into StatusAgreement (id, status)
values ('SAB', 'Блокирован');

insert into Agreement (id, person_id, type_agreement_id, status_agreement_id, number_agreement, date_open, date_close)
values ('A1', 'P1', 'TAD', "SAD", 12345, '02.03.2018', '02.03.2023');
insert into Agreement (id, person_id, type_agreement_id, status_agreement_id, number_agreement, date_open, date_close)
values ('A2', 'P2', 'TAB', "SAD", 12346, '02.03.2018', '02.03.2023');
