-- ADDRESS
insert into address (id, city, address_line1, address_line2, postal_code)
values (1, 'Scranton', 'Scranton Business Park', 'Apt 1', '00-001');

insert into address (id, city, address_line1, address_line2, postal_code)
values (2, 'New York', 'Second Avenue', 'Suite 20', '11-111');

-- DOCTOR
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (1, 'Michael', 'Scott', '123456789', 'MiS@dundermifflin.com', 'DOC001', 'GP', 1);

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (2, 'Dwight', 'Schrute', '222333444', 'dwight@dundermifflin.com', 'DOC002', 'DERMATOLOGIST', 2);

-- PATIENT
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (1, 'Jim', 'Halpert', '987654321', 'jim.halpert@dundermifflin.com', 'PAT001', '1990-01-01', 1);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (2, 'Pam', 'Beesly', '555666777', 'pam.beesly@dundermifflin.com', 'PAT002', '1992-05-10', 2);

-- MEDICAL_TREATMENT
insert into medical_treatment (id, description, type)
values (1, 'General check-up', 'USG');

insert into medical_treatment (id, description, type)
values (2, 'Skin check', 'RTG');

-- VISIT
insert into visit (description, time, doctor_id, patient_id, treatment_id)
values ('First visit for check-up', '2025-03-23T10:00:00', 1, 1, 1);
