package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setLastname(String lastname2) {
		// TODO Auto-generated method stub
		
	}
	public void setFirstname(String firstname2) {
		// TODO Auto-generated method stub
		
	}
	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}
}
