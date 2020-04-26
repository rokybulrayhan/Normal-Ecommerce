package com.rayhan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rayhan.dto.OrderResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Product1 {
    //@Id
    //private int pid;
	public Product1(String productName,Integer qty) {
		this.productName = productName;
		this.price = price;
		this.cp_fk = cp_fk;
		
	}
	private String productName;
    private Integer qty;
    private Integer price;
    private Integer cp_fk;
}

