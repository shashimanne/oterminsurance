package com.example.terminsurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionController {
	
			@ExceptionHandler(value = UserNameNotFoundException.class)
			
			  public ResponseEntity<Object> exception(UserNameNotFoundException exception) {
		
			   return new ResponseEntity<>(" No User Found", HttpStatus.NOT_FOUND);
		
			  }
			@ExceptionHandler(value = UserIdNotFoundException.class)
			
			public ResponseEntity<Object> exception(UserIdNotFoundException exception) {
			
			 return new ResponseEntity<>(" No User Found", HttpStatus.NOT_FOUND);
			
			}
			
			@ExceptionHandler(value = ListIsEmptyException.class)
			
			public ResponseEntity<Object> exception(ListIsEmptyException exception) {
			
			 return new ResponseEntity<>(" List is Empty ", HttpStatus.NOT_FOUND);
			
			}

		}

