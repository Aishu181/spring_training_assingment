package com.example.demo.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.demo.repository.PersonRepository;



public class PersonServiceTest {

	 @Mock
	    private PersonRepository personRepo;


	    private PersonService personService;

	    @BeforeEach
	    void setUp() {
	        this.personService = new PersonService(this.personRepo);
	    }

	    @Test
	    void getAllPerson() {
	        personService.getAllPerson();
	        verify(personRepo).findAll();
	    }
}