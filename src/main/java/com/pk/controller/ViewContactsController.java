package com.pk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.constraints.AppConstraints;
import com.pk.domain.Contact;
import com.pk.service.ContactService;

/**
 * This class inject service to interact with service class to perform CRUD
 * operation
 */

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService contactService;

	/**
	 * This Method is interact with service to get the data from DB and reflect all
	 * the data in from to edit/update contact details when press edit button
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public String editContact(HttpServletRequest req, Model model) {
		
		String cid = req.getParameter("contactId");

		int cnctId = 0;

		if (cid != null && ! " ".equals(cid)) {
			cnctId = Integer.parseInt(cid);
		}

		Contact contact = contactService.getContactById(cnctId);

		model.addAttribute(AppConstraints.CONTACT, contact);

		return AppConstraints.CONTACTINFO;
	}

	/**
	 * This Method is to delete contact
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletContact", method = RequestMethod.GET)
	public String deleteContact(HttpServletRequest req, Model model) {

		String cid = req.getParameter("contactId");

		if (cid != null && ! " ".equals(cid)) {
			int cnctId = Integer.parseInt(cid);
			contactService.deletContact(cnctId);
		}
		return AppConstraints.REDIRECTVIEWCONTACT;
	}

}
