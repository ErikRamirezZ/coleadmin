package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Repeticiones;
import java.util.List;

public interface RepeticionesService {

	public abstract long countAllRepeticioneses();


	public abstract void deleteRepeticiones(Repeticiones repeticiones);


	public abstract Repeticiones findRepeticiones(Long id);


	public abstract List<Repeticiones> findAllRepeticioneses();


	public abstract List<Repeticiones> findRepeticionesEntries(int firstResult, int maxResults);


	public abstract void saveRepeticiones(Repeticiones repeticiones);


	public abstract Repeticiones updateRepeticiones(Repeticiones repeticiones);


	public abstract Repeticiones logicalDeleteRepeticiones(Repeticiones repeticiones);

}
