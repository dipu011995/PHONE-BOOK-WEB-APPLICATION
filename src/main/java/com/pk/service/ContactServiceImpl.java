package com.pk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.domain.Contact;
import com.pk.entity.ContactDetailsEntity;
import com.pk.mail.MailUtils;
import com.pk.rerositeries.ContactDetailsRepositeries;

/**
 * This Service class inject our Repositeries(I) i.e
 * ContactDetailsRepositeries(I) to perform crud operation
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDetailsRepositeries contactRepositeries;
	
	@Autowired
	private MailUtils mailutils;
	

	/**
	 * This saveContact method is for Save the Contact in DB table if Id is null
	 * then it save the data(record), if Id is there then it update the data(record)
	 * in save(entity) method save the data and return entity object
	 */
	@Override
	public boolean saveContact(Contact c) {

		ContactDetailsEntity entity = new ContactDetailsEntity();

		BeanUtils.copyProperties(c, entity);
		entity.setActiveSwitch("y");

		ContactDetailsEntity savedEntity = contactRepositeries.save(entity);
		
		boolean isSaved = savedEntity.getContactId() > 0 ;
		
		if(isSaved) {
			forwardMail(savedEntity.getContactEmail());			
		}
		
		return isSaved;
	}

	/**
	 * This method is to get All contact from Database
	 */
	@Override
	public List<Contact> getAllContact() {

		List<Contact> contactList = new ArrayList<>();

		List<ContactDetailsEntity> entityList = contactRepositeries.findAll();

		List<ContactDetailsEntity> filterEntity = entityList.stream()
				.filter(entity -> "y".equals(entity.getActiveSwitch())).collect(Collectors.toList());

		if (!filterEntity.isEmpty()) {
			filterEntity.forEach(entity -> {
				Contact c = new Contact();
				BeanUtils.copyProperties(entity, c);
				contactList.add(c);
			});
		}
		return contactList;
	}

	/**
	 * This Method to get Contact Details by Id
	 */
	@Override
	public Contact getContactById(Integer cid) {

		Contact c = null;

		Optional<ContactDetailsEntity> optional = contactRepositeries.findById(cid);
		if (optional.isPresent()) {
			ContactDetailsEntity entity = optional.get();
			c = new Contact();
			BeanUtils.copyProperties(entity, c);
		}
		return c;
	}

	/**
	 * This Method is to delete Contact in DB by contact Id
	 */
	@Override
	public void deletContact(Integer cid) {
		contactRepositeries.update("N", cid);
	}
	
	/**
	 * this method is to forward mail to mail Class
	 */
	public void forwardMail(String to) {
		mailutils.sendMail(to, "active", "Hello Mr. Aaftab");
	}

}
