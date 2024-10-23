package dev.joaobertholino.challengecurrencyconverter.service;

import dev.joaobertholino.challengecurrencyconverter.enums.CurrencyCode;
import dev.joaobertholino.challengecurrencyconverter.response.PairConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.response.StandardConversionResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface ConversionService {
	StandardConversionResponse standardConversion(CurrencyCode currencyCodes, HttpServletRequest request);
	PairConversionResponse pairConversion(CurrencyCode baseCode, CurrencyCode targetCode, Double amount, HttpServletRequest request);
}
