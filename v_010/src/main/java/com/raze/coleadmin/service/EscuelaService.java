package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Escuela;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Escuela.class })
public interface EscuelaService {

	public abstract long countAllEscuelas();


	public abstract void deleteEscuela(Escuela escuela);


	public abstract Escuela findEscuela(Long id);


	public abstract List<Escuela> findAllEscuelas();


	public abstract List<Escuela> findEscuelaEntries(int firstResult, int maxResults);


	public abstract void saveEscuela(Escuela escuela);


	public abstract Escuela updateEscuela(Escuela escuela);

}
