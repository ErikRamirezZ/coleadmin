package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Concepto;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.Concepto.class })
public interface ConceptoService {

	public abstract long countAllConceptoes();


	public abstract void deleteConcepto(Concepto concepto);


	public abstract Concepto findConcepto(Long id);


	public abstract List<Concepto> findAllConceptoes();


	public abstract List<Concepto> findConceptoEntries(int firstResult, int maxResults);


	public abstract void saveConcepto(Concepto concepto);


	public abstract Concepto updateConcepto(Concepto concepto);

}
