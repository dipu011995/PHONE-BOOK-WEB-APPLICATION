package com.pk.domain;

import lombok.Data;
/**
 * This is Contact Model class
 * @author Pankaj Kumar
 *
 */
@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phNo;
}
