package com.cian.Wallet.API.model.Fare;

import com.cian.Wallet.API.model.Uri;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FareRoot {
	@JsonProperty("uri")
	private Uri uri;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("trip")
	private Trip trip;
	@JsonProperty("fares")
	private Fares fares;
}
