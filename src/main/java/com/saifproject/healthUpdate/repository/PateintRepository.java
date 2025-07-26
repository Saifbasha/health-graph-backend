package com.saifproject.healthUpdate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saifproject.healthUpdate.dto.Patient;

public interface PateintRepository extends JpaRepository<Patient, Integer>{
	public Patient findByNumber(long number);
}
