package com.cian.Wallet.API.model.Stations;

import com.cian.Wallet.API.model.Xml;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stations {
	@JsonProperty("?xml")
	private Xml xml;
	@JsonProperty("root")
	private StationsRoot root;
}
