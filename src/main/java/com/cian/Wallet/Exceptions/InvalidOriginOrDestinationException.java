package com.cian.Wallet.Exceptions;

import java.util.Map;

public class InvalidOriginOrDestinationException extends RuntimeException {
	//remove this constructor and replace with the one below once a valid station HashMap is properly implemented
	public InvalidOriginOrDestinationException(String orig, String dest) {
			super("Either entered origin or destination registered invalid: " + 
					orig + ", " + dest);
	}
	
	public InvalidOriginOrDestinationException(String orig, String dest, Map<String, String> stations) {
		super(String.format("Either entered origin=%s or destination=%s registered invalid. Valid station codes: %s",
			orig, dest, stations.values()));
	}
}
