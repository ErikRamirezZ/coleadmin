package com.raze.coleadmin.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.service.domain.UsuarioServiceImpl;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		Usuario usuario = (Usuario)usuarioService.loadUserByUsername(username);
		
		if(usuario == null) {
			throw new BadCredentialsException("Usuario no encontrado");
		}
		if(!password.equals(usuario.getPassword())) {
			throw new BadCredentialsException("Contrasenña incorrecta"); 
		}

		Collection<? extends GrantedAuthority> roles = usuario.getRoles();
        
        return new UsernamePasswordAuthenticationToken(usuario, password, roles);

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
