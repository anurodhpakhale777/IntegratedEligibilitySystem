package com.jrtp.ies.co.model;

import java.sql.Blob;

import lombok.Data;

@Data
public class CorespondencePdf {
	
	private Integer corrPdfId;
	private String planStatus;
	private int caseId;
	private Blob pdfDocument;
	private String planName;
}
