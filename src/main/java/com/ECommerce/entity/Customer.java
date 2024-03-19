package com.ECommerce.entity;

import java.util.List;

public class Customer {

	private int id;
	private String name;
	private String address;
	
	private long mobileNumber;
	
	private String email;
	private String password;
	    
	
	private Cart cart;
	
	private List<Orders> orders;
}
