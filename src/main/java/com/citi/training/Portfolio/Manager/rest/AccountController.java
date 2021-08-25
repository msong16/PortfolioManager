package com.citi.training.Portfolio.Manager.rest;

import com.citi.training.Portfolio.Manager.entities.Account;
import com.citi.training.Portfolio.Manager.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Account> getAccounts(){

        return accountService.getAllAccounts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getAccountById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "byName/{name}")
    public Account getAccountByFullName(@PathVariable("name") String name) {
        return accountService.getAccountByFullName(name);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void createAccount(@RequestBody Account account) {

        accountService.addNewAccount(account);
        //maybe a log for successful account creation? or if there were issues
        //send a different api response method
    }
/*
    @RequestMapping(method = RequestMethod.DELETE, value = "removeAccount/{id}")
    public void deleteAccount(@PathVariable("id") int id) {

        accountService.deleteAccountById(id);
        //maybe a log for successful account deletion? or if there were issues
        //send a different api response method

    }*/

}
