package com.cian.Wallet.Exceptions;

public class TicketNotFoundException extends RuntimeException {
	public TicketNotFoundException(Long id) {
		super("Could not find ticket with id # " + id);
	}
}
