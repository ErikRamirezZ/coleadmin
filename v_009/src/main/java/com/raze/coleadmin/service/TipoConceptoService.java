package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.TipoConcepto;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.TipoConcepto.class })
public interface TipoConceptoService {

	public abstract long countAllTipoConceptoes();


	public abstract void deleteTipoConcepto(TipoConcepto tipoConcepto);


	public abstract TipoConcepto findTipoConcepto(Long id);


	public abstract List<TipoConcepto> findAllTipoConceptoes();


	public abstract List<TipoConcepto> findTipoConceptoEntries(int firstResult, int maxResults);


	public abstract void saveTipoConcepto(TipoConcepto tipoConcepto);


	public abstract TipoConcepto updateTipoConcepto(TipoConcepto tipoConcepto);

}
