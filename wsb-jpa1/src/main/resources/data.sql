-- ADDRESS
insert into address (id, city, address_line1, address_line2, postal_code)
values (1, 'Warsaw', 'Main St', 'Apt 1', '00-001');

-- DOCTOR
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
values (1, 'Anna', 'Nowak', '123456789', 'anna@clinic.com', 'DOC001', 'GP', 1);

-- PATIENT
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
values (1, 'Jan', 'Kowalski', '987654321', 'jan@patient.com', 'PAT001', '1990-01-01', 1);

-- MEDICAL_TREATMENT
insert into medical_treatment (id, description, type)
values (1, 'General check-up', 'USG');

-- VISIT
insert into visit (id, description, time, doctor_id, patient_id, treatment_id)
values (1, 'First visit for check-up', '2025-03-23T10:00:00', 1, 1, 1);
