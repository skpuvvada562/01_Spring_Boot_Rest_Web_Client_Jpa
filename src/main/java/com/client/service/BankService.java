package com.client.service;

import org.springframework.stereotype.Service;

import com.client.entity.Bank;

@Service
public interface BankService {

	public Bank saveBank(Bank bank);
}
