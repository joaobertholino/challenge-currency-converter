package dev.joaobertholino.challengecurrencyconverter.response;

public record PairConversionResponse(
	String time_last_update_utc,
	String base_code,
	String target_code,
	Double conversion_result
) {
}
