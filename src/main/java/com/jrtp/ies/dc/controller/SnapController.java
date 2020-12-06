package com.jrtp.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.constants.AppConstants;
import com.jrtp.ies.dc.model.IncomeDetail;
import com.jrtp.ies.dc.service.DataCollectionService;

@Controller
public class SnapController {

	@Autowired
	private DataCollectionService dataCollectionServ;
	
	@PostMapping("saveSnapDetails")
	public String handleNextBtn(@ModelAttribute("incomeDet") IncomeDetail incomeDet, Model model) {
		boolean isIncomeDetSaved = dataCollectionServ.saveIncomeDetails(incomeDet);
		String pageName = null;
		if(isIncomeDetSaved) {
			
		}else {
			model.addAttribute("failMsg", AppConstants.SNAP_CASE+" "+AppConstants.PLAN_SAVE_ERRMSG);
		}
		return pageName;
	}
}
