package com.saifproject.healthUpdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saifproject.healthUpdate.dto.BP;
import com.saifproject.healthUpdate.dto.Diabetes;
import com.saifproject.healthUpdate.dto.Patient;
import com.saifproject.healthUpdate.service.PatientService;
import com.saifproject.healthUpdate.util.ResponseStructure;

@RestController
@ CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
	
	@Autowired
	private PatientService service;

	@PostMapping("/savePatient")
	 public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient){
		return service.savePatient(patient);
	}
	
	@PostMapping("/updatePatient")
	 public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient){
		return service.updatePatient(patient);
	}
	
	@PostMapping("/updateBp/{pid}")
	 public ResponseEntity<ResponseStructure<Patient>> updatePatientBp(@PathVariable int pid,@RequestBody BP bp){
			return service.updatePatientBp(pid, bp);
		}
	
	@PostMapping("/updateDiabete/{pid}")
	 public ResponseEntity<ResponseStructure<Patient>> updatePatientDiabetes(@PathVariable int pid,@RequestBody Diabetes diabetes){
			return service.updatePatientDiabetes(pid, diabetes);
		}
	
	@PostMapping("/loginPatient/{number}")
	 public ResponseEntity<ResponseStructure<Patient>> loginPatient(@PathVariable long number){
			return service.loginPatient(number);
		}
}
