package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.LibModel;
import com.example.demo.repository.LibRepo;

@SpringBootApplication
public class MyLibraryApplication  {
	
	@Autowired
	LibRepo repository;

	public static void main(String[] args) {
		SpringApplication.run(MyLibraryApplication.class, args);
	}
  
	
	/*public void run(String[] args) {
		 LibModel lib=repository.findById("fdsefr343").get();
	    System.out.println(lib.getAuthor());
	    LibModel en =new LibModel();
	    en.setAisle(123);
	    en.setAuthor("Devdutt");
	    en.setBook_name("Mithya");
	    en.setIsbn("lkhs");
	    en.setId("lkhs123");
	    repository.save(en);
	    List<LibModel> allrecords = repository.findAll();
	    for(LibModel item : allrecords)
	    	
	    {
	    	System.out.println(item.getBook_name());
	    }
	    
	    
	 }
	 */
	
	
}
