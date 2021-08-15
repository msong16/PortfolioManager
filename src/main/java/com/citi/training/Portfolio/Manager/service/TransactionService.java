package com.citi.training.Portfolio.Manager.service;

import com.citi.training.Portfolio.Manager.entities.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    Transaction getTransactionById(int id);
    List<Transaction> getTransactionsByAccount_id(int account_id);
    Iterable<Transaction> getAll();
    List<Transaction> getTransactionsByDate(String date);
    void addTransaction(Transaction transaction);
}
