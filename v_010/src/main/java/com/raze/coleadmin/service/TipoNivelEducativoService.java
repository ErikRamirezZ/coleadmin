package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.TipoNivelEducativo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.TipoNivelEducativo.class })
public interface TipoNivelEducativoService {

	public abstract long countAllTipoNivelEducativoes();


	public abstract void deleteTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo);


	public abstract TipoNivelEducativo findTipoNivelEducativo(Long id);


	public abstract List<TipoNivelEducativo> findAllTipoNivelEducativoes();


	public abstract List<TipoNivelEducativo> findTipoNivelEducativoEntries(int firstResult, int maxResults);


	public abstract void saveTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo);


	public abstract TipoNivelEducativo updateTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo);

}
