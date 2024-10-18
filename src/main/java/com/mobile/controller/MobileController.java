package com.mobile.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidNullException;
import com.mobile.Mobile;
import com.mobile.Exceptions.CustomExp;
import com.mobile.Exceptions.InvalidNumberException;
import com.mobile.priceRangeException.PriceRangeException;
import com.mobile.service.MobileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/mobile")
public class MobileController {
	@Autowired
	MobileService ms;
	
	@PostMapping(value="/path")
	public String postOne(@RequestBody Mobile m) {
		return ms.postOne(m);
	}
	
	@GetMapping(value="/findAll/{i}")
	public Mobile finding(@PathVariable int i){
		return ms.finding(i);
	}
	@GetMapping(value="/getBrands/{a}")
	public String getBrands(@PathVariable int a) throws CustomExp{
		return ms.getBrands(a);
	}
	@PostMapping(value="/postvivo")
	public String postvivo(@RequestBody Mobile m) throws CustomExp {
		return ms.postvivo(m);
	}
	@GetMapping(value="/getListObj/{brand}")
	public List<Mobile> objPost(@PathVariable String brand) throws CustomExp {
		return ms.objPost(brand);
	}
	@PostMapping(value="/pricerange")
	public String pricing(@RequestBody Mobile m) throws PriceRangeException {		
		return ms.pricing(m);
	}
	//Query
	@GetMapping(value="/brand/{i}")
	public String brands(@PathVariable int i) {
		System.out.println("Hello from spring");
		return ms.brands(i);
	}
//	//JQuery
//	@GetMapping(value="/maxpice")
//	public List<Mobile> maxprice() {
//		return ms.maxprice();
//	}
	
	@PostMapping(value="/mnumber")
	public String mnumber(@RequestBody Mobile m) throws InvalidNumberException {
		return ms.mnumber(m);
	}
}
