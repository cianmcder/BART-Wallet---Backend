package com.cian.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cian.Wallet.Entity.Wallet;
import com.cian.Wallet.Repository.WalletRepository;

@SpringBootApplication  
public class WalletApplication// implements CommandLineRunner
{
	@Autowired
	private WalletRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}
	
	//loads an in-memory database with some wallets to test
	/*@Override
	public void run(String... strings) throws Exception
	{
		//make Wallets
		Wallet a = new Wallet();
		Wallet b = new Wallet(28.25);
		//add to repo
		this.repo.save(a);
		this.repo.save(b);
		this.repo.save(new Wallet(55.00));
	}*/
}
