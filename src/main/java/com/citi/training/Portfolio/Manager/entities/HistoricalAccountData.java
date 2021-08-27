package com.citi.training.Portfolio.Manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="historicalaccountdata")
public class HistoricalAccountData implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="account_id")
    private int accountId;
    @Column(name="date")
    private Date date;
    @Column(name="cash")
    private Double cash;
    @Column(name="investment")
    private Double investment;
    @Column(name="networth")
    private Double networth;

    public HistoricalAccountData() {}

    public HistoricalAccountData(int id, int account_id, Date date, Double cash,Double investment, Double networth) {
        this.id = id;
        this.accountId = account_id;
        this.date = date;
        this.cash = cash;
        this.investment = investment;
        this.networth = networth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int account_id) {
        this.accountId = account_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getNetworth() {
        return networth;
    }

    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }
}
