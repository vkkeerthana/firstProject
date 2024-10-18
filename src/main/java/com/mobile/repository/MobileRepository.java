package com.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mobile.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {
	@Query(value="select brand from mobile_table where id=?",nativeQuery=true)
	String brands(int i);
	

	
//	@Query(value ="select m from Mobile m where price=(select max(price) from Mobile m)")
//	List<Mobile> maxprice();
	

}
