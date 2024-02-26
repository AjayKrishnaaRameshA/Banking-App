package com.ajay.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.banking.dto.AccountDto;
import com.ajay.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	//add account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto dto){
		return new ResponseEntity<AccountDto>(
				accountService.createAccount(dto), HttpStatus.CREATED);
	}
	
	// get account rest api	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		
		AccountDto dto=accountService.getAccountById(id);
		
		return ResponseEntity.ok(dto);
		
	}
	
	//deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, 
												@RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDto dto = accountService.deposit(id, amount);
		return ResponseEntity.ok(dto);
	}
	
	//withdraw REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, 
												@RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDto dto = accountService.withdraw(id, amount);
		return ResponseEntity.ok(dto);
	}
	
	//delete REST API
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
		
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok("account deleted successfully");
		
	}
	
	// REST API for fetching all records	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDto>> showAllAccounts(){
		
		List<AccountDto> dtos=accountService.showAllAccounts();
		
		return ResponseEntity.ok(dtos);
	}
	
	
	
}
