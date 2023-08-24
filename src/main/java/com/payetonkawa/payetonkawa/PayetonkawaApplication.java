package com.payetonkawa.payetonkawa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
public class PayetonkawaApplication {

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
						.authenticated())
				.httpBasic(withDefaults())
				.formLogin(withDefaults())
				.csrf(AbstractHttpConfigurer::disable);
		return http.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(PayetonkawaApplication.class, args);
	}

}
