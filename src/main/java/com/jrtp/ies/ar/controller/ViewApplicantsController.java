package com.jrtp.ies.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.ar.service.ApplicantRegistrationService;

@Controller
public class ViewApplicantsController {

	@Autowired
	private ApplicantRegistrationService applicantRegServ;
	
	@GetMapping("viewApplicants")
	public String loadViewAccountsForm(Model model) {
		List<Applicant> applicantList = applicantRegServ.getAllApplicants();
		model.addAttribute("applicantList",applicantList);
		return "viewApplicants";
	}
	
	@GetMapping("editApplicant")
	public String handleEditApplicantBtn(@RequestParam("applicantId") String applicantId, Model model) {
		Applicant applicant = applicantRegServ.editApplicant(applicantId);
		model.addAttribute("applicant", applicant);
		return "editApplicant";
	}
	
	@PostMapping("updateApplicant")
	public String handleUpdateApplicantBtn(@ModelAttribute("applicant") Applicant applicant, Model model) {
		boolean isApplicantUpdated = applicantRegServ.updateApplicant(applicant);
		if(isApplicantUpdated)
			model.addAttribute("succMsg", "Applicant Updation Successful...");
		else
			model.addAttribute("failMsg", "Applicant Updation Failed...");
		return "editApplicant";
	}
	
	@RequestMapping("deleteApplicant")
	public String handleDeleteApplicantBtn(@RequestParam String applicantId, Model model) {
		boolean isApplicantDeleted = applicantRegServ.deleteApplicant(applicantId);
		if(isApplicantDeleted)
			model.addAttribute("succMsg", "Applicant Deleted Successful...");
		else
			model.addAttribute("failMsg", "Applicant Deletion Failed...");
		return "viewApplicants";
	}
}
