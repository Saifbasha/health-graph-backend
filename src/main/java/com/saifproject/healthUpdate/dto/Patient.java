package com.saifproject.healthUpdate.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Patient {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(nullable = false)
	private String p_name;
	
	@Column(nullable = false)
	private long number;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BP> bp;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Diabetes> diabetes;
}
