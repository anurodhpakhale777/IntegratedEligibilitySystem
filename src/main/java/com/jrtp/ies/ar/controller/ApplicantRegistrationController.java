package com.jrtp.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.ar.service.ApplicantRegistrationService;

@Controller
public class ApplicantRegistrationController {

	@Autowired
	private ApplicantRegistrationService applicantRegServ;
	
	@GetMapping("applRegForm")
	public String loadApplicantRegistrationForm(Model model) {
		Applicant applicant = new Applicant();
		model.addAttribute("applicant", applicant);
		return "applicantRegistrationForm";
	}
	
	@PostMapping("registerApplicant")
	public String handleRegisterBtn(@ModelAttribute("applicant") Applicant applicant, Model model) {
		String  ssnValidationStr = applicantRegServ.checkValidSsn(applicant.getSocialSecurityNo());
		if("Valid Citizen".equals(ssnValidationStr)) {
			boolean isApplicantSaved = applicantRegServ.saveApplicant(applicant);
			if(isApplicantSaved)
				model.addAttribute("succMsg", "Registration Success...");
			else
				model.addAttribute("failMsg", "Registration Failed...");
		}else {
			model.addAttribute("failMsg", ssnValidationStr);
		}
		return "applicantRegistrationForm";
	}
}
