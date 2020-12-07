package com.jrtp.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.constants.AppConstants;
import com.jrtp.ies.dc.model.CasePlan;
import com.jrtp.ies.dc.model.ChildDetail;
import com.jrtp.ies.dc.model.EducationDetail;
import com.jrtp.ies.dc.model.IncomeDetail;
import com.jrtp.ies.dc.service.DataCollectionService;

@Controller
public class SelectPlanController {

	@Autowired
	private DataCollectionService dataCollectionServ;
	
	@PostMapping("selectPlan")
	public String handleNextBtn(@ModelAttribute("casePlan") CasePlan casePlan, Model model) {
		boolean isCasePlanSaved = dataCollectionServ.saveCasePlanDetails(casePlan);
		String pageName = null;
		if(isCasePlanSaved) {
			switch (casePlan.getPlanName()) {
			case AppConstants.SNAP_CASE: 
				IncomeDetail incomeDet = new IncomeDetail();
				incomeDet.setCaseId(casePlan.getCaseId());
				incomeDet.setApplicantName(casePlan.getFirstName()+" "+casePlan.getLastName());
				model.addAttribute("incomeDet", incomeDet);
				pageName = "incomeDetails";
				break;
				
			case AppConstants.CCAP_CASE:
				ChildDetail childDet = new ChildDetail();
				childDet.setCaseId(casePlan.getCaseId());
				childDet.setApplicantName(casePlan.getFirstName()+" "+casePlan.getLastName());
				model.addAttribute("childDet", childDet);
				pageName = "childDetails";
				break;
			
			case AppConstants.KT_WORKS_CASE:
				EducationDetail educationDet = new EducationDetail();
				educationDet.setCaseId(casePlan.getCaseId());
				educationDet.setApplicantName(casePlan.getFirstName()+" "+casePlan.getLastName());
				model.addAttribute("educationDet", educationDet);
				pageName = "educationDetails";
				break;
			
			default:
				model.addAttribute("failMsg", "Page Not Found");
				pageName = "selectPlan";
				break;
			}
			
		}else {
			model.addAttribute("failMsg", "CasePlan Details Not Saved...");
			pageName = "selectPlan";
		}
		return pageName;
	}
}
