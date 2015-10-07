package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.TipoAsistencia;
import com.raze.coleadmin.repository.TipoAsistenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoAsistenciaServiceImpl implements TipoAsistenciaService {

	@Autowired
    TipoAsistenciaRepository tipoAsistenciaRepository;

	public long countAllTipoAsistencias() {
        return tipoAsistenciaRepository.count();
    }

	public void deleteTipoAsistencia(TipoAsistencia tipoAsistencia) {
        tipoAsistenciaRepository.delete(tipoAsistencia);
    }

	public TipoAsistencia findTipoAsistencia(Long id) {
        return tipoAsistenciaRepository.findOne(id);
    }

	public List<TipoAsistencia> findAllTipoAsistencias() {
        return tipoAsistenciaRepository.findAll();
    }

	public List<TipoAsistencia> findTipoAsistenciaEntries(int firstResult, int maxResults) {
        return tipoAsistenciaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveTipoAsistencia(TipoAsistencia tipoAsistencia) {
        tipoAsistenciaRepository.save(tipoAsistencia);
    }

	public TipoAsistencia updateTipoAsistencia(TipoAsistencia tipoAsistencia) {
        return tipoAsistenciaRepository.save(tipoAsistencia);
    }
}
