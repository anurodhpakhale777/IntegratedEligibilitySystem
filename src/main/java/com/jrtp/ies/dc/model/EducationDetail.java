package com.jrtp.ies.dc.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EducationDetail {

	private Integer caseId;
	
	private String applicantName;
	
	private String qualification;
	
	private String grade;
	
	private LocalDate completedYear;
	
	private String isActive;
}
