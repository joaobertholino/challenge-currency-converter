package dev.joaobertholino.challengecurrencyconverter.service.impl;

import dev.joaobertholino.challengecurrencyconverter.enums.CurrencyCode;
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
	public StandardConversionResponse standardConversion(CurrencyCode currencyCode, String authHeader) {
		return this.authConfig.templateAuthConfig(authHeader).getForObject("/latest/" + currencyCode.getCode(), StandardConversionResponse.class);
	}

	@Override
	public PairConversionResponse pairConversion(CurrencyCode baseCode, CurrencyCode targetCode, Double amount, String authHeader) {
		if(baseCode.equals(targetCode)) {
			throw new RuntimeException("Os códigos de moeda são iguais");
		}

		RestTemplate template = this.authConfig.templateAuthConfig(authHeader);
		return template.getForObject("/pair/" + baseCode.getCode() + "/" + targetCode.getCode() + "/" + amount, PairConversionResponse.class);
	}
}
