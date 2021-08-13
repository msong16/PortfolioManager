package com.citi.training.Portfolio.Manager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="cash")
    private Double cash;
    @Column(name="networth")
    private Double netWorth;

    public Account(){}

    public Account(int id, String name, Double cash, Double netWorth) {
        this.id = id;
        this.name = name;
        this.cash = cash;
        this.netWorth = netWorth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Double netWorth) {
        this.netWorth = netWorth;
    }

}
