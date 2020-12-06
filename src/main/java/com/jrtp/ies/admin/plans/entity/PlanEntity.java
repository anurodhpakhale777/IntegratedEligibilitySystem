package com.jrtp.ies.admin.plans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PLAN")
public class PlanEntity {

	@Id
	@SequenceGenerator(name="plan_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="plan_id_seq")
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESCRIPTION")
	private String planDesc;
	
	@Column(name="PLAN_START_DATE")
	private String planStartDate;
	
	@Column(name="PLAN_END_DATE")
	private String planEndDate;
	
	@Column(name="IS_ACTIVE", columnDefinition="BOOLEAN default true")
	private boolean isActive = true;
	
}
