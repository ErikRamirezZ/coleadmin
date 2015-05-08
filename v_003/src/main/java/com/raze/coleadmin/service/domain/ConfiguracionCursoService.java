package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import java.util.List;

public interface ConfiguracionCursoService {

	public abstract long countAllConfiguracionCursoes();


	public abstract void deleteConfiguracionCurso(ConfiguracionCurso configuracionCurso);


	public abstract ConfiguracionCurso findConfiguracionCurso(Long id);


	public abstract List<ConfiguracionCurso> findAllConfiguracionCursoes();


	public abstract List<ConfiguracionCurso> findConfiguracionCursoEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionCurso(ConfiguracionCurso configuracionCurso);


	public abstract ConfiguracionCurso updateConfiguracionCurso(ConfiguracionCurso configuracionCurso);


	public abstract ConfiguracionCurso logicalDeleteConfiguracionCurso(
			ConfiguracionCurso configuracionCurso);

}
