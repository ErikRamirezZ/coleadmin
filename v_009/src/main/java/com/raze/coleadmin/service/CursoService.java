package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Curso;
import java.util.List;

public interface CursoService {

	public abstract long countAllCursoes();


	public abstract void deleteCurso(Curso curso);


	public abstract Curso findCurso(Long id);


	public abstract List<Curso> findAllCursoes();


	public abstract List<Curso> findCursoEntries(int firstResult, int maxResults);


	public abstract void saveCurso(Curso curso);


	public abstract Curso updateCurso(Curso curso);

}
