package dev.joaobertholino.challengecurrencyconverter.service.impl;

import dev.joaobertholino.challengecurrencyconverter.response.PairConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.util.RequestAuthConfig;
import dev.joaobertholino.challengecurrencyconverter.response.StandardConversionResponse;
import dev.joaobertholino.challengecurrencyconverter.service.ConversionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {
	private final RequestAuthConfig authConfig;

	@Override
	public StandardConversionResponse standardConversion(String currencyCode, HttpServletRequest request) {
		return this.authConfig.templateAuthConfig(request).getForObject("/latest/" + currencyCode, StandardConversionResponse.class);
	}

	@Override
	public PairConversionResponse pairConversion(String baseCode, String targetCode, Double amount, HttpServletRequest request) {
		RestTemplate template = this.authConfig.templateAuthConfig(request);
		return template.getForObject("/pair/" + baseCode + "/" + targetCode + "/" + amount, PairConversionResponse.class);
	}
}
