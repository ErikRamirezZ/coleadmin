package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.EstatusCargo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.EstatusCargo.class })
public interface EstatusCargoService {

	public abstract long countAllEstatusCargoes();


	public abstract void deleteEstatusCargo(EstatusCargo estatusCargo);


	public abstract EstatusCargo findEstatusCargo(Long id);


	public abstract List<EstatusCargo> findAllEstatusCargoes();


	public abstract List<EstatusCargo> findEstatusCargoEntries(int firstResult, int maxResults);


	public abstract void saveEstatusCargo(EstatusCargo estatusCargo);


	public abstract EstatusCargo updateEstatusCargo(EstatusCargo estatusCargo);

}
