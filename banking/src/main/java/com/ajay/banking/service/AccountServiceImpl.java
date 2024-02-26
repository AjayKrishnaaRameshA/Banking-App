package com.ajay.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.banking.dto.AccountDto;
import com.ajay.banking.entity.Account;
import com.ajay.banking.mapper.AccountMapper;
import com.ajay.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository repository;
	
	@Override
	public AccountDto createAccount(AccountDto dto) {

		Account acc=AccountMapper.mapToAccount(dto);
		Account savedacc=repository.save(acc);
		
		return AccountMapper.mapToAccountDto(savedacc);
	}

	@Override
	public AccountDto getAccountById(Long id) {

		Account acc=repository.
				findById(id).
				orElseThrow(()-> new RuntimeException("account not found"));
		return AccountMapper.mapToAccountDto(acc);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
			
		Account acc=repository.
				findById(id).
				orElseThrow(()-> new RuntimeException("account not found"));
		
		double total = acc.getBalance()+amount;
		acc.setBalance(total);
		Account savedAcc=repository.save(acc);
		
		return AccountMapper.mapToAccountDto(savedAcc);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {

		Account acc=repository.
						findById(id).
						orElseThrow(()-> new RuntimeException("account not found"));
		
		if(acc.getBalance() < amount) {
			throw new RuntimeException("balance is too low");
		}else {
			double total = acc.getBalance()-amount;
			acc.setBalance(total);
		}
		Account savedAcc=repository.save(acc);
		AccountDto dto=AccountMapper.mapToAccountDto(savedAcc);
		return dto;
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account acc=repository.
					findById(id).
					orElseThrow(()->  new RuntimeException("account not found"));
		repository.deleteById(id);
		
	}

	@Override
	public List<AccountDto> showAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = repository.findAll();
		return accounts.stream()
				.map((account-> AccountMapper.mapToAccountDto(account)))
				.collect(Collectors.toList());
		
	}

	
}
