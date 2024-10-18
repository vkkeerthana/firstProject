package com.mobile.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.Mobile;
import com.mobile.repository.MobileRepository;
@Repository
public class MobileDAO {
	@Autowired
	MobileRepository mr;
	
	public String postOne(Mobile m) {
	 mr.save(m);
	 return "Posted";
	}
	public Mobile finding(int i) {
		return mr.findById(i).get();
	}
	public String postvivo(Mobile m) {
		mr.save(m);
		return "Posted vivo object";
	}
	public List<Mobile> objPost(String brand) {
		return mr.findAll();
	}
	public String pricing(Mobile m) {
		 mr.save(m);
		 return "Posted";
	}
	public String brands(int i) {
		return mr.brands(i);
	}
//	public List<Mobile> maxprice() {
//		return mr.maxprice();
//	}
	public String mnumber(Mobile m) {
		mr.save(m);
		return "Saved";
	}


	
}
