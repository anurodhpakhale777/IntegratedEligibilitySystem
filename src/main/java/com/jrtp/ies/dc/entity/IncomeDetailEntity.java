package com.jrtp.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_INCOME")
@Data
public class IncomeDetailEntity {

	@Id
	@Column(name="CASE_ID")
	private Integer caseId;
	
	@Column(name="APPLICANT_NAME")
	private String applicantName;
	
	@Column(name="IS_WORKING")
	private boolean isWorking;
	
	@Column(name="OTHER_INCOME")
	private long otherIncome;
}
