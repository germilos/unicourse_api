package com.njt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application entry point
 *
 */
@SpringBootApplication(scanBasePackages = "com.njt")
@EnableJpaRepositories(basePackages = { "com.njt.repo" })
@EntityScan(basePackages = { "com.njt.repo.entity" })
public class App
{
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
