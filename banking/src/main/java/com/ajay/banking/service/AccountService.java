package com.ajay.banking.service;

import java.util.List;

import com.ajay.banking.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto dto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	void deleteAccount(Long id);
	
	List<AccountDto> showAllAccounts();
}
