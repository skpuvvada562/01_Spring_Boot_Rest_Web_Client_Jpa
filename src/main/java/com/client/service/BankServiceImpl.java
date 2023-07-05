package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.client.entity.Bank;
import com.client.repository.BankRepository;

@Component
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}

}
