package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Modulo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.Modulo.class })
public interface ModuloService {

	public abstract long countAllModuloes();


	public abstract void deleteModulo(Modulo modulo);


	public abstract Modulo findModulo(Long id);


	public abstract List<Modulo> findAllModuloes();


	public abstract List<Modulo> findModuloEntries(int firstResult, int maxResults);


	public abstract void saveModulo(Modulo modulo);


	public abstract Modulo updateModulo(Modulo modulo);

}
