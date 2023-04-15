insert into Person (id, shifer, inn, type, date_registration)
values (1, 'P1', 123456789012, 'PHYSICAL', '20.08.2012');
insert into Person (id, shifer, inn, type, date_registration)
values (2, 'P2', 223456789012, 'PHYSICAL', '11.08.2012');

insert into TypeAgreement (id, type)
values (3, 'Дилерский');
insert into TypeAgreement (id, type)
values (4, 'Брокерский');
insert into TypeAgreement (id, type)
values (5, 'Управления');

insert into StatusAgreement (id, status)
values (6, 'Действует');
insert into StatusAgreement (id, status)
values (7, 'Блокирован');

insert into Agreement (id, person_id, type_agreement_id, status_agreement_id, number_agreement, date_open, date_close)
values (8, 1, 3, 7, 12345, '02.03.2018', '02.03.2023');
insert into Agreement (id, person_id, type_agreement_id, status_agreement_id, number_agreement, date_open, date_close)
values (9, 2, 4, 6, 12346, '02.03.2018', '02.03.2023');
