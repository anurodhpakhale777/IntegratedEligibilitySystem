package com.jrtp.ies.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="CO_TRIGGER")
@Data
public class CorrespondenceTriggerEntity {

	@Id
	@SequenceGenerator(name="trigger_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="trigger_id_seq")
	@Column(name="TRIGGER_ID")
	private Integer triggerId;
	
	@Column(name="CASE_NUM")
	private int caseId;
	
	@CreationTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="CREATE_DATE")
	private Date creationDate;
	
	@Column(name="TRIGGER_STATUS")
	private char triggerStatus;
	
	@UpdateTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="UPDATE_DATE")
	private Date updationDate;
}
