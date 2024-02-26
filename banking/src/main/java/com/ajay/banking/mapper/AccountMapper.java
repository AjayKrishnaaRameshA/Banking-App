package com.ajay.banking.mapper;

import com.ajay.banking.dto.AccountDto;
import com.ajay.banking.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto dto) {
		
		Account account = new Account(
				dto.getId(),
				dto.getName(),
				dto.getBalance()
		);
		
		return account;
	}

	public static AccountDto mapToAccountDto(Account acc) {
		
		AccountDto dto = new AccountDto(
				acc.getId(),
				acc.getName(),
				acc.getBalance()
		);
		
		return dto;
	}
}
