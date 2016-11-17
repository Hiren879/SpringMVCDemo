package com.hr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hr.model.Student;
import com.hr.util.StudentNameEditor;


/**
 * This class is responsible for handing all requests related to student admission form.
 * @author hsavalia
 *
 */
@Controller
public class StudentAdmissionController {

	/** This method is responsible for manipulating bindings before Spring actually binds data with instance variables.
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// do not bind "studentMobile"
		// setDisallowedFields : This will exclude "studentMobile" attribute from binding to class Student.
		binder.setDisallowedFields(new String[] {"studentMobile"});
		
		// customized date format
		SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy--MM--dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(objSimpleDateFormat, false));
		
		// customized property editor for student name
		// Spring will not bind value for studenName until it consults to StudentNameEditor class here
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	/**
	 * This method will add this head message to all view which can be accessible through "headerMessage" attribute. 
	 * @param objModel
	 */
	@ModelAttribute
	public void addCommonHeader(Model objModel) {
		objModel.addAttribute("headerMessage","DA-IICT, Gandhinagar");
	}
 
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
	
	/*
	 *Part 1
	 *Here we are accessing UI components using their names, individually, using RequestParam into Map.
	 *
	 * 
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqMap) {
		String name = reqMap.get("studentName");
		String hobby = reqMap.get("hobby");
		
		ModelAndView studentView = new ModelAndView("AdmissionSuccess"); // jsp page
		studentView.addObject("msg","Student Name : " + name + ". Hooby : " + hobby);
		
		return studentView;
	}
	*/
	
	/**
	 * Part 2
	 * Above method can be written using "ModelAttribute" which will bind class to UI params
	 * UI name should be same as the instance variable names of the model class so Spring can map it directly.
	 * @param reqMap
	 * @return : ModelView object for success jsp page with Student Object.
	 */
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("objStudent") Student objStudent, BindingResult result) {
		// BindingResult : this will help to catch all binding related errors 
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return new ModelAndView("AdmissionForm");
		}
		ModelAndView studentView = new ModelAndView("AdmissionSuccess"); // jsp page
		// no need to even create & add objStudent in view object.
		return studentView;
	}
	
	
}
