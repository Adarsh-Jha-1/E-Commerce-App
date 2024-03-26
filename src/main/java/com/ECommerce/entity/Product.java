package com.ECommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int id;
	@NonNull 
	private String brand;
	@NonNull 
	private String category;
	@NonNull 
	private String model;
	@NonNull 
	private Double price;
	@NonNull 
	private Integer stock;
	

}
