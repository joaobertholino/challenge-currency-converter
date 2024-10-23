package dev.joaobertholino.challengecurrencyconverter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CurrencyCode {
	USD("USD"),
	BRL("BRL"),
	EUR("EUR"),
	ARS("ARS"),
	VES("VES"),
	BOB("BOB");

	private final String code;
}
