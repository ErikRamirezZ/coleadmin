package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.EstatusInscripcion;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.EstatusInscripcion.class })
public interface EstatusInscripcionService {

	public abstract long countAllEstatusInscripcions();


	public abstract void deleteEstatusInscripcion(EstatusInscripcion estatusInscripcion);


	public abstract EstatusInscripcion findEstatusInscripcion(Long id);


	public abstract List<EstatusInscripcion> findAllEstatusInscripcions();


	public abstract List<EstatusInscripcion> findEstatusInscripcionEntries(int firstResult, int maxResults);


	public abstract void saveEstatusInscripcion(EstatusInscripcion estatusInscripcion);


	public abstract EstatusInscripcion updateEstatusInscripcion(EstatusInscripcion estatusInscripcion);

}
