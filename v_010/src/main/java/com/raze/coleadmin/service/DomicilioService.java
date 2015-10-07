package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Domicilio;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Domicilio.class })
public interface DomicilioService {

	public abstract long countAllDomicilios();


	public abstract void deleteDomicilio(Domicilio domicilio);


	public abstract Domicilio findDomicilio(Long id);


	public abstract List<Domicilio> findAllDomicilios();


	public abstract List<Domicilio> findDomicilioEntries(int firstResult, int maxResults);


	public abstract void saveDomicilio(Domicilio domicilio);


	public abstract Domicilio updateDomicilio(Domicilio domicilio);

}
