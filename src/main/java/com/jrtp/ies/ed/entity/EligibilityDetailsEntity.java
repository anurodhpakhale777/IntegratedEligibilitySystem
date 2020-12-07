package com.jrtp.ies.ed.entity;

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
@Table(name="ELIGIBILITY_DETAILS")
@Data
public class EligibilityDetailsEntity {

	@Id
	@SequenceGenerator(name="ed_trace_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="ed_trace_id_seq")
	@Column(name="ED_TRACE_ID")
	private Integer edTraceId;
	
	@Column(name="CASE_NUM")
	private int caseId;
	
	@Column(name="PLAN_NAME")
	private String planName;

	@Column(name="PLAN_STATUS")
	private String planStatus;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="PLAN_START_DATE")
	private Date planStartDate;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="PLAN_END_DATE")
	private Date PlanEndDate;

	@Column(name="BENEFIT_AMT")
	private long benefitAmt;
	
	@Column(name="DENIAL_REASON")
	private String denialReason;

	@CreationTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="CREATE_DATE")
	private Date creationDate;
	
	@UpdateTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="UPDATE_DATE")
	private Date updationDate;
}
