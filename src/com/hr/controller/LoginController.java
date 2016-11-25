package com.hr.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * This method will be entry point for the application.
	 * @return
	 */
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcomePage(Model model, Principal principal) {
		System.out.println("In login controller");
		String name = principal.getName();
		model.addAttribute("userName", name);
		model.addAttribute("message", "security example");
		return "hello";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("in log in");
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginfailed(ModelMap model) {
		System.out.println("in log in fail");
		model.addAttribute("error",true);
		return "login";
	}
	
	/*@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		System.out.println("in log out");
		return "login";
	}*/
	
}
