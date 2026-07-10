package com.ali_dev.spring_demo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class SpringDemoAppApplication {

	public static void main(String[] args) {
		configureHostedDatabase();
		SpringApplication.run(SpringDemoAppApplication.class, args);
	}

	private static void configureHostedDatabase() {
		String databaseUrl = System.getenv("DATABASE_URL");
		if (databaseUrl == null || databaseUrl.isBlank()) {
			return;
		}

		URI uri = URI.create(databaseUrl);
		String[] credentials = uri.getUserInfo().split(":", 2);
		int port = uri.getPort() == -1 ? 5432 : uri.getPort();
		String query = uri.getQuery() == null ? "" : "?" + uri.getQuery();

		System.setProperty("spring.datasource.url",
				"jdbc:postgresql://" + uri.getHost() + ":" + port + uri.getPath() + query);
		System.setProperty("spring.datasource.username", decode(credentials[0]));
		System.setProperty("spring.datasource.password", decode(credentials[1]));
	}

	private static String decode(String value) {
		return URLDecoder.decode(value, StandardCharsets.UTF_8);
	}

}
