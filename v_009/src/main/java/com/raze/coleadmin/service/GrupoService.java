package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Grupo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Grupo.class })
public interface GrupoService {

	public abstract long countAllGrupoes();


	public abstract void deleteGrupo(Grupo grupo);


	public abstract Grupo findGrupo(Long id);


	public abstract List<Grupo> findAllGrupoes();


	public abstract List<Grupo> findGrupoEntries(int firstResult, int maxResults);


	public abstract void saveGrupo(Grupo grupo);


	public abstract Grupo updateGrupo(Grupo grupo);

}
