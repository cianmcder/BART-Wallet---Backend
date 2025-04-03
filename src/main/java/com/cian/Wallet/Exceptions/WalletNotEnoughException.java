package com.cian.Wallet.Exceptions;

public class WalletNotEnoughException extends RuntimeException {
	public WalletNotEnoughException(long id, double fare, double balance) {
		super(String.format("Not enough money registered in walletId=%s, fare=%s, balance=%s",
			id, fare, balance));
	}
}
