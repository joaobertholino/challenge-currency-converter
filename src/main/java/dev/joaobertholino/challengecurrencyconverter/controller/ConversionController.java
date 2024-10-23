package dev.joaobertholino.challengecurrencyconverter.controller;

import dev.joaobertholino.challengecurrencyconverter.response.PairConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.response.StandardConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.service.ConversionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
@RequiredArgsConstructor
public class ConversionController {
	private final ConversionService conversionService;

	@GetMapping("/standard")
	public ResponseEntity<StandardConversionResponse> standardConversion(@RequestParam String currencyCode, HttpServletRequest request) {
		StandardConversionResponse standardConversionResponse = this.conversionService.standardConversion(currencyCode, request);
		return ResponseEntity.status(200).body(standardConversionResponse);
	}

	@GetMapping("/pair")
	public ResponseEntity<PairConversionResponse> pairConversion(@RequestParam String baseCode, @RequestParam String targetCode, @RequestParam Double amount, HttpServletRequest request) {
		PairConversionResponse pairConversionResponse = this.conversionService.pairConversion(baseCode, targetCode, amount, request);
		return ResponseEntity.status(200).body(pairConversionResponse);
	}
}
