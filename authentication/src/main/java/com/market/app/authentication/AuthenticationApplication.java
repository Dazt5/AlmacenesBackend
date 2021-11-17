package com.market.app.authentication;

import com.market.app.authentication.entity.User;
import com.market.app.authentication.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import static com.market.app.authentication.utils.Constants.User.*;

@SpringBootApplication
public class AuthenticationApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

	@Autowired
	private IUserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	InitializingBean setupDatabase(){
		return () ->{
			LOGGER.info("-------- SCANNING THE DATABASE ---------");
			Optional<User> user = repository.findByUsername(DEFAULT_USER_USERNAME);
			if(user.isEmpty()){
				LOGGER.info("-------- STARTING DATABASE SETUP ---------");
				User defaultUser = new User();
				defaultUser.setUsername(DEFAULT_USER_USERNAME);
				defaultUser.setPassword(DEFAULT_USER_PASSWORD);
				repository.save(defaultUser);
				LOGGER.info("--------- FINALIZED DATABASE SETUP ---------");
			}
			LOGGER.info("---------- DATABASE SCAN FINALIZED ---------");
		};
	}
}
