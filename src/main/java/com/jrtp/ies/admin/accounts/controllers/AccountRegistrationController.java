package com.jrtp.ies.admin.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jrtp.ies.admin.accounts.models.UserAccount;
import com.jrtp.ies.admin.accounts.services.UserAccountService;

@Controller
public class AccountRegistrationController {

	@Autowired
	private UserAccountService userAccServ;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("registrationForm")
	public String loadRegistrationForm(Model model) {
		UserAccount userAcc = new UserAccount();
		model.addAttribute("userAcc", userAcc);
		return "userRegistrationForm";
	}
	
	@PostMapping("registerUser")
	public String handleRegisterBtn(@ModelAttribute("userAcc") UserAccount userAcc, Model model) {
		boolean isUserSaved = userAccServ.saveUserAccount(userAcc);
		if(isUserSaved)
			model.addAttribute("succMsg", "Registration Success...");
		else
			model.addAttribute("failMsg", "Registration Failed...");
		return "userRegistrationForm";
	}
}
