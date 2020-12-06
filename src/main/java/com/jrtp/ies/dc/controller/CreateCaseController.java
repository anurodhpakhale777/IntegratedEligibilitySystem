package com.jrtp.ies.dc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.dc.model.CaseDetail;
import com.jrtp.ies.dc.model.CasePlan;
import com.jrtp.ies.dc.service.DataCollectionService;

@Controller
public class CreateCaseController {

	@Autowired
	private DataCollectionService dataCollectionServ;
	
	@GetMapping("caseForm")
	public String loadCreateCaseForm(Model model) {
		return "createCase";
	}
	
	@GetMapping("searchApplicant")
	public String searchApplicantInfo(@RequestParam("applicantId") String applicantId, Model model) {
		Applicant applicant = dataCollectionServ.getApplicantDetails(applicantId);
		if(null != applicant) {
			//model.addAttribute("applicant", applicant);
			String dateStr = applicant.getDateOfBirth().toString();
			try {
				applicant.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(dateStr));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			model.addAttribute("applicant", applicant);
			model.addAttribute("case", new CaseDetail());
		}else {
			model.addAttribute("failMsg", "Applicant Not Found...");
		}
		return "createCase";
	}
	
	@PostMapping("createCase")
	public String handleCreateCaseBtn(@ModelAttribute("case") CaseDetail caseDet, Model model) {
		boolean isCaseDetSaved = dataCollectionServ.saveCaseDetails(caseDet);
		if(isCaseDetSaved) {
			CasePlan casePlan = new CasePlan();
			casePlan.setCaseId(caseDet.getCaseId());
			casePlan.setFirstName(caseDet.getFirstName());
			casePlan.setLastName(caseDet.getLastName());
			model.addAttribute("casePlan", casePlan);
			model.addAttribute("planNames", dataCollectionServ.getAllPlanNames());
			return "selectPlan";
		}else {
			model.addAttribute("failMsg", "Case Details Not Saved...");
			return "createCase";
		}
	}
}
