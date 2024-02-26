package com.ajay.banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	
	private Long id;
	private String name;
	private double balance;
	


}
