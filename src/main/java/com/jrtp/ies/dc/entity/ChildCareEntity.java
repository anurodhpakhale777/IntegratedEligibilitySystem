package com.jrtp.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_CHILDS")
@Data
public class ChildCareEntity {

	@Id
	@SequenceGenerator(name="child_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="child_id_seq")
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CASE_ID")
	private Integer caseId;
	
	@Column(name="APPLICANT_NAME")
	private String applicantName;
	
	@Column(name="CHILD_NAME")
	private String childName;
	
	@Column(name="CHILD_GENDER")
	private String childGender;
	
	@Column(name="CHILD_DATE_OF_BIRTH")
	private String childDob;
	
	@Column(name="CHILD_SSN")
	private String childSsn;
	
	@Column(name="IS_ACTIVE", columnDefinition="BOOLEAN default true")
	private boolean isActive;
	
}
