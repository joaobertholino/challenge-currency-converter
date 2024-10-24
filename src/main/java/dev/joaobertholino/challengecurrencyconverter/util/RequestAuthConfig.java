package dev.joaobertholino.challengecurrencyconverter.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RequestAuthConfig {
	private final RestTemplateBuilder templateBuilder;

	public RestTemplate templateAuthConfig(String authHeader) {
		return this.templateBuilder.defaultHeader("Authorization", authHeader).build();
	}
}
