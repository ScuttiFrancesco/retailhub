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
		https
				// Disabilitiamo CSRF solo per le API REST stateless
				.csrf(csrf -> csrf.ignoringRequestMatchers("/auth/**", "/api/**"))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(httpmethod -> httpmethod.getMethod().equals("OPTIONS")).permitAll()
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
						.requestMatchers("/api/ordine/admin/**", "/api/cliente/admin/**", "/api/negozio/admin/**", "/api/operatore/admin/**")
						.hasAnyAuthority("ROLE_ADMIN", "ADMIN")  // permettiamo entrambe le versioni
						.requestMatchers("/api/magazzino/magazziniere/**", "/api/prodotto/magazziniere/**").hasAnyAuthority("ROLE_MAGAZZ", "MAGAZZ")
						.anyRequest().authenticated()
				)
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				// Aggiunta protezione header di sicurezza
				/* .headers(headers -> headers
                        .xssProtection(xss -> xss.enable(true)) // Enable XSS protection
                        .contentSecurityPolicy(csp -> csp.policyDirectives("default-src 'self'"))
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Recommended for clickjacking protection
                        .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).maxAgeInSeconds(31536000)) // HSTS for HTTPS enforcement
                ) */
				.addFilterBefore(jaf, UsernamePasswordAuthenticationFilter.class);

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
