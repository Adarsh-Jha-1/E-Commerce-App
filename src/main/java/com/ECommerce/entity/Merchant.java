package com.ECommerce.entity;

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
}
