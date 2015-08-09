package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.CicloEscolar;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.CicloEscolar.class })
public interface CicloEscolarService {

	public abstract long countAllCicloEscolars();


	public abstract void deleteCicloEscolar(CicloEscolar cicloEscolar);


	public abstract CicloEscolar findCicloEscolar(Long id);


	public abstract List<CicloEscolar> findAllCicloEscolars();


	public abstract List<CicloEscolar> findCicloEscolarEntries(int firstResult, int maxResults);


	public abstract void saveCicloEscolar(CicloEscolar cicloEscolar);


	public abstract CicloEscolar updateCicloEscolar(CicloEscolar cicloEscolar);

}
