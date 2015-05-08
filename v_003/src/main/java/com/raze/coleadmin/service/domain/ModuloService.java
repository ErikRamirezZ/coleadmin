package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.Modulo;
import java.util.List;

public interface ModuloService {

	public abstract long countAllModuloes();


	public abstract void deleteModulo(Modulo modulo);


	public abstract Modulo findModulo(Long id);


	public abstract List<Modulo> findAllModuloes();


	public abstract List<Modulo> findModuloEntries(int firstResult, int maxResults);


	public abstract void saveModulo(Modulo modulo);


	public abstract Modulo updateModulo(Modulo modulo);


	public abstract Modulo logicalDeleteModulo(Modulo modulo);

}
