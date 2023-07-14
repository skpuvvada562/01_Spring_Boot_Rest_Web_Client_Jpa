package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Value("${third.party.url}")
	private String url;*/
	
	@Bean
	public WebClient getClient(){
		return WebClient.builder()
						.baseUrl("https://jsonplaceholder.typicode.com")
						.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.build();
	}
	
	/**
	 * enabled actuators for this project http://localhost:9293/actuator
	 */
}
