package com.jrtp.ies.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp.ies.ed.binding.PlanInfo;
import com.jrtp.ies.ed.service.EligibilityDeterminationService;

@Controller
public class EligibilityDeterminationController {

	@Autowired
	private EligibilityDeterminationService eligibilityDeterServ;
	
	@PostMapping("determineEligibility")
	public String handleDetermineEligibilityBtn(@RequestParam("caseId") Integer caseId, Model model) {
		PlanInfo planInfo = eligibilityDeterServ.determineEligibility(caseId);
		model.addAttribute("planInfo", planInfo);
		return "eligibilityDetermination";
	}
}
