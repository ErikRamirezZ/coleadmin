package com.raze.coleadmin.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.raze.coleadmin.domain.Login;
import com.raze.coleadmin.service.LoginServiceImpl;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	static private Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
	    String username = authentication.getName();
        String password = (String) authentication.getCredentials();
 
        log.error("Ya estoy en el servicio con username => " + username);
        Login user = loginService.loadUserByUsername(username);
 
        log.error("Ya estoy de regreso en el customLogin con user => " + user);
        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }
 
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
 
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
 
        return new UsernamePasswordAuthenticationToken(user, password, authorities);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
