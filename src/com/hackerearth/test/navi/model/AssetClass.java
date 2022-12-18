package com.hackerearth.test.navi.model;

import com.hackerearth.test.navi.exceptions.InsufficientBalanceException;

public class AssetClass {
    private AssetClassName name;
    private long balance;

    public AssetClass(AssetClassName name,long startingBalance){
        if(name == null || startingBalance<0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.balance = startingBalance;
    }

    public AssetClassName getName(){
        return this.name;
    }
    public long getBalance(){
        return this.balance;
    }

    public long deposit(long amount){
        this.balance += amount;
        return this.balance;
    }

    public long withdraw(long amount){
        if(this.balance < amount){
            throw new InsufficientBalanceException("Amount greater than balance can't be withdrawn");
        }
        this.balance -= amount;
        return this.balance;
    }
}
