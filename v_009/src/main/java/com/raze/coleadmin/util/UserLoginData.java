package com.raze.coleadmin.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.domain.Personal;

public class UserLoginData {
	
	public static String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  return ((UserDetails)principal).getUsername();
		} else {
		  return principal.toString();
		}
	}
	
	public static Long getIdUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((Personal)principal).getId();
		} else {
		  return 0L;
		}
	}
		
	public static Escuela getEscuela() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((Personal)principal).getEscuela();
		} else {
		  return null;
		}
	}
		
}
