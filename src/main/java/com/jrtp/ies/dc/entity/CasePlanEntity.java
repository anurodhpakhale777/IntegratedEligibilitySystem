package com.jrtp.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_PLAN")
@Data
public class CasePlanEntity {

	@Id
	@Column(name="CASE_ID")
	private Integer caseId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PLAN_NAME")
	private String planName;
}
