package com.raze.coleadmin.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raze.coleadmin.catalog.Rol;
import com.raze.coleadmin.service.RolService;

@Component
public class UserRoles {

	@Autowired
	RolService rolService;
	
	public Set<Rol> getRolesByUserType(String typeUser) {
		Set<Rol> roles = new HashSet<Rol>();
		roles.add(rolService.findeRolByNombreRol(typeUser));
		return roles;
	}
	
}
