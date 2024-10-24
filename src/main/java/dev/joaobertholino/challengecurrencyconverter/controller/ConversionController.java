package dev.joaobertholino.challengecurrencyconverter.controller;

import dev.joaobertholino.challengecurrencyconverter.enums.CurrencyCode;
import dev.joaobertholino.challengecurrencyconverter.response.PairConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.response.StandardConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversion")
@RequiredArgsConstructor
public class ConversionController {
	private final ConversionService conversionService;

	@GetMapping("/standard")
	public ResponseEntity<StandardConversionResponse> standardConversion(@RequestParam CurrencyCode currencyCode, @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
		System.out.println(authHeader);
		StandardConversionResponse standardConversionResponse = this.conversionService.standardConversion(currencyCode, authHeader);
		return ResponseEntity.status(200).body(standardConversionResponse);
	}

	@GetMapping("/pair")
	public ResponseEntity<PairConversionResponse> pairConversion(@RequestParam CurrencyCode baseCode, @RequestParam CurrencyCode targetCode, @RequestParam Double amount, @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
		PairConversionResponse pairConversionResponse = this.conversionService.pairConversion(baseCode, targetCode, amount, authHeader);
		return ResponseEntity.status(200).body(pairConversionResponse);
	}
}
