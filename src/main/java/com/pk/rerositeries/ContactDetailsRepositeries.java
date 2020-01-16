package com.pk.rerositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.entity.ContactDetailsEntity;

/**
 * ContactDetailsRepositeries (c) extending JpaRepositeries to perform crud
 * operation provide by Spring Data Jpa Repositeries having multiple pre-defind
 * methods to perform CRUD operation
 * 
 * Spring container will create a proxy class object at Runtime where pre-defind
 * methods are available to perform CRUD Operation
 * 
 * This proxy class wil be created by CGLib
 */
@Repository
public interface ContactDetailsRepositeries extends JpaRepository<ContactDetailsEntity, Integer> {

	@Transactional
	@Modifying
	@Query("update ContactDetailsEntity set activeSwitch = :sw where contactId = :cid")
	public void update(String sw, Integer cid);

}
