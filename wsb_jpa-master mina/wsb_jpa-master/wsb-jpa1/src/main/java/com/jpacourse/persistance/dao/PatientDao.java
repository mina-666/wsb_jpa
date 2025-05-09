package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDate;
import java.util.List;


public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findByLastName(String lastName);
    List<VisitEntity> findVisitsByPatientId(Long patientId);
    List<PatientEntity> findPatientsWithMoreThanXVisits(int x);
    List<PatientEntity> findByDateOfBirthAfter(LocalDate date);
    List<PatientEntity> findAllWithVisits();


}
