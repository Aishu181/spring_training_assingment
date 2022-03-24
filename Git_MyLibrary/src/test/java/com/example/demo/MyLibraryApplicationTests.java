package com.example.demo;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Library;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.example.demo.controller.LibController;
import com.example.demo.model.LibModel;
import com.example.demo.repository.LibRepo;
import com.example.demo.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class MyLibraryApplicationTests {


	@Autowired
	LibController con;
	
	@MockBean
	LibRepo repository;
	
	@MockBean
	LibraryService libraryService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void contextLoads() {
		
	}
	
	//Testing  logic for generating id
	//id=isbn+aisle
	@Test
	public void checkBuildIDLogic()
	{

		LibraryService lib = new LibraryService();
		String id=lib.buildId("ZMAN", 24);
		assertEquals(id,"OLDZMAN24");
		
	}
	
	//Test for adding books
	@Test
	public void addBookTest(){
		//mock
		LibModel  lib =buildLibrary();
		when(libraryService.buildId(lib.getIsbn(),lib.getAisle())).thenReturn(lib.getId());
		when(libraryService.checkBookAlreadyExist(lib.getId())).thenReturn(false);
		ResponseEntity response=con.addBookImplementation(buildLibrary());
		System.out.println(response.getStatusCode());
		assertEquals(response.getStatusCode(),HttpStatus.CREATED);
	}
	
	//Test for adding book using mockMvc
	@Test
	public void addBookControllerTest() throws Exception
	{
		LibModel lib = buildLibrary();
		ObjectMapper map = new ObjectMapper();
		String jsonString = map.writeValueAsString(lib); //converting java obj to string
		
		when(libraryService.buildId(lib.getIsbn(),lib.getAisle())).thenReturn(lib.getId());
		when(libraryService.checkBookAlreadyExist(lib.getId())).thenReturn(false);
		when(repository.save(any())).thenReturn(lib);
		
		//obj                             //obj type which we're sending
	this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON)
		.content(jsonString)).andDo(print()).andExpect(status().isCreated())//http status
	    //passing converted java obj to string
	     .andExpect(jsonPath("$.id").value(lib.getId()));


	}
	
	//Testing getBook method
	@Test
	public void getBookByAuthorTest() throws Exception
	{
		List<LibModel> li=new ArrayList<LibModel>();
		li.add(buildLibrary());
		li.add(buildLibrary());
		when(repository.findByAuthor(any())).thenReturn(li);
		this.mockMvc.perform(get("/getBooks/author").param("authorname","J.K. Rowling"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.length()",is(2))).
		andExpect(jsonPath("$.[0].id").value("sfe3b"));;
	}
	
	//Testing update book method
	@Test
	public void updateBookTest() throws Exception
	{
		LibModel lib =buildLibrary();
		ObjectMapper map =new ObjectMapper();
		String jsonString = map.writeValueAsString(UpdateLibrary());
		when(libraryService.getBookById(any())).thenReturn(buildLibrary());
	this.mockMvc.perform(put("/updateBook/"+lib.getId()).contentType(MediaType.APPLICATION_JSON)
	.content(jsonString)).andDo(print()).andExpect(status().isOk())
	.andExpect(content().json("{\"book_name\":\"Boot\",\"id\":\"sfe322\",\"isbn\":\"sfe\",\"aisle\":322,\"author\":\"Shetty\"}"));
	
	}
	
	//Testing delete book method
	@Test
	public void deleteBookControllerTest() throws Exception
	{
		when(libraryService.getBookById(any())).thenReturn(buildLibrary());	
		doNothing().when(repository).delete(buildLibrary());
		this.mockMvc.perform(delete("/deleteBook").contentType(MediaType.APPLICATION_JSON)
		.content("{\"id\" : \"sfe3b\"}")).andDo(print())
		.andExpect(status().isCreated()).andExpect(content().string("Book is deleted"));
		
		
	}
	
	
    //Method for mock data
	private LibModel buildLibrary() {
		LibModel lib =new LibModel();
		lib.setAisle(322);
		lib.setBook_name("Harry Potter");
		lib.setIsbn("sfe");
		lib.setAuthor("J.K. Rowling");
		lib.setId("sfe322");
		return lib;
	}
	
	//Method for updated mock date
	public LibModel UpdateLibrary()
	{
		LibModel lib =new LibModel();
		lib.setAisle(322);
		lib.setBook_name("Boot");
		lib.setIsbn("rain");
		lib.setAuthor("Shetty");
		lib.setId("rain322");
		return lib;
		
	}
	
	

}
