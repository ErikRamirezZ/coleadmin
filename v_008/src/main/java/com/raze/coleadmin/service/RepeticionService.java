package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Repeticion;
import java.util.List;

public interface RepeticionService {

	public abstract long countAllRepeticions();


	public abstract void deleteRepeticion(Repeticion repeticion);


	public abstract Repeticion findRepeticion(Long id);


	public abstract List<Repeticion> findAllRepeticions();


	public abstract List<Repeticion> findRepeticionEntries(int firstResult, int maxResults);


	public abstract void saveRepeticion(Repeticion repeticion);


	public abstract Repeticion updateRepeticion(Repeticion repeticion);

}
