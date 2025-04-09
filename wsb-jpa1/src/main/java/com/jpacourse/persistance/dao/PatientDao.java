package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<PatientEntity, Long> {
}
