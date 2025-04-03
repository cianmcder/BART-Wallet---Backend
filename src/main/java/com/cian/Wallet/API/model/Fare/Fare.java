package com.cian.Wallet.API.model.Fare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fare {
	@JsonProperty("@amount")
	private String fareAmount;
	@JsonProperty("@class")
	private String fareClass;
	@JsonProperty("@name")
	private String fareName;
}