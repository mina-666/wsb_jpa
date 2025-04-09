package com.jpacourse.dto;


import com.jpacourse.persistance.enums.TreatmentType;

import java.time.LocalDateTime;

public class VisitTO {
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private TreatmentType treatmentTypes;

    // Gettery i settery
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public TreatmentType getTreatmentTypes() {
        return treatmentTypes;
    }

    public void setTreatmentTypes(TreatmentType treatmentTypes) {
        this.treatmentTypes = treatmentTypes;
    }
}
