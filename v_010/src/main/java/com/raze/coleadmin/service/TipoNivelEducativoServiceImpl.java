package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.TipoNivelEducativo;
import com.raze.coleadmin.repository.TipoNivelEducativoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoNivelEducativoServiceImpl implements TipoNivelEducativoService {

	@Autowired
    TipoNivelEducativoRepository tipoNivelEducativoRepository;

	public long countAllTipoNivelEducativoes() {
        return tipoNivelEducativoRepository.count();
    }

	public void deleteTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo) {
        tipoNivelEducativoRepository.delete(tipoNivelEducativo);
    }

	public TipoNivelEducativo findTipoNivelEducativo(Long id) {
        return tipoNivelEducativoRepository.findOne(id);
    }

	public List<TipoNivelEducativo> findAllTipoNivelEducativoes() {
        return tipoNivelEducativoRepository.findAll();
    }

	public List<TipoNivelEducativo> findTipoNivelEducativoEntries(int firstResult, int maxResults) {
        return tipoNivelEducativoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo) {
        tipoNivelEducativoRepository.save(tipoNivelEducativo);
    }

	public TipoNivelEducativo updateTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo) {
        return tipoNivelEducativoRepository.save(tipoNivelEducativo);
    }
}
