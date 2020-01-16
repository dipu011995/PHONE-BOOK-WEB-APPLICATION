package com.pk.service;

import java.util.List;

import com.pk.domain.Contact;

public interface ContactService {

	public boolean saveContact(Contact c);

	public List<Contact> getAllContact();

	public Contact getContactById(Integer cid);

	public void deletContact(Integer cid);
	
	public void forwardMail(String to);

}
