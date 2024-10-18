package com.mobile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.Mobile;
import com.mobile.DAO.MobileDAO;
import com.mobile.Exceptions.CustomExp;
import com.mobile.Exceptions.InvalidNumberException;
import com.mobile.priceRangeException.PriceRangeException;
@Service
public class MobileService {
	@Autowired
	MobileDAO md;
	public String postOne(Mobile m) {
		return md.postOne(m);
	}
	
	public Mobile finding(int i) {
		
		return md.finding(i);
	}
	public String getBrands(int a) throws CustomExp{

		Mobile m=md.finding(a);
		
		if(m.getBrand().isEmpty())
			//try {
			throw new CustomExp("Brand is empty");
			//}
		//catch(CustomExp e) {
			//return "Please insert id "+a+" brand";
		//}
		
		else 
		return m.getBrand();		
		
	}

	public String postvivo(Mobile m) throws CustomExp {
		if(m.getBrand().equals("vivo")){
			return md.postvivo(m);
		}
		else {
			throw new CustomExp("it is not Vivo");
		}
	}

	public List<Mobile> objPost(String brand) throws CustomExp{
		  List<Mobile> m= md.objPost(brand);
		List<Mobile> res=m.stream().filter(x->x.getBrand().equals(brand)).collect(Collectors.toList());
		if(res.isEmpty()) {
			throw new CustomExp("no element of"+brand+"is present");
		}else {
				return res;
		}
	}

	public String pricing(Mobile m) throws PriceRangeException {
		if(m.getPrice()>40000) {
			return md.pricing(m);
		} else {
			throw new PriceRangeException("price is below 40000") ;
	}
	}

	public String brands(int i) throws NullPointerException{
		String str= md.brands(i);
		if(str.isEmpty()) {
			throw new NullPointerException("no element is present");
		}
		else 
			return str;
	}

	public String mnumber(Mobile m) throws InvalidNumberException{
		if(String.valueOf(m.getMnumber()).length()==10){
		return md.mnumber(m);
		}
		else
			throw new InvalidNumberException("number is invalid");
	}

//	public List<Mobile> maxprice() {
//		return md.maxprice();
//	}

}
