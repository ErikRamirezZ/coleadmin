package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.ConfiguracionCurso;
import com.raze.coleadmin.repository.domain.ConfiguracionCursoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionCursoServiceImpl implements ConfiguracionCursoService {

	@Autowired
    ConfiguracionCursoRepository configuracionCursoRepository;
	
	Date date = new Date();

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
		configuracionCurso.setUsuario(Authenticated.getUsuario());
		configuracionCurso.setFechaCreacion(date);
		configuracionCurso.setActivo(true);
        configuracionCursoRepository.save(configuracionCurso);
    }

	public ConfiguracionCurso updateConfiguracionCurso(ConfiguracionCurso configuracionCurso) {
		configuracionCurso.setUsuario(Authenticated.getUsuario());
		configuracionCurso.setFechaModificacion(date);
		configuracionCurso.setActivo(true);
        return configuracionCursoRepository.save(configuracionCurso);
    }

	public ConfiguracionCurso logicalDeleteConfiguracionCurso(ConfiguracionCurso configuracionCurso) {
		configuracionCurso.setUsuario(Authenticated.getUsuario());
		configuracionCurso.setFechaModificacion(date);
		configuracionCurso.setActivo(false);
        return configuracionCursoRepository.save(configuracionCurso);
    }

}
