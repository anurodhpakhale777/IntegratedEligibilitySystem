package com.jrtp.ies.batch;

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
