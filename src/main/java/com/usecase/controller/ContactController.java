package com.usecase.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.entity.Person;
import com.usecase.exceptions.ContactNotFoundException;
import com.usecase.exceptions.MobileNumberExistsException;
import com.usecase.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService service;
	
	@PostMapping("/save")
	
	public  ResponseEntity<Person>  saveinfo(@RequestBody Person contact)
	{
		try
		{
			return new ResponseEntity<Person>(service.saveinfo(contact), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			throw new MobileNumberExistsException("Mobile number already exists");
		}
		
	}
	@GetMapping("/retrieve/{id}")
	public ResponseEntity <Optional<Person>> getById(@PathVariable("id") Long id )
	{
		Optional<Person> personResponse = service.findById(id);
		//System.out.println(personResponse);
		if(personResponse.isEmpty())
			throw new ContactNotFoundException("Requested Customer is not found in the database");
			
		else {
			return new ResponseEntity<Optional<Person>>(personResponse,HttpStatus.OK);
		}
			
		
	}
	
}
