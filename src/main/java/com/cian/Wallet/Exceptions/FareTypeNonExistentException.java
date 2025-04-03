package com.cian.Wallet.Exceptions;

public class FareTypeNonExistentException extends RuntimeException {
	public FareTypeNonExistentException(long id, String orig, String dest, String name) {
		super(String.format("Wallet id=%s could not purchase ticket for origin=%s, destination=%s registered invalid."
			+ " Could not find fare type: %s",
			id, orig, dest, name));
	}
}
