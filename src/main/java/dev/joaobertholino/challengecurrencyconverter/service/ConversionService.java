package dev.joaobertholino.challengecurrencyconverter.service;

import dev.joaobertholino.challengecurrencyconverter.response.PairConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.response.StandardConversionResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface ConversionService {
	StandardConversionResponse standardConversion(String currencyCodes, HttpServletRequest request);
	PairConversionResponse pairConversion(String baseCode, String targetCode, Double amount, HttpServletRequest request);
}
