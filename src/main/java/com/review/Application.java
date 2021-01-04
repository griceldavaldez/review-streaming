package com.review;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.review"})

@EnableJpaRepositories(basePackages = {"com.review.repository"})
@EntityScan(basePackages = {"com.review.bean"})


public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
