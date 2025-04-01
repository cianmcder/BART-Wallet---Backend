package com.cian.Wallet.API.model.Stations;

import com.cian.Wallet.API.model.Uri;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationsRoot {
	@JsonProperty("uri")
	private Uri uri;
	@JsonProperty("stations")
	//private List<Station> stations;
	private StationsArray stations;
	@JsonProperty("message")
	private String message;
}
