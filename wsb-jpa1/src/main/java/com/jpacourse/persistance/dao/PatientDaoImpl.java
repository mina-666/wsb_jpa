package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    // === DODAJ TO: publiczny setter ===
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // ===================================

    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String description) {
        // Pobierz pacjenta, doktora oraz domyślne leczenie (MedicalTreatmentEntity z id=1)
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        MedicalTreatmentEntity defaultTreatment = entityManager.find(MedicalTreatmentEntity.class, 1L);

        if (patient == null || doctor == null || defaultTreatment == null) {
            throw new RuntimeException("Patient, Doctor or default Treatment not found");
        }

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(visitTime);
        visit.setDescription(description);
        visit.setTreatment(defaultTreatment);

        // ZAPISZ NOWĄ wizytę
        entityManager.persist(visit);

        // NIE ruszaj patienta, nie merge'uj!
    }
}
