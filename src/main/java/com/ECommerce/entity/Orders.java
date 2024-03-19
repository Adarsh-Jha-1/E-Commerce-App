package com.ECommerce.entity;

import java.util.List;

public class Orders {

	
	private int id;
	private String name;
	private String address;
	private long mobileNumber;
	private double totalPrice;
	
	private List<Item> items;
}
