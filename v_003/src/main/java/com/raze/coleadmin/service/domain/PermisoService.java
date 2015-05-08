package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.Permiso;
import java.util.List;

public interface PermisoService {

	public abstract long countAllPermisoes();


	public abstract void deletePermiso(Permiso permiso);


	public abstract Permiso findPermiso(Long id);


	public abstract List<Permiso> findAllPermisoes();


	public abstract List<Permiso> findPermisoEntries(int firstResult, int maxResults);


	public abstract void savePermiso(Permiso permiso);


	public abstract Permiso updatePermiso(Permiso permiso);

}
