package com.jrtp.ies.ed.model;

import java.util.Date;

import lombok.Data;

@Data
public class CorrespondenceTrigger {

	private int triggerId;
	private int caseId;
	private Date creationDate;
	private char triggerStatus;
	private Date updationDate;
}
