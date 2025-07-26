package com.saifproject.healthUpdate.exception;

public class DataNotFound extends RuntimeException {
	
	String s="Data not found";

	@Override
	public String getMessage() {
		return s;
	}
	
	public DataNotFound() {
		
	}

	public DataNotFound(String s) {
			this.s=s;
		}
	
}
