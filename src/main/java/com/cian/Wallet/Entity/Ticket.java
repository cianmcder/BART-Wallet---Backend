package com.cian.Wallet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
@Getter
public class Ticket {
	@Id @GeneratedValue
	private long ticketId;
	private String origin;
	private String destination;
	private long walletId;
	
	public Ticket() {}
		
	public Ticket(String orig, String dest, long walletId) {
		this.origin = orig;
		this.destination = dest;
		this.walletId = walletId;
	}
	
	//in case comparison needed
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Ticket))
			return false;
		Ticket t = (Ticket) o;
		return Objects.equals(this.origin, t.origin) && Objects.equals(this.destination, t.destination)
			&& Objects.equals(this.walletId, t.walletId);
	}
}
