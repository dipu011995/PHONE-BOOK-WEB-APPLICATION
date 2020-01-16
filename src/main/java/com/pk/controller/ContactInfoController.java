package com.pk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pk.constraints.AppConstraints;
import com.pk.domain.Contact;
import com.pk.service.ContactService;

/**
 * ContactInfoController(C) is bind the form data with model class and handle
 * with form page
 *
 * This class inject service to interact with service class to perform CRUD
 * operation
 */
@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	/**
	 * This method bind the model class with form and return logical view name where
	 * form will be displayed
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	public String displayContactForm(Model model) {

		Contact c = new Contact();

		model.addAttribute(AppConstraints.CONTACT, c);

		return AppConstraints.CONTACTINFO;
	}

	/**
	 * This Method is to interact with service data to save or update Data
	 * 
	 * @param c
	 * @param model
	 * @param attribute
	 * @return
	 */
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handelSubmitButton(@ModelAttribute("contact") Contact c, Model model, RedirectAttributes attribute) {

		boolean saveContact = contactService.saveContact(c);

		if (saveContact)
			attribute.addFlashAttribute(AppConstraints.SUCESSRESULT, "Contact Saved Sucessfully");
		else
			attribute.addFlashAttribute(AppConstraints.ERRORRESULT, "Contact Not Saved");
		
		return AppConstraints.REDIRECTSAVESUCESSCONTACT;
	}

	/**
	 * This Method is to solve Double Posting problem using PRG(POST Redirect to
	 * GET) Pattern
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveSucessContact", method = RequestMethod.GET)
	public String solveDoublePostingProblem(Model model) {

		Contact c = new Contact();

		model.addAttribute(AppConstraints.CONTACT, c);

		return AppConstraints.CONTACTINFO;
	}

	/**
	 * This method is to get all contact from service and view All contact in
	 * viewContact.jsp
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewContact", method = RequestMethod.GET)
	public String viewContact(Model model) {

		List<Contact> allContact = contactService.getAllContact();

		model.addAttribute(AppConstraints.CONTACTLIST, allContact);

		return AppConstraints.VIEWCONTACT;
	}

}
