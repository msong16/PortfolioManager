package com.citi.training.Portfolio.Manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="currentstocks")
public class CurrentStocks implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="account_id")
    private int accountId;
    @Column(name="stock_name")
    private String stockName;
    @Column(name="shares")
    private Integer shares;

    public CurrentStocks() {
    }

    public CurrentStocks(int id, int account_id, String stock_name, Integer shares) {
        this.id = id;
        this.accountId = account_id;
        this.stockName = stock_name;
        this.shares = shares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return accountId;
    }

    public void setAccount_id(int account_id) {
        this.accountId = account_id;
    }

    public String getStock_name() {
        return stockName;
    }

    public void setStock_name(String stock_name) {
        this.stockName = stock_name;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }
}
