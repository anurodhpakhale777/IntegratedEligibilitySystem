package com.jrtp.ies.co.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="BATCH_RUN_DTLS")
@Data
public class BatchRunDetailEntity {

	@Id
	@SequenceGenerator(name="BATCH_RUN_SEQ", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="BATCH_RUN_SEQ")
	@Column(name="BATCH_RUN_SEQ")
	private Integer batchRunSeq;
	
	@Column(name="BATCH_NAME")
	private String batchName;
	
	@Column(name="BATCH_RUN_STATUS")
	private String batchRunStatus;
	
	@Column(name="INSTANCE_NUM")
	private int instanceNum;
	
	@DateTimeFormat(pattern="dd-MM-yyyy hh-mm-ss")
	@Column(name="START_DATE")
	private Date startDate;
	
	@DateTimeFormat(pattern="dd-MM-yyyy hh-mm-ss")
	@Column(name="END_DATE")
	private Date endDate;
}
