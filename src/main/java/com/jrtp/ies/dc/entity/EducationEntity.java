package com.jrtp.ies.dc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="DC_EDUCATION")
@Data
public class EducationEntity {

	@Id
	@Column(name="CASE_ID")
	private Integer caseId;
	
	@Column(name="APPLICANT_NAME")
	private String applicantName;
	
	@Column(name="HIGHEST_QUALIFICATION")
	private String qualification;
	
	@Column(name="GRADE")
	private String grade;
	
	@Column(name="COMPLETED_YEAR")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate completedYear;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
}
