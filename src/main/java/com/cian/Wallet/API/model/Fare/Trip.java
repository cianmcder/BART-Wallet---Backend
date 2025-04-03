package com.cian.Wallet.API.model.Fare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
	@JsonProperty("fare")
	private String fare;
	@JsonProperty("discount")
	private Discount discount;
}
