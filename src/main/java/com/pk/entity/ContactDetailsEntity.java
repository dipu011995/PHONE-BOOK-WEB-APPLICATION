package com.pk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
 
/**
 * This is ContactDetailsEntity entity class
 * @author Pankaj Kumar
 *
 */
@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID", length = 10)
	@Type(type = "int")
	private Integer contactId;

	@Column(name = "CONTACT_NAME", length = 20)
	@Type(type = "string")
	private String contactName;

	@Column(name = "CONTACT_EMAIL", length = 30)
	@Type(type = "string")
	private String contactEmail;

	@Column(name = "CONTACT_NUMBER", length = 20)
	@Type(type = "long")
	private Long phNo;

	@Column(name = "ACTIVE_SWITCH", length = 1)
	@Type(type = "string")
	private String activeSwitch;

}
