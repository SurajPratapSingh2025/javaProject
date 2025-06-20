package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ContactForm;


@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer>{
	
	@Override
	public <S extends ContactForm> S save(S entity);

}
