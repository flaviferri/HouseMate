package com.houseMate.houseMate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.houseMate.houseMate.controllers.RegisterRequest;
import com.houseMate.houseMate.models.Category;
import com.houseMate.houseMate.models.Status;
import com.houseMate.houseMate.repositories.ICategoryRepository;
import com.houseMate.houseMate.repositories.IStatusRepository;
import com.houseMate.houseMate.role.Role;
import com.houseMate.houseMate.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

import static com.houseMate.houseMate.role.Role.ADMIN;
import static com.houseMate.houseMate.role.Role.USER;

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
		mapper.registerModule(new JavaTimeModule());
		return mapper;
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthService service
	){
		return args -> {
			var admin = RegisterRequest.builder()
					.name("Admin")
					.lastname("Admin")
					.email("admin@gmail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token " + service.register(admin).getToken());
			var user = RegisterRequest.builder()
					.name("User")
					.lastname("User")
					.email("user@gmail.com")
					.password("password")
					.role(USER)
					.build();
			System.out.println("User token " + service.register(user).getToken());

		};
	}
	}



