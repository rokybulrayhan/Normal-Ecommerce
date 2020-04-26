package com.rayhan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.rayhan.dto.OrderResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "xxx_customers")
public class Customer {
    @Id
    @GeneratedValue
    private Integer id ;
    private String name;
    private String email;
    private String gender;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    private List<Product> products;
   // private OrderResponse op;

}
