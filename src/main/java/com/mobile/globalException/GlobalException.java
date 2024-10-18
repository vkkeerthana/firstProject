package com.mobile.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mobile.Exceptions.CustomExp;
import com.mobile.Exceptions.InvalidNumberException;
import com.mobile.priceRangeException.PriceRangeException;

import ch.qos.logback.core.status.Status;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(CustomExp.class)
	public ResponseEntity<String> handleBrand(CustomExp be){// return time can be string or object
		return new ResponseEntity<>(be.getMessage(),HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(PriceRangeException.class)
	public ResponseEntity<String> price(PriceRangeException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> s(NullPointerException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidNumberException.class)
	public ResponseEntity<String> num(InvalidNumberException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
