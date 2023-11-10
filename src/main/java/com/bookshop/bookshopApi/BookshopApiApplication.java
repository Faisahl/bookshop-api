package com.bookshop.bookshopApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"entity", "controller", "service", "repository"})
@EnableJpaRepositories("repository")
@EntityScan("entity")
public class BookshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApiApplication.class, args);
	}

}
