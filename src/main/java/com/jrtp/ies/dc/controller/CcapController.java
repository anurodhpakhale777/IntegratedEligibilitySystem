package com.jrtp.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrtp.ies.constants.AppConstants;
import com.jrtp.ies.dc.model.ChildDetail;
import com.jrtp.ies.dc.service.DataCollectionService;

@Controller
public class CcapController {

	@Autowired
	private DataCollectionService dataCollectionServ;
	
	@PostMapping("saveCcapDetails")
	public String handleAddBtn(@ModelAttribute("childDet") ChildDetail childDet, Model model) {
		boolean isChildDetSaved = dataCollectionServ.saveChildCareDetails(childDet);
		String pageName = null;
		if(isChildDetSaved) {
			model.addAttribute("caseId", childDet.getCaseId());
			pageName = "eligibilityDetermination";
		}else {
			model.addAttribute("failMsg", AppConstants.CCAP_CASE+" "+AppConstants.PLAN_SAVE_ERRMSG);
			pageName = "childDetails";
		}
		return pageName;
	}
	
	@GetMapping("editChild")
	public String handleEditChildBtn(@RequestParam("id") Integer childId, Model model) {
		ChildDetail savedChildDet = dataCollectionServ.editChildDetails(childId);
		if(null != savedChildDet) {
			model.addAttribute("childDet", savedChildDet);
		}else {
			model.addAttribute("failMsg", "Child is not Present");
		}
		return "editChild";
	}
	
	@PostMapping("updateChild")
	public String handleUpdateChildBtn(@ModelAttribute("childDet") ChildDetail childDet) {
		boolean ischildUpdated = dataCollectionServ.updateChildDetails(childDet);
		return ischildUpdated ? "Child Successfully Updated..." : "Childt is NOT Updated Successfully...";
	}
	
	@RequestMapping("deleteChild")
	public String handleDeleteChildBtn(@RequestParam("id") Integer childId) {
		boolean isChildDeleted = dataCollectionServ.deleteChildDetails(childId);
		return isChildDeleted ? "Child In-Activated Successfully..." : "Child is NOT In-Activated Successfully...";
	}
	
	@GetMapping("next")
	public String handleNextBtn() {
		return null;
	}
}
