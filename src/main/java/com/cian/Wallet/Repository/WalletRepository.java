package com.cian.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cian.Wallet.Entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>
{

}