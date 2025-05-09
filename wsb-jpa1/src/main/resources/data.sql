-- ADDRESS
insert into address (id, city, address_line1, address_line2, postal_code) 
values (301, 'Scranton', 'Slough Avenue', 'Apt 2', '00-101');
insert into address (id, city, address_line1, address_line2, postal_code)
values (302, 'Scranton', 'Froggy 101 Blvd', 'Apt 3', '00-202');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (303, 'Scranton', 'Poor Richard St', 'Apt 4', '00-303');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (304, 'Scranton', 'Penn Paper Rd', 'Apt 5', '00-404');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (305, 'Scranton', 'Vance Refrigeration Ln', 'Apt 6', '00-505');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (306, 'Scranton', 'Steamtown Mall Way', 'Apt 7', '00-606');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (307, 'Scranton', 'Lackawanna Ave', 'Apt 8', '00-707');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (308, 'Scranton', 'Warehouse Alley', 'Apt 9', '00-808');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (309, 'Scranton', 'Dunder Rd', 'Apt 10', '00-909');
insert into address (id, city, address_line1, address_line2, postal_code) 
values (310, 'Scranton', 'Chili''s Drive', 'Apt 11', '01-010');


-- DOCTOR
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (201, 'Michael', 'Scott', '123456789', 'MiS@dundermifflin.com', 'DOC001', 'GP', 301);
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (202, 'Dwight', 'Schrute', '222333444', 'dwight@dundermifflin.com', 'DOC002', 'DERMATOLOGIST', 302);


-- PATIENT
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (101, 'Jim', 'Halpert', '987654321', 'jim.halpert@dundermifflin.com', 'PAT001', '1990-01-05', 301);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (102, 'Pam', 'Beesly', '555666777', 'pam.beesly@dundermifflin.com', 'PAT002', '1992-05-10', 302);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (103, 'Stanley', 'Hudson', '536625968', 'stanley.hudson@example.com', 'PAT003', '1965-02-01', 310);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (104, 'Angela', 'Martin', '424024131', 'angela.martin@example.com', 'PAT004', '1975-07-12', 305);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (105, 'Oscar', 'Martinez', '991191292', 'oscar.martinez@example.com', 'PAT005', '1980-03-25', 309);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (106, 'Kevin', 'Malone', '606402658', 'kevin.malone@example.com', 'PAT006', '1978-06-06', 306);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (107, 'Meredith', 'Palmer', '298071634', 'meredith.palmer@example.com', 'PAT007', '1969-11-11', 304);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (108, 'Creed', 'Bratton', '294472771', 'creed.bratton@example.com', 'PAT008', '1955-02-14', 307);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (109, 'Ryan', 'Howard', '154524388', 'ryan.howard@example.com', 'PAT009', '1985-04-09', 304);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (110, 'Kelly', 'Kapoor', '598470316', 'kelly.kapoor@example.com', 'PAT010', '1984-10-02', 303);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (111, 'Sookie', 'Stackhouse', '569188311', 'sookie.stackhouse@example.com', 'PAT011', '1987-07-10', 304);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (112, 'Bill', 'Compton', '872217454', 'bill.compton@example.com', 'PAT012', '1865-04-25', 310);




-- MEDICAL_TREATMENT
insert into medical_treatment (id, description, type) 
values (401, 'General check-up', 'USG');
insert into medical_treatment (id, description, type) 
values (402, 'Skin check', 'RTG');
insert into medical_treatment (id, description, type) 
values (403, 'Flu Shot', 'USG');
insert into medical_treatment (id, description, type) 
values (404, 'Dermatology exam', 'USG');
insert into medical_treatment (id, description, type) 
values (405, 'Annual physical', 'RTG');
insert into medical_treatment (id, description, type) 
values (406, 'Blood Test', 'EKG');
insert into medical_treatment (id, description, type) 
values (407, 'X-Ray', 'RTG');



-- VISIT
insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (501, 'Routine visit #1', '2025-04-10T08:00:00', 202, 105, 403);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (502, 'Routine visit #2', '2025-04-11T09:00:00', 202, 102, 406);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (503, 'Routine visit #3', '2025-04-12T08:00:00', 202, 104, 404);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (504, 'Routine visit #4', '2025-04-13T09:00:00', 201, 103, 404);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (505, 'Routine visit #5', '2025-04-14T08:00:00', 202, 101, 407);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (506, 'Routine visit #6', '2025-04-15T09:00:00', 202, 101, 407);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (507, 'Routine visit #7', '2025-04-16T08:00:00', 202, 106, 407);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (508, 'Routine visit #8', '2025-04-17T08:00:00', 202, 101, 405);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (509, 'Routine visit #9', '2025-04-18T08:00:00', 201, 102, 407);

insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (510, 'Routine visit #10', '2025-04-19T08:00:00', 202, 106, 405);


