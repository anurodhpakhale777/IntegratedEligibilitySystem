package com.jrtp.ies.admin.plans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.admin.plans.models.Plan;
import com.jrtp.ies.admin.plans.services.PlanService;

@Controller
public class PlanCreationController {

	@Autowired
	private PlanService planServ;
	
	@GetMapping("createPlan")
	public String loadPlanCreationForm(Model model) {
		model.addAttribute("plan", new Plan());
		return "createPlan";
	}
	
	@PostMapping("savePlan")
	public String handleCreatePlanBtn(@ModelAttribute("plan") Plan plan, Model model) {
		boolean isPlanSaved = planServ.savePlan(plan);
		if(isPlanSaved)
			model.addAttribute("succMsg", "Plan Created Successfully...");
		else
			model.addAttribute("failMsg", "Plan Creation Failed...");
		return "createPlan";
	}
}