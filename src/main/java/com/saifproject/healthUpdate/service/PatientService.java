package com.saifproject.healthUpdate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saifproject.healthUpdate.dao.PatientDao;
import com.saifproject.healthUpdate.dto.BP;
import com.saifproject.healthUpdate.dto.Diabetes;
import com.saifproject.healthUpdate.dto.Patient;
import com.saifproject.healthUpdate.exception.DataNotFound;
import com.saifproject.healthUpdate.util.ResponseStructure;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao dao;
	
	ResponseStructure<Patient> structure=new ResponseStructure<Patient>();
	
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient){
		long no=patient.getNumber();
		Patient patient2=dao.findPatientByNumber(no);
		if(patient2==null) {
			structure.setMsg("Patient details successfully enterd");
			structure.setData(dao.savePatient(patient));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new DataNotFound("Data Already Exist");
		}
	}
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient){
		int id=patient.getPid();
		Patient patient2=dao.findPatientById(id);
		if(patient2!=null) {
			List<BP> listBp=patient2.getBp();
			List<Diabetes> listDiabetes=patient2.getDiabetes();
			
			patient.setBp(listBp);
			patient.setDiabetes(listDiabetes);
			structure.setMsg("Patient details successfully enterd");
			structure.setData(dao.savePatient(patient));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new DataNotFound("Data not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatientBp(int pid , BP bp){
		
		Patient patient=dao.findPatientById(pid);
		List<BP> listBp=patient.getBp();
		listBp.add(bp);
		
		structure.setMsg("Bp updated successfully");
		structure.setData(dao.savePatient(patient));
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatientDiabetes(int pid, Diabetes diabetes){
		Patient patient=dao.findPatientById(pid);
		List<Diabetes> list=patient.getDiabetes();
		list.add(diabetes);
		
		structure.setMsg("Diabetes updated successfully");
		structure.setData(dao.savePatient(patient));
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> loginPatient(long number){
		Patient patient=dao.findPatientByNumber(number);
		
		if(patient!=null) {
			 
			structure.setMsg("Login Successfully Done....!");
			structure.setData(patient);
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Patient>> (structure,HttpStatus.OK);
		}else {
			throw new DataNotFound("Number not exist in our Database");
		}
	}
	
}
