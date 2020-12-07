package com.jrtp.ies.dc.model;

import lombok.Data;

@Data
public class IncomeDetail {

	private int caseId;
	
	private String applicantName;
	
	private boolean isWorking;
	
	private long otherIncome;
}
