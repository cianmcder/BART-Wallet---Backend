package com.cian.Wallet.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cian.Wallet.Entity.Ticket;
import com.cian.Wallet.Entity.Wallet;
import com.cian.Wallet.Exceptions.InvalidOriginOrDestinationException;
import com.cian.Wallet.Exceptions.WalletNotEnoughException;
import com.cian.Wallet.Exceptions.WalletNotFoundException;
import com.cian.Wallet.Repository.WalletRepository;

@RestController
public class WalletController
{
	private final WalletRepository repo;
	
	WalletController(WalletRepository repo) {
		this.repo = repo;
	}
	
	//Retrieves all instances of Wallet in the database
	@RequestMapping(value = "/wallet/find/all")
	List<Wallet> getAll()
	{
		return repo.findAll();
	}
	
	//retrieve wallet of specified id
	@GetMapping("/wallet/find/{id}")
	Wallet getWallet(@PathVariable Long id)
	{
		return repo.findById(id)
				.orElseThrow(() -> new WalletNotFoundException(id));
	}
	
	//create new wallet
	@PostMapping(path = "/wallet/new")
	Long newWallet()
	{
		Wallet w = new Wallet();
		repo.save(w);
		return w.getWalletId();
	}
	
	//delete wallet
	@DeleteMapping("/wallet/delete/{id}")
	void deleteWallet(@PathVariable Long id)
	{
		repo.deleteById(id);
	}
	
	//make deposit
	@PutMapping("/wallet/{id}/deposit/deposit={depo}")
	Wallet makeDeposit(@PathVariable long id, @PathVariable double depo)
	{
		//check if wallet exists by id
		Wallet w = repo.findById(id)
				.orElseThrow(() -> new WalletNotFoundException(id));
		//add money
		w.addBalance(depo);
		return repo.save(w);
	}
	
	//retrieve fare for given origin and destination
	@GetMapping("/trainstation/origin={origin}&destination={destination}")
	String getFare(@PathVariable String origin, @PathVariable String destination)
	{
		//is origin and destination valid? if not, throw error
		String [] valid = new String [] {"12th", "16th", "19th", "24th", "ashb", "antc", "balb", "bayf", "bery", "cast", "civc", "cols",
							"colm",	"conc", "daly",	"dbrk",	"dubl",	"deln",	"plza",	"embr",	"frmt",	"ftvl",	"glen",	"hayw",	"lafy",	"lake",
							"mcar",	"mlbr", "mlpt",	"mont",	"nbrk",	"ncon",	"oakl",	"orin",	"pitt",	"pctr",	"phil",	"powl",	"rich",	"rock",
							"sbrn",	"sfia",	"sanl",	"shay",	"ssan",	"ucty",	"warm",	"wcrk",	"wdub",	"woak"};
		if(Arrays.asList(valid).contains(origin) == false || Arrays.asList(valid).contains(destination) == false)
			throw new InvalidOriginOrDestinationException(origin, destination);
		//retrieve json response containing ticket fare from api.bart.gov/
		String url = "http://api.bart.gov/api/sched.aspx?cmd=fare&orig=" +origin+ "&dest=" +destination+ "&date=today&key=MW9S-E7SL-26DU-VV8V&json=y";
        double fare = 0;
		try
        {
        	URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            
            //add request header
            //con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            //get json text
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
            {
            	response.append(inputLine);
            }
            in.close();
            
            //print in String
            System.out.println("Response body: " + response.toString());
            //parsing for nested objects. see BartAPIExample.txt
            JSONObject json = new JSONObject(response.toString());
            //JSONArray jArray = json.getJSONArray("root");
            JSONObject jArray = json.getJSONObject("root");
            System.out.println("Contents of root: " +jArray.toString());
            //get the fourth value in root, trip, then the fare
            fare = jArray.getJSONObject("trip").getDouble("fare");
            System.out.println("Fare: " + fare);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		//create JSON for return
		JSONObject json = new JSONObject();
		json.put("origin", origin);
		json.put("destination", destination);
		json.put("fare", fare);
		
		//ex: {"fare":6.45,"origin":"daly","destination":"shay"}
		return json.toString();
	}
	
	//buy ticket for given wallet, origin, and destination
	@RequestMapping(value = "/wallet/{id}/buyticket/origin={origin}&destination={destination}")
	Ticket buyTicket(@PathVariable long id, @PathVariable String origin, @PathVariable String destination)
	{
		//call getFare to get the cost of the ticket
		String json = getFare(origin, destination);
		JSONObject obj = new JSONObject(json);
		double fare = obj.getDouble("fare");
		System.out.println("Extracted far. Payment: " + fare);
		//does the wallet exist? if not, throw error
		Wallet w = repo.findById(id)
				.orElseThrow(() -> new WalletNotFoundException(id));
		//does the wallet have enough in its balance? if not, throw error
		if(fare > w.getBalance())
		{
			throw new WalletNotEnoughException(w.getWalletId(), fare, w.getBalance());
		}
		else
		{
			w.payTicket(fare);
			repo.save(w);
			Ticket t = new Ticket(origin, destination, id);
			return t;
		}
	}
}
