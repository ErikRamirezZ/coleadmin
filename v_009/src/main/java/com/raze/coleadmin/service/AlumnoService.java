package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Alumno;

import java.util.List;

public interface AlumnoService {

	public abstract long countAllAlumnoes();


	public abstract void deleteAlumno(Alumno alumno);


	public abstract Alumno findAlumno(Long id);


	public abstract List<Alumno> findAllAlumnoes();


	public abstract List<Alumno> findAlumnoEntries(int firstResult, int maxResults);


	public abstract void saveAlumno(Alumno alumno);


	public abstract Alumno updateAlumno(Alumno alumno);


	public abstract Alumno  findAlumnoByCorreoE(String correoe);

}
