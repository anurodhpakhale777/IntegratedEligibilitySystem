package com.jrtp.ies.ed.model;

import java.util.Date;

import lombok.Data;

@Data
public class EligibilityDetails {

	private int traceId;
	private long benefitAmt;
	private int caseId;
	private Date creationDate;
	private String denialReason;
	private Date PlanEndDate;
	private String planName;
	private Date planStartDate;
	private String planStatus;
	private Date updationDate;
}
