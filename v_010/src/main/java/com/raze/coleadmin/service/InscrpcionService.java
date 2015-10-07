package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Inscrpcion;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Inscrpcion.class })
public interface InscrpcionService {

	public abstract long countAllInscrpcions();


	public abstract void deleteInscrpcion(Inscrpcion inscrpcion);


	public abstract Inscrpcion findInscrpcion(Long id);


	public abstract List<Inscrpcion> findAllInscrpcions();


	public abstract List<Inscrpcion> findInscrpcionEntries(int firstResult, int maxResults);


	public abstract void saveInscrpcion(Inscrpcion inscrpcion);


	public abstract Inscrpcion updateInscrpcion(Inscrpcion inscrpcion);

}
