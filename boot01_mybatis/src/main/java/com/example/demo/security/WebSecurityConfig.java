package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 모든 web설정을 다 바꿔줌
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home", "/css/*", "/js/*", "/assets/*")
				.permitAll().requestMatchers("/admin/*", "/empMain").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin((form) -> form.permitAll().loginPage("/login").usernameParameter("userid").successForwardUrl("/board"))
				.logout((logout) -> logout.deleteCookies("JSESSIONID").permitAll()).csrf(csrf -> csrf.disable());

		return http.build();
	}


}