package com.restweb.retailhub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.restweb.retailhub.user.UserServiceImpl;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jaf;
	private final UserServiceImpl us;

	@Autowired
	public SecurityConfig(UserServiceImpl us, JwtAuthenticationFilter jaf) {
		this.us = us;
		this.jaf = jaf;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity https) throws Exception {

		https.csrf().disable().authorizeHttpRequests().requestMatchers("/api/cliente/**","/auth/**").permitAll().requestMatchers("/admin/**").hasRole("ADMIN").anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		https.addFilterBefore(jaf, UsernamePasswordAuthenticationFilter.class);
		return https.build();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity https, PasswordEncoder pe) throws Exception {

		return https.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(us).passwordEncoder(pe)
				.and().build();
	}

	@Bean
	public PasswordEncoder passwordEndcoder() {
		return new BCryptPasswordEncoder();
	}
}
