package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.PagoEscuela;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.PagoEscuela.class })
public interface PagoEscuelaService {

	public abstract long countAllPagoEscuelas();


	public abstract void deletePagoEscuela(PagoEscuela pagoEscuela);


	public abstract PagoEscuela findPagoEscuela(Long id);


	public abstract List<PagoEscuela> findAllPagoEscuelas();


	public abstract List<PagoEscuela> findPagoEscuelaEntries(int firstResult, int maxResults);


	public abstract void savePagoEscuela(PagoEscuela pagoEscuela);


	public abstract PagoEscuela updatePagoEscuela(PagoEscuela pagoEscuela);

}
