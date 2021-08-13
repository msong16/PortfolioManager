package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Account;

public interface AccountService {

    Account getAccountById(int id);

    Iterable<Account> getAllAccounts();
}
