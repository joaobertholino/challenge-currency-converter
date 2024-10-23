package dev.joaobertholino.challengecurrencyconverter.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RequestAuthConfig {
	private final RestTemplateBuilder templateBuilder;

	public RestTemplate templateAuthConfig(HttpServletRequest request) {
		return this.templateBuilder.defaultHeader("Authorization", request.getHeader("Authorization")).build();
	}
}
