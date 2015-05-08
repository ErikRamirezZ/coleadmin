package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.Escuela;
import java.util.List;

public interface EscuelaService {

	public abstract long countAllEscuelas();


	public abstract void deleteEscuela(Escuela escuela);


	public abstract Escuela findEscuela(Long id);


	public abstract List<Escuela> findAllEscuelas();


	public abstract List<Escuela> findEscuelaEntries(int firstResult, int maxResults);


	public abstract void saveEscuela(Escuela escuela);


	public abstract Escuela updateEscuela(Escuela escuela);


	public abstract Escuela logicalDeleteEscuela(Escuela escuela);

}
