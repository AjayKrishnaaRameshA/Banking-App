package com.ajay.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
