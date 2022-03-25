package com.example.demo.controllers;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.services.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler({ResourceNotFoundException.class})
	 public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){

	        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

	    }
}
