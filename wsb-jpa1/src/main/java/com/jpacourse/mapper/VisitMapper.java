package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;

public class VisitMapper
{
    public static VisitTO mapVisitToTO(VisitEntity visitEntity) {
        VisitTO to = new VisitTO();
        to.setTime(visitEntity.getTime());

        if (visitEntity.getDoctor() != null) {
            to.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
            to.setDoctorLastName(visitEntity.getDoctor().getLastName());
        }

        if (visitEntity.getTreatment() != null) {
            to.setTreatmentTypes(visitEntity.getTreatment().getType());
        }

        return to;
    }
}
