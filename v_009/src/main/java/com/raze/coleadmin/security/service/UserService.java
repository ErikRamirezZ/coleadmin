package com.raze.coleadmin.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raze.coleadmin.security.dao.UserDAO;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.DocenteService;
import com.raze.coleadmin.service.PadreService;
import com.raze.coleadmin.service.PersonalService;
import com.raze.coleadmin.util.Constants;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	DocenteService docenteService;
	
	@Autowired
	PadreService padreService;
	
	@Autowired
	PersonalService personalService;
	
	@Override
	public UserDetails loadUserByUsername(String correoE)
			throws UsernameNotFoundException {
		String typeUser = userDAO.findUserByUsername(correoE);
		if(typeUser.equals(Constants.TYPE_USER_ALUMNO)){
			return alumnoService.findAlumnoByCorreoE(correoE);
		} else if(typeUser.equals(Constants.TYPE_USER_DOCENTE)) {
			return docenteService.findDocenteByCorreoE(correoE);
		} else if(typeUser.equals(Constants.TYPE_USER_PADRE)) {
			return padreService.findPadreByCorreoE(correoE);
		} else if(typeUser.equals(Constants.TYPE_USER_PERSONAL)) {
			return personalService.findPersonalByCorreoE(correoE);
		}
		return null;
	}

}
