package com.cian.Wallet.Exceptions;

public class WalletNotEnoughException extends RuntimeException
{
	public WalletNotEnoughException(long id, double fare, double balance)
	{
		super("Not enough money registered in given wallet:\n"
				+ "Wallet ID: " + id + "\nRequested fare: " + fare
				+ "\nCurrent balance: " + balance);
	}
}
