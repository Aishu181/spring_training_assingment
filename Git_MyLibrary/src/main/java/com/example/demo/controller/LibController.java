package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.relational.Loggable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LibModel;
import com.example.demo.repository.LibRepo;
import com.example.demo.service.LibraryService;


@RestController
//@RequestMapping("lib")
public class LibController {

	@Autowired
	LibRepo repository;
	
	@Autowired //Bean class
	AddResponse response;
	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping("add")                       
	public ResponseEntity addBookImplementation(@RequestBody LibModel library) // Method to add new book in db 
	{
		String id= libraryService.buildId(library.getIsbn(),library.getAisle());
		
		if(!libraryService.checkBookAlreadyExist(id))
		{
			library.setId(id);
		repository.save(library);  
		HttpHeaders headers = new HttpHeaders();
		headers.add("unique",id);
		
		response.setMsg("Success Book is added");
		response.setId(id);
		
		return new ResponseEntity<AddResponse>(response,headers,HttpStatus.CREATED);
		}
		
		else
		{
			response.setMsg("Book already exist");
			response.setId(id);
			
			return new ResponseEntity<AddResponse>(response,HttpStatus.ACCEPTED);
		}
	}
		
		public LibModel getBookById(@PathVariable(value="id")String id) //Search for book using id
	      {
	    	  LibModel lib=repository.findById(id).get(); 
	    	  return lib; 
	      }
		
		@GetMapping("getBooks/{author}")
		public List<LibModel> getBookByAuthorName(@RequestParam(value="authorname")String authorname) //Search for book using author's name
	
		{
			
			return repository.findByAuthor(authorname);
			
		}
		
		//update book details using id
		@PutMapping("/updateBook/{id}")
		public ResponseEntity<LibModel> updateBook(@PathVariable(value="id")String id,@RequestBody LibModel library)
		{
		//	Library existingBook = repository.findById(id).get();//mock
			LibModel existingBook =libraryService.getBookById(id);
			
			existingBook.setAisle(library.getAisle());//mock
			existingBook.setAuthor(library.getAuthor());
			existingBook.setBook_name(library.getBook_name());
			repository.save(existingBook);//
			//
			return new ResponseEntity<LibModel>(existingBook,HttpStatus.OK);
		}
		
		//Delete book using id
		@DeleteMapping("/deleteBook")
		public ResponseEntity<String> deleteBookById(@RequestBody LibModel library)
		{
		//	Library libdelete =repository.findById(library.getId()).get();
			LibModel libdelete =libraryService.getBookById(library.getId());//mock
			repository.delete(libdelete);
			
			//logger.info("Book  is deleted ");
			return new ResponseEntity<>("Book is deleted",HttpStatus.CREATED);
			
			}
		
		//Get list of all books
		@GetMapping("/getBooks")
		public Iterable<LibModel> getBooks()
		{
			return repository.findAll();
		}
			
	
}
