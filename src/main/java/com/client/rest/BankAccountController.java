package com.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.Account;
import com.client.entity.Bank;
import com.client.service.AccountService;
import com.client.service.BankService;

@RestController
public class BankAccountController {

	@Autowired
	private BankService bankService;
	
	@Autowired 
	private AccountService accountService;
	
	/*
	@PostMapping(value="/saveBank", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bank> saveBankAccount(@RequestBody Bank bank){
		Bank b =bankService.saveBank(bank);
		
		return new ResponseEntity<Bank>(b,HttpStatus.CREATED);
	}
	*/
	@PostMapping(value="/saveAccount", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> saveAccount(@RequestBody Account account){
		Account b =accountService.saveAccount(account);
		
		return new ResponseEntity<Account>(b,HttpStatus.CREATED);
	}
}
