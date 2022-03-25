package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setId(long id2) {
		// TODO Auto-generated method stub
		
	}
	
}