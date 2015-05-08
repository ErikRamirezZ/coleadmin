package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import com.raze.coleadmin.repository.domain.ConfiguracionPagoEscuelaRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionPagoEscuelaServiceImpl implements ConfiguracionPagoEscuelaService {

	@Autowired
    ConfiguracionPagoEscuelaRepository configuracionPagoEscuelaRepository;
	
	Date date = new Date();

	public long countAllConfiguracionPagoEscuelas() {
        return configuracionPagoEscuelaRepository.count();
    }

	public void deleteConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela) {
        configuracionPagoEscuelaRepository.delete(configuracionPagoEscuela);
    }

	public ConfiguracionPagoEscuela findConfiguracionPagoEscuela(Long id) {
        return configuracionPagoEscuelaRepository.findOne(id);
    }

	public List<ConfiguracionPagoEscuela> findAllConfiguracionPagoEscuelas() {
        return configuracionPagoEscuelaRepository.findAll();
    }

	public List<ConfiguracionPagoEscuela> findConfiguracionPagoEscuelaEntries(int firstResult, int maxResults) {
        return configuracionPagoEscuelaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela) {
		configuracionPagoEscuela.setUsuario(Authenticated.getUsuario());
		configuracionPagoEscuela.setFechaCreacion(date);
		configuracionPagoEscuela.setActivo(true);
        configuracionPagoEscuelaRepository.save(configuracionPagoEscuela);
    }

	public ConfiguracionPagoEscuela updateConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela) {
		configuracionPagoEscuela.setUsuario(Authenticated.getUsuario());
		configuracionPagoEscuela.setFechaModificacion(date);
		configuracionPagoEscuela.setActivo(true);
        return configuracionPagoEscuelaRepository.save(configuracionPagoEscuela);
    }
	
	public ConfiguracionPagoEscuela logicalDeleteConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela) {
		configuracionPagoEscuela.setUsuario(Authenticated.getUsuario());
		configuracionPagoEscuela.setFechaModificacion(date);
		configuracionPagoEscuela.setActivo(false);
        return configuracionPagoEscuelaRepository.save(configuracionPagoEscuela);
    }
	
}

