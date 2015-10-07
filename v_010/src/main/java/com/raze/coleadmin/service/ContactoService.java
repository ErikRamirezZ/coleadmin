package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Contacto;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.Contacto.class })
public interface ContactoService {

	public abstract long countAllContactoes();


	public abstract void deleteContacto(Contacto contacto);


	public abstract Contacto findContacto(Long id);


	public abstract List<Contacto> findAllContactoes();


	public abstract List<Contacto> findContactoEntries(int firstResult, int maxResults);


	public abstract void saveContacto(Contacto contacto);


	public abstract Contacto updateContacto(Contacto contacto);

}
