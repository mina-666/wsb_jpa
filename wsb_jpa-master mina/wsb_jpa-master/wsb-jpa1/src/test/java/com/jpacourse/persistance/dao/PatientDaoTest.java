package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.persistence.OptimisticLockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testShouldFindPatientByLastName() {
        // given
        String lastName = "Beesly";

        // when
        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients.get(0).getLastName()).isEqualTo("Beesly");
    }
    @Test
    public void testShouldFindPatientsWithMoreThanXVisits() {
        // given
        int minVisitCount = 1;

        // when
        List<PatientEntity> result = patientDao.findPatientsWithMoreThanXVisits(minVisitCount);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result)
                .allSatisfy(patient ->
                        assertThat(patient.getVisits().size()).isGreaterThan(minVisitCount)
                );
    }
    @Test
    public void testShouldFindPatientsBornAfterGivenDate() {
        // given
        LocalDate date = LocalDate.of(1980, 1, 1); // przykład: znajdź pacjentów urodzonych po 1 stycznia 1980

        // when
        List<PatientEntity> patients = patientDao.findByDateOfBirthAfter(date);

        // then
        assertThat(patients).isNotEmpty();
        assertThat(patients)
                .allSatisfy(patient ->
                        assertThat(patient.getDateOfBirth()).isAfter(date)
                );
    }
    @Test
    public void testShouldLoadPatientWithVisits() {
        // given
        Long patientId = 101L; // Jim Halpert – ma wiele wizyt w data.sql

        // when
        PatientEntity patient = patientDao.findOne(patientId);

        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getVisits()).isNotEmpty(); // <- uruchomi pobieranie wizyt
    }

    @Test
    public void testShouldThrowOptimisticLockException() {
        // given
        Long patientId = 101L;
        PatientEntity patient1 = patientDao.findOne(patientId);
        PatientEntity patient2 = patientDao.findOne(patientId);

        // when - pierwsza modyfikacja i zapis
        patient1.setEmail("first@update.com");
        patientDao.update(patient1);
        patientDao.flush();

        // then - druga modyfikacja tego samego rekordu
        patient2.setEmail("second@update.com");
        assertThatThrownBy(() -> {
            patientDao.update(patient2);
            patientDao.flush();
        }).isInstanceOf(OptimisticLockException.class);
    }
}

// Wnioski z zadania z Fetch
// FetchMode.SELECT:
// - Jak mieliśmy @Fetch(FetchMode.SELECT) i EAGER, to Hibernate najpierw robił jedno zapytanie o pacjenta,
//   a potem osobne zapytania dla każdej wizyty.
// - W logach było widać, że dla jednego pacjenta z wizytami robi kilka SELECT-ów – to nieefektywne (tzw. problem N+1).
// - Działa, ale robi dużo zapytań, co przy większej liczbie pacjentów może spowolnić aplikację.
//
// FetchMode.JOIN:
// - Jak zmieniliśmy na @Fetch(FetchMode.JOIN), to Hibernate zrobił jedno wspólne zapytanie z JOIN-em (pacjent + wizyty).
// - Szybciej i mniej obciąża bazę, bo wszystko pobierane jest za jednym razem.
// - Działa lepiej i wygodniej, szczególnie przy testach i analizie danych.
//
// Wniosek:
// - FetchMode.JOIN jest bardziej wydajny przy pobieraniu wielu encji z relacją OneToMany.
