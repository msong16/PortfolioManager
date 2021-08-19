package com.citi.training.Portfolio.Manager.rest;


import com.citi.training.Portfolio.Manager.entities.Transaction;
import com.citi.training.Portfolio.Manager.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Transaction> findAll(){
        return transactionService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Transaction getTransactionById(@PathVariable("id") int id){
        return transactionService.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/account/{account_id}")
    public List<Transaction> getTransactionsByAccount_id(@PathVariable("account_id") int account_id){
        return transactionService.getTransactionsByAccount_id(account_id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/date/{date}")
    public List<Transaction> getTransactionByDate(@PathVariable("date")String date){
        return transactionService.getTransactionsByDate(date);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTransaction(Transaction transaction){
        transactionService.addTransaction(transaction);
    }
}
