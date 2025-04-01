package com.cian.Wallet.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Xml {
	@JsonProperty("@version")
	private String version;
	@JsonProperty("@encoding")
	private String encoding;
}
