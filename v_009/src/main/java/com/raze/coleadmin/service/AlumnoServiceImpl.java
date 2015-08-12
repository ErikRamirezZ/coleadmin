package com.raze.coleadmin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.repository.AlumnoRepository;
import com.raze.coleadmin.util.UserLoginData;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
    AlumnoRepository alumnoRepository;

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
		alumno.setUsuarioCrea(UserLoginData.getIdUsername());
		alumno.setFechaCreacion(new Date());
		alumno.setActivo(true);
        alumnoRepository.save(alumno);
    }

	public Alumno updateAlumno(Alumno alumno) {
		alumno.setUsuarioModifica(UserLoginData.getIdUsername());
		alumno.setFechaModificacion(new Date());
		alumno.setActivo(true);
        return alumnoRepository.save(alumno);
    }

	@Override
	public Alumno findAlumnoByCorreoE(String correoe) {
		return alumnoRepository.findByCorreoE(correoe);
	}

}
