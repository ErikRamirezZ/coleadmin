package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Docente;

import java.util.List;

public interface DocenteService {

	public abstract long countAllDocentes();


	public abstract void deleteDocente(Docente docente);


	public abstract Docente findDocente(Long id);


	public abstract List<Docente> findAllDocentes();


	public abstract List<Docente> findDocenteEntries(int firstResult, int maxResults);


	public abstract void saveDocente(Docente docente);


	public abstract Docente updateDocente(Docente docente);


	public abstract Docente findDocenteByCorreoE(String correoE);

}
