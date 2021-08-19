package com.citi.training.Portfolio.Manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="account_id")
    private int accountId;
    @Column(name="date")
    private String date;
    @Column(name="b_or_s")
    private Character b_or_s;
    @Column(name="stock_name")
    private String stock_name;
    @Column(name="shares")
    private Integer shares;
    @Column(name="price_per_share")
    private Double price_per_share;

    public Transaction() {
    }

    public Transaction(int id, int account_id, String date, Character b_or_s, String stock_name, Integer shares, Double price_per_share) {
        this.id = id;
        this.accountId = account_id;
        this.date = date;
        this.b_or_s = b_or_s;
        this.stock_name = stock_name;
        this.shares = shares;
        this.price_per_share = price_per_share;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Character getB_or_s() {
        return b_or_s;
    }

    public void setB_or_s(Character b_or_s) {
        this.b_or_s = b_or_s;
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

    public Double getPrice_per_share() {
        return price_per_share;
    }

    public void setPrice_per_share(Double price_per_share) {
        this.price_per_share = price_per_share;
    }
}
