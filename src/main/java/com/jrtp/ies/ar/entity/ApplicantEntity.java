package com.jrtp.ies.ar.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="APPLICANT")
@Data
public class ApplicantEntity {

	@Id
	@GenericGenerator(name="applicant_id_seq", parameters= @Parameter(name="prefix", value="AR"),
		strategy="com.jrtp.ies.utils.ApplicantRegistrationIdGenerator")
	@GeneratedValue(generator="applicant_id_seq")
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
