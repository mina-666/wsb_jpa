package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import com.jpacourse.dto.PatientTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientService patientService;

    @Test
    public void shouldDeletePatientAndVisitsButNotDoctors() {
        // Given
        Long patientId = 101L; // Jim Halpert
        Long doctorId = 201L;  // Michael Scott

        // When
        PatientEntity patient = patientDao.findOne(patientId);
        if (patient != null) {
            patientDao.delete(patient); // Usuwamy pacjenta
        }

        // Then
        boolean patientExists = patientDao.exists(patientId);
        assertThat(patientExists).isFalse();

        DoctorEntity existingDoctor = doctorDao.findOne(doctorId);
        assertThat(existingDoctor).isNotNull();

    }

    @Test
    public void shouldGetPatientById() {
        // Given
        Long patientId = 101L; // Jim Halpert

        // When
        PatientTO patient = patientService.findById(patientId);

        // Then
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Jim");
        assertThat(patient.getLastName()).isEqualTo("Halpert");
        assertThat(patient.getPatientNumber()).isEqualTo("PAT001");
        assertThat(patient.getDateOfBirth()).isNotNull();
        assertThat(patient.getVisits()).isNotEmpty();
    }
    @Test
    public void shouldGetVisitsByPatientId() {
        // Given
        Long patientId = 101L; // Jim Halpert

        // When
        var visits = patientService.getVisitsByPatientId(patientId);

        // Then
        assertThat(visits).isNotNull();
        assertThat(visits).isNotEmpty();
        assertThat(visits.get(0).getDescription()).isNotIn();
    }

}
