package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Padre;

import java.util.List;

public interface PadreService {

	public abstract long countAllPadres();


	public abstract void deletePadre(Padre padre);


	public abstract Padre findPadre(Long id);


	public abstract List<Padre> findAllPadres();


	public abstract List<Padre> findPadreEntries(int firstResult, int maxResults);


	public abstract void savePadre(Padre padre);


	public abstract Padre updatePadre(Padre padre);


	public abstract Padre findPadreByCorreoE(String correoE);

}
