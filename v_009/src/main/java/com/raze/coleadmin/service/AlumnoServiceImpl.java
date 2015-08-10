package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Alumno;
import com.raze.coleadmin.repository.AlumnoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        alumnoRepository.save(alumno);
    }

	public Alumno updateAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

	@Override
	public Alumno findAlumnoByCorreoE(String correoe) {
		return alumnoRepository.findByCorreoE(correoe);
	}

}
