package com.saifproject.healthUpdate.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saifproject.healthUpdate.util.ResponseStructure;
import com.saifproject.healthUpdate.exception.*;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(DataNotFound.class)
	public ResponseEntity<ResponseStructure<String>> DataNotFound(DataNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMsg("Data not found");
		structure.setData(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
