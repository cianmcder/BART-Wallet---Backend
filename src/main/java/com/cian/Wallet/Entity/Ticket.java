package com.cian.Wallet.Entity;

import java.util.Objects;

import org.springframework.data.annotation.Immutable;

@Immutable
public class Ticket
{
	private String origin;
	private String destination;
	
	public Ticket() {}
		
	public Ticket(String orig, String dest)
	{
		this.origin = orig;
		this.destination = dest;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	public String getDestination()
	{
		return destination;
	}

	public void setOrigin(String orig)
	{
		this.origin = orig;
	}
	public void setDestination(String dest)
	{
		this.destination = dest;
	}
	
	//in case comparison needed
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Ticket))
			return false;
		Ticket t = (Ticket) o;
		return Objects.equals(this.origin, t.origin) && Objects.equals(this.destination, t.destination);
	}
}
