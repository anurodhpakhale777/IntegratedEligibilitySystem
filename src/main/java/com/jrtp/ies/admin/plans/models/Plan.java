package com.jrtp.ies.admin.plans.models;

import lombok.Data;

@Data
public class Plan {

	private Integer planId;
	
	private String planName;
	
	private String planDesc;
	
	private String planStartDate;
	
	private String planEndDate;
	
	private boolean isActive;
}
