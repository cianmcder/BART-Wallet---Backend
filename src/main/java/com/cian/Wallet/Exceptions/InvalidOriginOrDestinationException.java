package com.cian.Wallet.Exceptions;

public class InvalidOriginOrDestinationException extends RuntimeException
{
	public InvalidOriginOrDestinationException(String orig, String dest)
	{
		super("Either entered origin or destination registered invalid: " + 
				orig + ", " + dest);
	}
}
