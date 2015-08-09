package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Permiso;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.Permiso.class })
public interface PermisoService {

	public abstract long countAllPermisoes();


	public abstract void deletePermiso(Permiso permiso);


	public abstract Permiso findPermiso(Long id);


	public abstract List<Permiso> findAllPermisoes();


	public abstract List<Permiso> findPermisoEntries(int firstResult, int maxResults);


	public abstract void savePermiso(Permiso permiso);


	public abstract Permiso updatePermiso(Permiso permiso);

}
