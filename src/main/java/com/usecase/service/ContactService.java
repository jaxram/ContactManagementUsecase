package com.usecase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.entity.Person;
import com.usecase.repo.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repo;
	
	public  Person saveinfo(Person contact)
	{
		
		return repo.save(contact);
	}
	public  Optional<Person> findById(Long id)
	{
		
		return repo.findById(id);
	}

}
