package com.cian.Wallet.API.model.Stations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationData {
	@JsonProperty("name")
	private String name;
	@JsonProperty("abbr")
	private String abbreviation;
	@JsonProperty("gtfs_latitude")
	private String gtfsLatitude;
	@JsonProperty("gtfs_longitude")
	private String gtfsLongitude;
	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("county")
	private String county;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipcode")
	private String zipCode;
}