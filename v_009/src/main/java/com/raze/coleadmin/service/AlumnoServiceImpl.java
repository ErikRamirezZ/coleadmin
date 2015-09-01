package com.raze.coleadmin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.repository.AlumnoRepository;
import com.raze.coleadmin.util.Constants;
import com.raze.coleadmin.util.UserLoginData;
import com.raze.coleadmin.util.UserRoles;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
    AlumnoRepository alumnoRepository;
	
	@Autowired 
	UserRoles userRoles;
	
	public long countAllAlumnoes() {
        return alumnoRepository.count();
    }

	public void deleteAlumno(Alumno alumno) {
        alumnoRepository.delete(alumno);
    }

	public void logicalDeleteAlumno(Alumno alumno) {
		alumno.setUsuarioModifica(UserLoginData.getIdUsername());
		alumno.setFechaCreacion(new Date());
		alumno.setActivo(false);		
        alumnoRepository.save(alumno);
    }

	public Alumno findAlumno(Long id) {
        return alumnoRepository.findOne(id);
    }

	public List<Alumno> findAllAlumnoes() {
        return alumnoRepository.findAll();
    }

	public List<Alumno> findAlumnoEntries(int firstResult, int maxResults) {
        return alumnoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAlumno(Alumno alumno) {
		if(alumno.getId() > 0) {
			updateAlumno(alumno);
		} else {
			alumno.setUsuarioCrea(UserLoginData.getIdUsername());
			alumno.setFechaCreacion(new Date());
			alumno.setActivo(true);
			alumno.setRoles(userRoles.getRolesByUserType(Constants.ROLE_DB_STUDENT));
	        alumnoRepository.save(alumno);			
		}
    }

	public Alumno updateAlumno(Alumno alumno) {
		alumno.setUsuarioModifica(UserLoginData.getIdUsername());
		alumno.setFechaModificacion(new Date());
		alumno.setActivo(true);
		Alumno oldAlumno = alumnoRepository.findOne(alumno.getId());
		System.out.println("alumno.getFoto() ===> " + alumno.getFoto());
		System.out.println("alumno.getFoto().length ===> " + alumno.getFoto().length);
//		System.out.println("alumno.getFoto()[0] ===> " + alumno.getFoto()[0]);
		System.out.println("alumno.getFechaModificacion() ===> " + alumno.getFechaModificacion());
		System.out.println("alumno.getEscuela() ===> " + alumno.getEscuela());
		System.out.println("alumno.getRoles() ===> " + alumno.getRoles());
        if(alumno.getFoto().length<=1) {
        	alumno.setFoto(oldAlumno.getFoto());
        }
        alumno.setRoles(oldAlumno.getRoles());
        alumno.setEscuela(oldAlumno.getEscuela());
        return alumnoRepository.save(alumno);
    }

	@Override
	public Alumno findAlumnoByCorreoE(String correoe) {
		return alumnoRepository.findByCorreoE(correoe);
	}

}
