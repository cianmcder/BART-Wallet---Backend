package com.cian.Wallet.API.model.Fare;

import com.cian.Wallet.API.model.Xml;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FareJson {
	@JsonProperty("?xml")
	private Xml xml;
	@JsonProperty("root")
	private FareRoot root;
}
