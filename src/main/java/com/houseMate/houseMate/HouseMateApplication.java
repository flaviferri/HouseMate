package com.houseMate.houseMate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.houseMate.houseMate.models.Category;
import com.houseMate.houseMate.models.Status;
import com.houseMate.houseMate.repositories.ICategoryRepository;
import com.houseMate.houseMate.repositories.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class HouseMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseMateApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Autowired
	ICategoryRepository iCategoryRepository;
	@Autowired
	IStatusRepository iStatusRepository;

	@Bean
	public CommandLineRunner startup() {
		return args -> {
			iCategoryRepository.saveAll(
					Arrays.asList(
							new Category("Cleaning"),
							new Category("Pay bills"),
							new Category("Buy groceries"),
							new Category("Home arrangements")
					)
			);
			iStatusRepository.saveAll(
					Arrays.asList(
							new Status("Created"),
							new Status("In process"),
							new Status("Complete")
					)
			);
		};
	};

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.registerModule(new JavaTimeModule()); // Para manejar LocalDateTime
		return mapper;
	}
	}



