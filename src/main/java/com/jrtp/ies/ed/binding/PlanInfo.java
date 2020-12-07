package com.jrtp.ies.ed.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanInfo {

	private String planName;
	private String planStatus;
	
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	
	private String denialReason;
}
