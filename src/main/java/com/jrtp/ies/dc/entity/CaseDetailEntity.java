package com.jrtp.ies.dc.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="DC_CASES")
@Data
public class CaseDetailEntity {

	@Id
	@SequenceGenerator(name="case_id_seq", allocationSize=1, initialValue=100000)
	@GeneratedValue(generator="case_id_seq")
	@Column(name="case_id")
	private Integer caseId;
	
	@Column(name="APPLICANT_ID")
	private String applicantId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DATE_OF_BIRTH")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfBirth;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="PHONE_NUMBER")
	private long phoneNo;
	
	@Column(name="SOCIAL_SECURITY_NUMBER")
	private Integer socialSecurityNo;
	
	@Column(name="IS_ACTIVE", columnDefinition="BOOLEAN default true")
	private boolean isActive;
	
	@CreationTimestamp
	@Column(name="CREATION_DATE", updatable=false)
	private Timestamp creationDate;
	
	@UpdateTimestamp
	@Column(name="UPDATION_DATE")
	private Timestamp updationDate;
}
