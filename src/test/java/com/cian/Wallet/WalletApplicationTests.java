package com.cian.Wallet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cian.Wallet.Controller.WalletController;
import com.cian.Wallet.Entity.Wallet;
import com.cian.Wallet.Exceptions.InvalidOriginOrDestinationException;
import com.cian.Wallet.Exceptions.WalletNotEnoughException;
import com.cian.Wallet.Exceptions.WalletNotFoundException;
import com.cian.Wallet.Repository.WalletRepository;

@SpringBootTest
@AutoConfigureMockMvc
class WalletApplicationTests
{
	@Autowired
	private WalletRepository repo;
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads()
	{
		
	}

	@Test
	void createAndFindUser() throws Exception
	{
		//add wallet
		mvc.perform(post("/wallet/new"))
			.andExpect(status().isOk());
		//check that the get command returns a positive for wallet
		mvc.perform(get("/wallet/find/{id}", 1))
			.andExpect(status().isOk())
			.andExpect(result -> assertThat(result.getResolvedException() instanceof WalletNotFoundException));
	}
	
	@Test()
	void makeDeposit() throws Exception
	{
		//add wallet
		mvc.perform(post("/wallet/new"))
			.andExpect(status().isOk());
		//put in 25.00
		mvc.perform(put("/wallet/{id}/deposit/deposit={depo}", 1, 25.00))
			.andExpect(status().isOk());
		assertThat(repo.findById(1L).get().getBalance() == (double)25.00);
	}
	
	@Test()
	void retrieveStationFare() throws Exception
	{
		//test if origin daly + destination shay is valid
		mvc.perform(get("/trainstation/origin={origin}&destination={destination}", "daly", "shay"))
			.andExpect(status().isOk())
			.andExpect(result -> assertThat(result.getResolvedException() instanceof InvalidOriginOrDestinationException));
	}
	
	@Test()
	void payForTicket() throws Exception
	{
		//add wallet
		mvc.perform(post("/wallet/new"));
		assertThat(repo.findById(1L).get().getBalance() == (double) 0.00);
		//add to balance, test if succeeds
		mvc.perform(put("/wallet/{id}/deposit/deposit={depo}", 1, 25.00));
		assertThat(repo.findById(1L).get().getBalance() == (double) 25.00);
		mvc.perform(get("/wallet/{id}/buyticket/origin={origin}&destination={destination}", 1, "daly", "shay"))
			.andExpect(status().isOk())
			.andExpect(result -> assertThat(result.getResolvedException() instanceof InvalidOriginOrDestinationException))
			.andExpect(result -> assertThat(result.getResolvedException() instanceof WalletNotFoundException))
			.andExpect(result -> assertThat(result.getResolvedException() instanceof WalletNotEnoughException));
		assertThat(repo.findById(1L).get().getBalance() == (double) 18.55);
	}
}
