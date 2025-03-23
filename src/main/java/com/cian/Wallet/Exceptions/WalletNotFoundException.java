package com.cian.Wallet.Exceptions;

public class WalletNotFoundException extends RuntimeException
{
	public WalletNotFoundException(Long id)
	{
		super("Could not find wallet with id # " + id);
	}
}