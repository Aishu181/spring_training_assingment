package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@Column(name="personId")
	private int personId;
	
	@Column(name="personName")
	private String personName;
	
	@Column(name="personCity")
	private String personCity;
	
	public Person(Integer personId, String personName, String personCity) {

        this.personId = personId;
        this.personName = personName;
        this.personCity = personCity;
    }

    public Person() {
    }
	
   
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}

	
}
