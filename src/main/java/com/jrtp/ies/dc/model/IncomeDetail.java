package com.jrtp.ies.dc.model;

import lombok.Data;

@Data
public class IncomeDetail {

	private short caseId;
	
	private String applicantName;
	
	private boolean isWorking;
	
	private long otherIncome;
}
