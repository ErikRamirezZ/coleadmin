package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Correo;
import java.util.List;

public interface CorreoService {

	public abstract long countAllCorreos();


	public abstract void deleteCorreo(Correo correo);


	public abstract Correo findCorreo(Long id);


	public abstract List<Correo> findAllCorreos();


	public abstract List<Correo> findCorreoEntries(int firstResult, int maxResults);


	public abstract void saveCorreo(Correo correo);


	public abstract Correo updateCorreo(Correo correo);

}
