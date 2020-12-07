package com.jrtp.ies.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CO_PDF")
@Data
public class CoPdfEntity {

	@Id()
	@SequenceGenerator(name="co_pdf_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="co_pdf_id_seq")
	@Column(name = "CO_PDF_ID")
	Integer coPdfId;

	@Column(name = "CASE_NUM")
	Integer caseId;

	@Lob
	@Column(name = "PDF_DOCUMENT", length = 100000)
	byte[] pdfDocument;

	@Column(name = "PLAN_NAME")
	String planName;

	@Column(name = "PLAN_STATUS")
	String PlanStatus;
}
