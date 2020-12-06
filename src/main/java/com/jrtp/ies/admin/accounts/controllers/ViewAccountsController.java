package com.jrtp.ies.admin.accounts.controllers;

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

import com.jrtp.ies.admin.accounts.models.UserAccount;
import com.jrtp.ies.admin.accounts.services.UserAccountService;

@Controller
public class ViewAccountsController {

	@Autowired
	private UserAccountService userAccServ;
	
	@GetMapping("viewAccounts")
	public String loadViewAccountsForm(@RequestParam String role, Model model) {
		List<UserAccount> userAccList = userAccServ.getAllUserAccounts(role);
		model.addAttribute("userAccList",userAccList);
		return "viewUserAccounts";
	}
	
	@GetMapping("editAccount")
	public String handleEditAccountBtn(@RequestParam Integer id, Model model) {
		UserAccount userAcc = userAccServ.editUserAccount(id);
		model.addAttribute("userAcc", userAcc);
		return "editUserAccount";
	}
	
	@PostMapping("updateAccount")
	@ResponseBody
	public String handleUpdateUserAccountBtn(@ModelAttribute("userAcc") UserAccount userAcc) {
		boolean isUserAccUpdated = userAccServ.updateUserAccount(userAcc);
		return isUserAccUpdated ? "User Account Successfully Updated..." : "User Account is NOT Updated Successfully...";
	}
	
	@RequestMapping("deleteAccount")
	@ResponseBody
	public String handleDeleteAccBtn(@RequestParam Integer id) {
		boolean isUserAccDeleted = userAccServ.deleteUserAccount(id);
		return isUserAccDeleted ? "User Account In-Activated Successfully..." : "User Account is NOT In-Activated Successfully...";
	}
}
