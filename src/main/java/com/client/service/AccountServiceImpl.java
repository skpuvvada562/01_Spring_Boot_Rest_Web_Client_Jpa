package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.client.entity.Account;
import com.client.repository.AccountRepository;

@Component
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

}
