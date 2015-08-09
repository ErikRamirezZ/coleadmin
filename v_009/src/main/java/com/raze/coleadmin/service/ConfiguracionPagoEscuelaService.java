package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.ConfiguracionPagoEscuela.class })
public interface ConfiguracionPagoEscuelaService {

	public abstract long countAllConfiguracionPagoEscuelas();


	public abstract void deleteConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);


	public abstract ConfiguracionPagoEscuela findConfiguracionPagoEscuela(Long id);


	public abstract List<ConfiguracionPagoEscuela> findAllConfiguracionPagoEscuelas();


	public abstract List<ConfiguracionPagoEscuela> findConfiguracionPagoEscuelaEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);


	public abstract ConfiguracionPagoEscuela updateConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela);

}
