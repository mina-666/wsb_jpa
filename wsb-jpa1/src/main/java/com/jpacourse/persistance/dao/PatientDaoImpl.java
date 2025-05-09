package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        MedicalTreatmentEntity defaultTreatment = entityManager.find(MedicalTreatmentEntity.class, 401L);

        if (patient == null || doctor == null || defaultTreatment == null) {
            throw new RuntimeException("Patient, Doctor or default Treatment not found");
        }

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(visitTime);
        visit.setDescription(description);
        visit.setTreatment(defaultTreatment);

        entityManager.persist(visit);
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager
                .createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<VisitEntity> findVisitsByPatientId(Long patientId) {
        return entityManager
                .createQuery("SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class)
                .setParameter("patientId", patientId)
                .getResultList();
    }

    @Override
    public boolean exists(Long id) {
        return entityManager.find(PatientEntity.class, id) != null;
    }

    @Override
    public long count() {
        return entityManager
                .createQuery("SELECT COUNT(p) FROM PatientEntity p", Long.class)
                .getSingleResult();
    }
    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int x) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", x)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findByDateOfBirthAfter(LocalDate date) {
        return entityManager
                .createQuery("SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date", PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
    }
    @Override
    public List<PatientEntity> findAllWithVisits() {
        return entityManager.createQuery(
                        "SELECT DISTINCT p FROM PatientEntity p LEFT JOIN FETCH p.visits", PatientEntity.class)
                .getResultList();
    }

}
