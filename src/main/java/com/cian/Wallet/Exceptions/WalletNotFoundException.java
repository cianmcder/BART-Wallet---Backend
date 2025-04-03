package com.cian.Wallet.Exceptions;

public class WalletNotFoundException extends RuntimeException {
	public WalletNotFoundException(Long id) {
		super(String.format("Could not find walletId=%s", id));
	}
}