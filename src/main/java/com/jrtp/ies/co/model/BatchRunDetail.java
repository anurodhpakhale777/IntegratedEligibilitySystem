package com.jrtp.ies.co.model;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDetail {

	private Integer batchRunSeq;
	private String batchName;
	private String batchRunStatus;
	private int instanceNum;
	private Date startDate;
	private Date endDate;
}
