package com.jrtp.ies.ar.model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Applicant {

	private String applicantId;
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfBirth;
	
	private String gender;
	
	private String emailId;
	
	private long phoneNo;
	
	private Integer socialSecurityNo;
	
	private boolean isActive;
}
