package com.rayhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rayhan.entity.Product;
import com.rayhan.entity.Product1;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	/*
	 * @Query("SELECT new com.javatechie.jpa.entity.Product1(p.productName,p.qty) FROM products p JOIN Customer c WHERE c.id = p.cp_fk "
	 * ) public List<Product1> getJoinInformatio();
	 */
	 @Query(value="SELECT  * FROM xxx_products WHERE xxx_products.cp_fk=:id",nativeQuery = true)    
	 List<Product>findIdProduct(@Param("id") int id);
	
}
