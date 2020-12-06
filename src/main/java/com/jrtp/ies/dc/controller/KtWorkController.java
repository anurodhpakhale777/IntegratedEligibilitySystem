package com.jrtp.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.constants.AppConstants;
import com.jrtp.ies.dc.model.EducationDetail;
import com.jrtp.ies.dc.service.DataCollectionService;

@Controller
public class KtWorkController {

	@Autowired
	private DataCollectionService dataCollectionServ;
	
	@PostMapping("saveKtWorkDetails")
	public String handleAddBtn(@ModelAttribute("educationDet") EducationDetail educationDet, Model model) {
		boolean isEducationDetSaved = dataCollectionServ.saveEducationDetails(educationDet);
		String pageName = null;
		if(isEducationDetSaved) {
			
		}else {
			model.addAttribute("failMsg", AppConstants.KT_WORKS_CASE+" "+AppConstants.PLAN_SAVE_ERRMSG);
		}
		return pageName;
	}
}
