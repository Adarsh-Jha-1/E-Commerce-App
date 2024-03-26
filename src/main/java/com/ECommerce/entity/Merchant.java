package com.ECommerce.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Merchant {
 
	private int id;
    @NonNull 
    private String name;
    @NonNull 
    private String email;
    @NonNull 
    private Long mobileNumber;
    @NonNull 
    private String password;
    
    
    private List<Product> products;
    
    public void setMerchantDetails(String name, String email, Long mobileNumber, String password, List<Product> products) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.products = products;
    }
    
    public void setMerchantDetails(String name, String email, Long mobileNumber, String password) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

	public Merchant() {
	}

	public Merchant(int id, String name, String email, Long mobileNumber, String password) {
		this.id = id;
		this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
	}


}
