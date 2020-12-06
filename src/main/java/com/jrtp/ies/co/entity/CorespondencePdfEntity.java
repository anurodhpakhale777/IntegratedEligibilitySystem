package com.jrtp.ies.co.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CO_PDFs")
@Data
public class CorespondencePdfEntity {

	@Id
	@SequenceGenerator(name="co_pdf_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="co_pdf_id_seq")
	@Column(name="CO_PDF_ID")
	private Integer corrPdfId;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="CASE_NUM")
	private int caseId;
	
	@Column(name="PDF_DOCUMENT")
	private Blob pdfDocument;
	
	@Column(name="PLAN_NAME")
	private String planName; 
}
