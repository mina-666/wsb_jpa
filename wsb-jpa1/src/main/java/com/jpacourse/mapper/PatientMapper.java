package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());

        if (entity.getVisits() != null) {
            List<VisitTO> visitTOs = entity.getVisits().stream()
                    .map(VisitMapper::mapVisitToTO)
                    .collect(Collectors.toList());
            to.setVisits(visitTOs);
        }

        return to;
    }


}
