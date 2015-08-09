package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.ConfiguracionCurso.class })
public interface ConfiguracionCursoService {

	public abstract long countAllConfiguracionCursoes();


	public abstract void deleteConfiguracionCurso(ConfiguracionCurso configuracionCurso);


	public abstract ConfiguracionCurso findConfiguracionCurso(Long id);


	public abstract List<ConfiguracionCurso> findAllConfiguracionCursoes();


	public abstract List<ConfiguracionCurso> findConfiguracionCursoEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionCurso(ConfiguracionCurso configuracionCurso);


	public abstract ConfiguracionCurso updateConfiguracionCurso(ConfiguracionCurso configuracionCurso);

}
