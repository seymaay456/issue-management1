package com.temelt.issue_management;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(IssueManagementApplication.class, args);

	}
	@Bean //uygulama contextine dahil etmek için
	public static ModelMapper getModelMapper(){
		return new ModelMapper();
	}



}
