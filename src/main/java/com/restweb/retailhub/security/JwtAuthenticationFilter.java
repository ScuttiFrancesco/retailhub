package com.restweb.retailhub.security;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil ju;
	private final UserDetailsService uds;

	public JwtAuthenticationFilter(JwtUtil ju, UserDetailsService uds) {
		this.ju = ju;
		this.uds = uds;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {

	    final String authHeader = request.getHeader("Authorization");

	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        filterChain.doFilter(request, response);
	        return;
	    }

	    final String jwt = authHeader.substring(7);
	    final String username = ju.extractUsername(jwt);

	    System.out.println("Token estratto: " + jwt); // Aggiunto logging
	    System.out.println("Username estratto: " + username); // Aggiunto logging

	    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	        UserDetails us = uds.loadUserByUsername(username);

	        System.out.println("UserDetails caricato: " + us); // Aggiunto logging

	        if (ju.isTokenValid(jwt, us.getUsername())) {

	            System.out.println("Token valido: " + ju.isTokenValid(jwt, us.getUsername())); // Aggiunto logging
	            System.out.println("Authorities: " + us.getAuthorities()); // Aggiunto logging

	            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(us, null,
	                    us.getAuthorities());
	            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	            SecurityContextHolder.getContext().setAuthentication(authToken);
	            System.out.println("Authentication set for: " + username);
	        }
	    }
	    filterChain.doFilter(request, response);
	}

}
