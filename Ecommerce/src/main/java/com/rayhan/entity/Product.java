package com.rayhan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name = "xxx_products")
public class Product {
    @Id
    private Integer pid;
	private String productName;
    private Integer qty;
    private Integer price;
    private Integer cp_fk;
	public Product(Integer pid, String productName, Integer price, Integer cp_fk) {
		this.pid = pid;
		this.productName = productName;
		this.price = price;
		this.cp_fk = cp_fk;
	}
    
}
