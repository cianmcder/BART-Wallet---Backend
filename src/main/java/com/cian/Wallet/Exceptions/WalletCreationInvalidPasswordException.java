package com.cian.Wallet.Exceptions;

public class WalletCreationInvalidPasswordException extends RuntimeException {
	public WalletCreationInvalidPasswordException(String password) {
		super(String.format("Request to create a Wallet using invalid password=%s was made.", password));
	}
}
