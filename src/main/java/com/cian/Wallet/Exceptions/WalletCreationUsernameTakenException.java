package com.cian.Wallet.Exceptions;

public class WalletCreationUsernameTakenException extends RuntimeException {
	public WalletCreationUsernameTakenException(String username) {
		super(String.format("Request to create a Wallet with username=%s was made, but the username is taken.",
			username));
	}
}