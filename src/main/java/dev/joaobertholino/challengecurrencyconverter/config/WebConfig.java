package dev.joaobertholino.challengecurrencyconverter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class WebConfig {

	@Value(value = "${base.url}")
	private String baseUrl;

	@Bean
	public RestTemplateBuilder restTemplate() {
		return new RestTemplateBuilder().uriTemplateHandler(new DefaultUriBuilderFactory(this.baseUrl));
	}
}
