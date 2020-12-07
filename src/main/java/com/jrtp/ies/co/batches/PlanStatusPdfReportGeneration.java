package com.jrtp.ies.co.batches;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jrtp.ies.ed.model.EligibilityDetails;

@Component
public final class PlanStatusPdfReportGeneration {

	public static void buildPlanApPdf(EligibilityDetails eligibilityDet) {
		try {
			Document document = new Document();
			FileOutputStream fos = new FileOutputStream("D:\\AshokIt\\11-JRTPWorkspace\\IntregatedEligibitySystem\\CO_PDFS\\" + eligibilityDet.getCaseId() + ".pdf");
			PdfWriter.getInstance(document, fos);

			// open document
			document.open();

			// Creating paragraph
			Paragraph p = new Paragraph();
			p.add("Approved Plan Details");
			p.setAlignment(Element.ALIGN_CENTER);

			// adding paragraph to document
			document.add(p);

			// Create Table object, Here 2 specify the no. of columns
			PdfPTable pdfPTable = new PdfPTable(2);

			// First row in table
			pdfPTable.addCell(new PdfPCell(new Paragraph("Case Number")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getCaseId())));

			// Second Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan Name")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanName())));

			// Third Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan Status")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanStatus())));

			// Fourth Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan Start Date")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanStartDate().toString())));

			// Fifth Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan End Date")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanEndDate().toString())));

			// sixth Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Benfit Amount")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getBenefitAmt())));

			// Add content to the document using Table objects.
			document.add(pdfPTable);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void buildPlanDnPdf(EligibilityDetails eligibilityDet) {
		try {
			Document document = new Document();
			FileOutputStream fos = new FileOutputStream("D:\\AshokIt\\11-JRTPWorkspace\\IntregatedEligibitySystem\\CO_PDFS\\" + eligibilityDet.getCaseId() + ".pdf");
			PdfWriter.getInstance(document, fos);

			// open document
			document.open();

			// Creating paragraph
			Paragraph p = new Paragraph();
			p.add("Denied Plan Details");
			p.setAlignment(Element.ALIGN_CENTER);

			// adding paragraph to document
			document.add(p);

			// Create Table object, Here 2 specify the no. of columns
			PdfPTable pdfPTable = new PdfPTable(2);

			// First row in table
			pdfPTable.addCell(new PdfPCell(new Paragraph("Case Number")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getCaseId())));

			// Second row in table
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan Name")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanName())));

			// Third Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Plan Status")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getPlanStatus())));

			// Fourth Row
			pdfPTable.addCell(new PdfPCell(new Paragraph("Denial Reason")));
			pdfPTable.addCell(new PdfPCell(new Paragraph(eligibilityDet.getDenialReason())));

			// Add content to the document using Table objects.

			document.add(pdfPTable);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
