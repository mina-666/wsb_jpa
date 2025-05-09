package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void shouldGetVisitsByPatientId() {
        // Given
        Long patientId = 101L; // Jim Halpert

        // When
        var visits = patientService.getVisitsByPatientId(patientId);

        // Then
        assertThat(visits).isNotNull();
        assertThat(visits).isNotEmpty();
        assertThat(visits.get(0).getDescription()).isNotBlank();
    }
    @Test
    public void shouldGetAllPatients() {
        // When
        var patients = patientService.getAllPatients();

        // Then
        assertThat(patients).isNotNull();
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getFirstName()).isNotBlank();
    }

}
