package com.example.demo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Person;



public class PersonRepositoryTest {

	@Autowired
    private PersonRepository personRepo;

    @Test
    void isPersonExitsById() {
        Person person = new Person(1234, "Aishwarya", "Bhopal");
        personRepo.save(person);
        Boolean actualResult = personRepo.isPersonExitsById(1234);
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Deleting");
        personRepo.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("setting up");
    }
}
