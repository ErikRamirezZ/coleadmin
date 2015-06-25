package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.ConfiguracionCurso;
import com.raze.coleadmin.repository.ConfiguracionCursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionCursoServiceImpl implements ConfiguracionCursoService {

	@Autowired
    ConfiguracionCursoRepository configuracionCursoRepository;

	public long countAllConfiguracionCursoes() {
        return configuracionCursoRepository.count();
    }

	public void deleteConfiguracionCurso(ConfiguracionCurso configuracionCurso) {
        configuracionCursoRepository.delete(configuracionCurso);
    }

	public ConfiguracionCurso findConfiguracionCurso(Long id) {
        return configuracionCursoRepository.findOne(id);
    }

	public List<ConfiguracionCurso> findAllConfiguracionCursoes() {
        return configuracionCursoRepository.findAll();
    }

	public List<ConfiguracionCurso> findConfiguracionCursoEntries(int firstResult, int maxResults) {
        return configuracionCursoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConfiguracionCurso(ConfiguracionCurso configuracionCurso) {
        configuracionCursoRepository.save(configuracionCurso);
    }

	public ConfiguracionCurso updateConfiguracionCurso(ConfiguracionCurso configuracionCurso) {
        return configuracionCursoRepository.save(configuracionCurso);
    }
}
