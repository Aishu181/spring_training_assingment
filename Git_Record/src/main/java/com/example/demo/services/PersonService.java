package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;



public class PersonService {

	@Autowired
    private PersonRepository repo;

    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }
}
