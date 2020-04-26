package com.rayhan.repository;

import com.rayhan.dto.OrderResponse;
import com.rayhan.entity.Customer;
import com.rayhan.entity.Product;
import com.rayhan.entity.Product1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT new com.rayhan.dto.OrderResponse(c.name , p.productName,p.qty, c.id ) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
	

	
	//@Query("select cp.person from CompanyEmployee cp where cp.company.id = ?")

	//@Query("SELECT new com.javatechie.jpa.entity.Product1(p.productName,p.qty) FROM products p JOIN Customer c WHERE c.id = p.cp_fk ")
	//public List<Product1> getJoinInformatio();
	// @Query("SELECT new com.javatechie.jpa.entity.Product1(p.productName) FROM
	// Customer c JOIN c.products p")
	//where c.id = p.cp_fk
	//@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName,p.qty, p.cp_fk ) FROM Customer c JOIN c.products p")
}
