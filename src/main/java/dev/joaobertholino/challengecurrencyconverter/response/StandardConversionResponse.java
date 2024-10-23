package dev.joaobertholino.challengecurrencyconverter.response;

import java.util.Map;

public record StandardConversionResponse(
	String time_last_update_utc,
	String base_code,
	Map<String, Double> conversion_rates
) {
}
