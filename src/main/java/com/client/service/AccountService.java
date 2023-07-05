package com.client.service;

import org.springframework.stereotype.Service;

import com.client.entity.Account;

@Service
public interface AccountService {

	public Account saveAccount(Account account);
}
