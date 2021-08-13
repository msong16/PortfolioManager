package com.citi.training.Portfolio.Manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="currentStocks")
public class CurrentStocks implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="account_id")
    private int account_id;
    @Column(name="stock_name")
    private String stock_name;
    @Column(name="shares")
    private Integer shares;

    public CurrentStocks() {
    }

    public CurrentStocks(int id, int account_id, String stock_name, Integer shares) {
        this.id = id;
        this.account_id = account_id;
        this.stock_name = stock_name;
        this.shares = shares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }
}
