package com.jrtp.ies.admin.plans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrtp.ies.admin.plans.models.Plan;
import com.jrtp.ies.admin.plans.services.PlanService;

@Controller
public class ViewPlansController {

	@Autowired
	private PlanService planServ;
	
	@GetMapping("viewPlans")
	public String loadViewPlansForm(Model model) {
		List<Plan> planList = planServ.getAllPlans();
		model.addAttribute("planList",planList);
		return "viewPlans";
	}
	
	@GetMapping("editPlan")
	public String handleEditPlanBtn(@RequestParam Integer planId, Model model) {
		Plan plan = planServ.editPlan(planId);
		model.addAttribute("plan", plan);
		return "editPlan";
	}
	
	@PostMapping("updatePlan")
	@ResponseBody
	public String handleUpdatePlanBtn(@ModelAttribute("plan") Plan plan) {
		boolean isPlanUpdated = planServ.updatePlan(plan);
		return isPlanUpdated ? "Plan Successfully Updated..." : "Plan is NOT Updated Successfully...";
	}
	
	@RequestMapping("deletePlan")
	@ResponseBody
	public String handleDeletePlanBtn(@RequestParam Integer planId) {
		boolean isPlanDeleted = planServ.deletePlan(planId);
		return isPlanDeleted ? "Plan In-Activated Successfully..." : "Plan is NOT In-Activated Successfully...";
	}
}
