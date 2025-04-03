package com.cian.Wallet.API.model.Stations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationsArray {
	@JsonProperty("station")
	private List<StationData> stationData;
}
