package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LibModel;
import com.example.demo.repository.LibRepo;

@Service
public class LibraryService {
	
	@Autowired
	LibRepo response;
	

	//generating id
	public String buildId(String isbn,int aisle)
	{
		if(isbn.startsWith("Z")) //testing
    	{
			return "OLD"+isbn+aisle;
		}
		
		return isbn+aisle;
	}

	public boolean checkBookAlreadyExist(String id)
	{
		Optional<LibModel> lb =response.findById(id);
		if(lb.isPresent())
		return true;
		else
			return false;
	}
	
	public LibModel getBookById(String id)
	{
		return response.findById(id).get();
	}
}
