package com.cian.Wallet.Exceptions;

public class NoFarePassageException extends RuntimeException {
	public NoFarePassageException(String orig, String dest) {
		super(String.format("No available fare options given for route origin=%s, destination=%s",
			orig, dest));
	}
}
