package com.hr.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StudentAdmissionController {
 
	@RequestMapping("/hello/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name) {
		ModelAndView objModelAndView = new ModelAndView("HelloPage"); // helloPage.jsp
		objModelAndView.addObject("welcomeMessage","Hello " + name + "!!");
		return objModelAndView;
	}
	
	@RequestMapping("/hi/{userName}/{countryName}")
	public ModelAndView hiWorld(@PathVariable Map<String, String> pathVars) {
		String name = pathVars.get("userName");
		String countryName = pathVars.get("countryName");
		ModelAndView objModelAndView = new ModelAndView("HelloPage"); // helloPage.jsp
		objModelAndView.addObject("welcomeMessage","Hi " + name + ". You are from " + countryName);
		return objModelAndView;
	}
	
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView admissionFormView = new ModelAndView("AdmissionForm"); // jsp page
		return admissionFormView;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqMap) {
		String name = reqMap.get("studentName");
		String hobby = reqMap.get("hobby");
		
		ModelAndView studentView = new ModelAndView("AdmissionSuccess"); // jsp page
		studentView.addObject("msg","Student Name : " + name + ". Hooby : " + hobby);
		
		return studentView;
	}
}
