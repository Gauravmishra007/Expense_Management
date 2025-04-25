package com.wipro.expense_management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseManagementApplication {
	
	@Bean
	public ModelMapper modelMappper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		System.out.println("Starting code...");
	}

}
