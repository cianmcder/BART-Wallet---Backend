package com.cian.Wallet.Entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Wallet
{
	@Id @GeneratedValue
	private long walletID;
	private double balance;
	
	public Wallet() {}
	
	public Wallet(double balance)
	{
		this.balance = balance;
	}
	
	public long getWalletId() {
		return walletID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addBalance(double add)
	{
		this.balance += add;
	}
	public void payTicket(double cost)
	{
		this.balance -= cost;
	}
	
	//in case comparison needed
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Wallet))
			return false;
		Wallet w = (Wallet) o;
		return Objects.equals(this.walletID, w.walletID) && Objects.equals(this.balance, w.balance);
	}
}