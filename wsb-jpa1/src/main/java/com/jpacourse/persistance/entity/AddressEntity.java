package com.jpacourse.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	// Dwustronna relacja z Doctor (od strony dziecka)
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DoctorEntity> doctors;

	// Dwustronna relacja z Patient (od strony dziecka)
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PatientEntity> patients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public List<DoctorEntity> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<DoctorEntity> doctors) {
		this.doctors = doctors;
	}
	public List<PatientEntity> getPatients() {
		return patients;
	}
	public void setPatients(List<PatientEntity> patients) {
		this.patients = patients;
	}
}
