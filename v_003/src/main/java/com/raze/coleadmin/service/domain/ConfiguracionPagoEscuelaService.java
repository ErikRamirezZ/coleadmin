package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import java.util.List;

public interface ConfiguracionPagoEscuelaService {

	public abstract long countAllConfiguracionPagoEscuelas();


	public abstract void deleteConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);


	public abstract ConfiguracionPagoEscuela findConfiguracionPagoEscuela(Long id);


	public abstract List<ConfiguracionPagoEscuela> findAllConfiguracionPagoEscuelas();


	public abstract List<ConfiguracionPagoEscuela> findConfiguracionPagoEscuelaEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);


	public abstract ConfiguracionPagoEscuela updateConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);


	public abstract ConfiguracionPagoEscuela logicalDeleteConfiguracionPagoEscuela(
			ConfiguracionPagoEscuela configuracionPagoEscuela);

}
