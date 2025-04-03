package com.cian.Wallet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Wallet {
	@Id @GeneratedValue
	private long walletId;
	private String username;
	//future: setup encrypt/decrypt for passwords
	private String password;
	private double balance;
	
	public Wallet(String username, String password) {
		this.username = username;
		this.password = password;
		this.balance = 0;
	}

	public Wallet(String username, String password, double balance) {
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	//adding money to wallet or purchasing ticket
	public void addBalance(double add) {
		this.balance += add;
	}
	public void payTicket(double cost) {
		this.balance -= cost;
	}
}