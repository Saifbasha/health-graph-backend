package com.saifproject.healthUpdate.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saifproject.healthUpdate.dto.Patient;
import com.saifproject.healthUpdate.repository.PateintRepository;

@Repository
public class PatientDao {
	
	@Autowired
	private PateintRepository repository;
	
	public Patient savePatient(Patient patient) {
		return repository.save(patient);
	}
	
	public Patient findPatientById(int id) {
		Optional<Patient> patient= repository.findById(id);
		if(patient.isPresent()) {
			return patient.get();
		}else {
			return null;
		}
	}
	
	public Patient findPatientByNumber(long number) {
		Patient patient= repository.findByNumber(number);
		if(patient!=null) {
			return patient;
		}else {
			return null;
		}
	}
}
