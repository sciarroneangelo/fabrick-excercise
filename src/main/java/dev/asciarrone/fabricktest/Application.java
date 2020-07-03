package dev.asciarrone.fabricktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import dev.asciarrone.fabricktest.handler.RestTemplateResponseErrorHandler;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		return restTemplate;
	}

	@Bean
	public RestTemplate moneyTrasferRestTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
		return restTemplate;
	}

	@Bean
	public HttpHeaders httpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Auth-Schema", "S2S");
		headers.set("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		headers.add("Accept", "application/json");
		return headers;
	}
}
