package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import com.raze.coleadmin.repository.ConfiguracionPagoEscuelaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionPagoEscuelaServiceImpl implements ConfiguracionPagoEscuelaService {

	@Autowired
    ConfiguracionPagoEscuelaRepository configuracionPagoEscuelaRepository;

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
        configuracionPagoEscuelaRepository.save(configuracionPagoEscuela);
    }

	public ConfiguracionPagoEscuela updateConfiguracionPagoEscuela(ConfiguracionPagoEscuela configuracionPagoEscuela) {
        return configuracionPagoEscuelaRepository.save(configuracionPagoEscuela);
    }
}
