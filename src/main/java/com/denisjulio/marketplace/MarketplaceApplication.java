package com.denisjulio.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.denisjulio.marketplace.utils.DateUtils;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@SpringBootApplication
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

	@Bean
	Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	@Bean
	LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	@Bean
	DateUtils dateUtils() {
		return new DateUtils();
	}
}
