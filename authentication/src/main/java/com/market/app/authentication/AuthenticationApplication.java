package com.market.app.authentication;

import com.market.app.authentication.entity.Subsidiary;
import com.market.app.authentication.entity.User;
import com.market.app.authentication.repository.ISubsidiaryRepository;
import com.market.app.authentication.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

import static com.market.app.authentication.utils.Constants.User.*;
import static com.market.app.authentication.utils.Constants.*;


@SpringBootApplication
public class AuthenticationApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ISubsidiaryRepository subsidiaryRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	InitializingBean setupDatabase(){
		return () ->{
			LOGGER.info("-------- SCANNING THE DATABASE TO DEFAULT USER ---------");
			Optional<User> user = userRepository.findByUsername(DEFAULT_USER_USERNAME);
			if(user.isEmpty()){
				LOGGER.info("-------- STARTING DATABASE SETUP TO DEFAULT USER ---------");
				User defaultUser = new User();
				defaultUser.setUsername(DEFAULT_USER_USERNAME);
				defaultUser.setPassword(DEFAULT_USER_PASSWORD);
				userRepository.save(defaultUser);
				LOGGER.info("--------- FINALIZED DATABASE SETUP TO DEFAULT USER ---------");
			}
			LOGGER.info("---------- DATABASE SCAN FINALIZED TO DEFAULT USER---------");

			List<Subsidiary> registerSubsidiaries = subsidiaryRepository.findAll();

			if(registerSubsidiaries.size() < 3){
				subsidiaryRepository.saveAll(defaultSubsidaries);
			}
		};
	}
}
