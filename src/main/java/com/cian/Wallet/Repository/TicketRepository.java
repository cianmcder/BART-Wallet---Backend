package com.cian.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cian.Wallet.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
