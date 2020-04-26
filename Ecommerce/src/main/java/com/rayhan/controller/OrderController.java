package com.rayhan.controller;

import com.rayhan.dto.OrderRequest;
import com.rayhan.dto.OrderResponse;
import com.rayhan.entity.Customer;
import com.rayhan.entity.Product;
import com.rayhan.repository.CustomerRepository;
import com.rayhan.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
    
	
	///post customer+product
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
  /// find customer + product
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}
	//select customer+product id wise
	@GetMapping("/findAllOrders/{id}")
	public Optional<Customer> findAllOrder(@PathVariable(value = "id") int id) {
		return customerRepository.findById(id);
	}
	
    //select order product + customer wise with query
	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation() {
		return customerRepository.getJoinInformation();
	}

	@DeleteMapping("/customer/{id}")
	public void delete(@PathVariable(value = "id") int id) {
		customerRepository.deleteById(id);
	}

	@GetMapping("/products/{id}")
	public List<Product> findIdProduct(@PathVariable(value = "id") int id) {
		System.out.println(id);
		return productRepository.findIdProduct(id);
	}



	@PutMapping("/customerr/{id}")
	public void edit(@PathVariable(value = "id") int id, @Valid @RequestBody Customer customer) {
		customerRepository.save(customer);
	}

}
