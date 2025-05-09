package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public List<PatientTO> getAllPatients() {
        return patientDao.findAll().stream()
                .map(PatientMapper::mapToTO)
                .collect(Collectors.toList());
    }

    public PatientTO findById(Long id) {
        PatientEntity patient = patientDao.findOne(id);
        return patient != null ? PatientMapper.mapToTO(patient) : null;
    }
    public List<VisitTO> getVisitsByPatientId(Long patientId) {
        return patientDao.findVisitsByPatientId(patientId)
                .stream()
                .map(VisitMapper::mapVisitToTO)
                .collect(Collectors.toList());
    }

}
