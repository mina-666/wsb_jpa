package com.jpacourse.persistance.dao.impl;

import static org.assertj.core.api.Assertions.within;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@SpringBootTest
@Transactional
class PatientDaoImplTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldAddVisitToPatient() {
        // given
        com.jpacourse.persistance.dao.impl.PatientDaoImpl patientDao = new com.jpacourse.persistance.dao.impl.PatientDaoImpl();
        patientDao.setEntityManager(entityManager);

        Long patientId = 102L; // Pam Beesly
        Long doctorId = 201L;  // Michael Scott
        LocalDateTime visitTime = LocalDateTime.now().plusDays(2);
        String description = "Druga wizyta testowa";

        // when
        patientDao.addVisitToPatient(patientId, doctorId, visitTime, description);

        // then
        entityManager.flush();   // <--- TO DODAJ
        entityManager.clear();   // <--- TO DODAJ

        PatientEntity patient = entityManager.find(PatientEntity.class, patientId); // <--- teraz z bazy
        assertThat(patient.getVisits()).isNotEmpty();
        VisitEntity visit = patient.getVisits().get(patient.getVisits().size() - 1);
        assertThat(visit.getDoctor()).isNotNull();
        assertThat(visit.getTime())
                .isCloseTo(visitTime, within(1, ChronoUnit.MILLIS));
        assertThat(visit.getDescription()).isEqualTo(description);
    }
}