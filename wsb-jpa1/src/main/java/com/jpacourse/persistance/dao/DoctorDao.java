package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<DoctorEntity, Long> {
}
