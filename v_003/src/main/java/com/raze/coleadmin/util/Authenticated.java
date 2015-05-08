package com.raze.coleadmin.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.raze.coleadmin.domain.Usuario;

public class Authenticated {
	
	public static Usuario getUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ((Usuario)auth.getPrincipal());
	}

	public static Long getIdUsuario() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return ((Usuario)auth.getPrincipal()).getId();
	}

	public static String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario user = ((Usuario)auth.getPrincipal());
		StringBuilder name = new StringBuilder(user.getNombre()).append(" ");
		name.append(user.getApellidoPaterno()).append(" ");
		name.append(user.getApellidoMaterno());
		return name.toString();
	}

}
