package com.example.demo;

import com.example.demo.util.Printer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		new Printer().green(
			"",
			"Server Start!", 
			"http://localhost:8080/"
		);
	}


	@Bean
	public Printer printer() {
		return new Printer();
	}
}
