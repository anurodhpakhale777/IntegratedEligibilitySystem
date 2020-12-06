package com.jrtp.ies.dc.model;

import lombok.Data;

@Data
public class ChildDetail {

	private Integer id;
	
	private Integer caseId;
	
	private String applicantName;
	
	private String childName;
	
	private String childGender;
	
	private String childDob;
	
	private String childSsn;
	
	private boolean isActive;
}
